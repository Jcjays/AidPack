package com.example.aidpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizResultDisplay extends AppCompatActivity {

    TextView numberOfCorrectAns;
    TextView resultLabel;
    Button exit;
    TextView setHighScore;
    int highScore;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result_display);

        numberOfCorrectAns = findViewById(R.id.TVquizNumberOfCorrectAns);
        resultLabel = findViewById(R.id.TVquizResultLabel);
        exit = findViewById(R.id.btnResultQuizExit);

        Bundle bundle = getIntent().getExtras();
        int perfectScore = bundle.getInt("Perfect");
        int intermediateScore = bundle.getInt("Intermediate");
        int poorScore = bundle.getInt("Poor");

        if(getIntent().hasExtra("Perfect")){
            numberOfCorrectAns.setText(perfectScore +" out of " + getIntent().getIntExtra("quizLength", 0));
            resultLabel.setText("Perfect");
            resultLabel.setTextColor(getResources().getColor(R.color.green));
            highScore = perfectScore;
        }

        if(getIntent().hasExtra("Intermediate")){
            numberOfCorrectAns.setText(intermediateScore +" out of " + getIntent().getIntExtra("quizLength", 0));
            resultLabel.setText("Intermediate");
            resultLabel.setTextColor(getResources().getColor(R.color.yellow));
            highScore = intermediateScore;
        }

        if(getIntent().hasExtra("Poor")){
            numberOfCorrectAns.setText(poorScore +" out of " + getIntent().getIntExtra("quizLength", 0));
            resultLabel.setText("Better luck next time.");
            resultLabel.setTextColor(getResources().getColor(R.color.red));
            highScore = poorScore;
        }

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizResultDisplay.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

}