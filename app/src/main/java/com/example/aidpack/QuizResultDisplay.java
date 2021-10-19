package com.example.aidpack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class QuizResultDisplay extends AppCompatActivity {

    TextView numberOfCorrectAns;
    TextView resultLabel;
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result_display);

        numberOfCorrectAns = findViewById(R.id.TVquizNumberOfCorrectAns);
        resultLabel = findViewById(R.id.TVquizResultLabel);
        exit = findViewById(R.id.btnResultQuizExit);

        if(getIntent().hasExtra("Perfect")){
            numberOfCorrectAns.setText(getIntent().getIntExtra("Perfect", 0) +" out of " + getIntent().getIntExtra("quizLength", 0));
            resultLabel.setText("Perfect");
            resultLabel.setTextColor(getResources().getColor(R.color.green));
        }

        if(getIntent().hasExtra("Intermediate")){
            numberOfCorrectAns.setText(getIntent().getIntExtra("Intermediate", 0) +" out of " + getIntent().getIntExtra("quizLength", 0));
            resultLabel.setText("Intermediate");
            resultLabel.setTextColor(getResources().getColor(R.color.yellow));
        }

        if(getIntent().hasExtra("Poor")){
            numberOfCorrectAns.setText(getIntent().getIntExtra("Poor", 0) +" out of " + getIntent().getIntExtra("quizLength", 0));
            resultLabel.setText("Better luck next time.");
            resultLabel.setTextColor(getResources().getColor(R.color.red));
        }


    }
}