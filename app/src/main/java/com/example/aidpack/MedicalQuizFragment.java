package com.example.aidpack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MedicalQuizFragment extends Fragment {
    private static final String TAG = "";
    final String NEW_SCORE_EXTRA = "NEW_SCORE";
    TextView mScore;
    Button playQuiz;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medical_quiz, container, false);

        mScore = view.findViewById(R.id.highscore);
        playQuiz = view.findViewById(R.id.btnPlayQuiz);

        playQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuizModule.class);
                startActivity(intent);
            }
        });

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences(NEW_SCORE_EXTRA, Context.MODE_PRIVATE);
        if(!sharedPreferences.getBoolean("Confirm", false)){
            mScore.setVisibility(View.INVISIBLE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("Confirm", true);
            editor.apply();
        }else{

            int score = sharedPreferences.getInt("Score", 0);
            int quizMaxLength = sharedPreferences.getInt("QUIZ_MAX_LENGTH", 0);
            if (sharedPreferences.contains("QUIZ_MAX_LENGTH")){
                mScore.setVisibility(View.VISIBLE);
                mScore.setText("Previous score:\n" + score + " out of " + quizMaxLength);
                if(score == quizMaxLength){
                    playQuiz.setEnabled(false);
                    playQuiz.setBackgroundColor(Color.GRAY);
                    mScore.setText("You already completed the quiz! Congratulations!");
                    Log.d(TAG, "onStart: SCORE IS PERFECT");
                }
            }

        }
    }
}