package com.example.aidpack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MedicalQuizFragment extends Fragment {
    final String NEW_SCORE_EXTRA = "NEW_SCORE";
    TextView mScore;
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medical_quiz, container, false);

        mScore = view.findViewById(R.id.highscore);
        Button playQuiz = view.findViewById(R.id.btnPlayQuiz);

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
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("Confirm", true);
            editor.apply();
            mScore.setText("Previous score:\n 0 out of 15");
        }else{
            int score = sharedPreferences.getInt("Score", 0);
            mScore.setText("Previous score:\n" + score + " out of 15");
        }
    }
}