package com.example.aidpack;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class QuizModule extends AppCompatActivity {
    TextView _questions;
    TextView _time;
    TextView _questionCounter;
    TextView _choiceA,_choiceB,_choiceC, _choiceD;
    LottieAnimationView correctAnim;
    LottieAnimationView wrongAnim;
    Button btnExit;

    int randomizer;
    int[] verify;
    int index;

    private String answer;
    private int score, counter;


    private final QuizObjects quizObjects = new QuizObjects();
    int currentQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_module2);


        _questions = findViewById(R.id.TVquizQuestion);
        _time = findViewById(R.id.TVquizTime);
        _questionCounter = findViewById(R.id.TVquizQuestionCounter);
        _choiceA = findViewById(R.id.btnAnswerNumberOne);
        _choiceB = findViewById(R.id.btnAnswerNumberTwo);
        _choiceC = findViewById(R.id.btnAnswerNumberThree);
        _choiceD = findViewById(R.id.btnAnswerNumberFour);
        btnExit = findViewById(R.id.btnQuizExit);
        correctAnim = findViewById(R.id.animCorrect);
        wrongAnim = findViewById(R.id.animWrong);

        //important methods
        RandomizeQuestion();
        updateQuestion();


        //Start of buttons
        _choiceA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_choiceA.getText() == (answer)){
                    score += 1;
                    counter += 1;
                    updateQuestionCounter(counter);
                    updateScore(score);
                    updateQuestion();
                    correctAnim.playAnimation();
                    correctAnim.setVisibility(View.VISIBLE);

                }else {
                    counter += 1;
                    updateQuestionCounter(counter);
                    updateQuestion();
                    wrongAnim.playAnimation();
                    wrongAnim.setVisibility(View.VISIBLE);
                }
            }
        });

        _choiceB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_choiceB.getText() == answer){
                    score += 1;
                    counter += 1;
                    updateQuestionCounter(counter);
                    updateScore(score);
                    updateQuestion();
                    correctAnim.playAnimation();
                    correctAnim.setVisibility(View.VISIBLE);
                }else {
                    counter += 1;
                    updateQuestionCounter(counter);
                    updateQuestion();
                    wrongAnim.playAnimation();
                    wrongAnim.setVisibility(View.VISIBLE);
                }
            }
        });

        _choiceC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_choiceC.getText() == answer){
                    score += 1;
                    counter += 1;
                    updateQuestionCounter(counter);
                    updateScore(score);
                    updateQuestion();
                    correctAnim.playAnimation();
                    correctAnim.setVisibility(View.VISIBLE);
                }else {
                    counter += 1;
                    updateQuestionCounter(counter);
                    updateQuestion();
                    wrongAnim.playAnimation();
                    wrongAnim.setVisibility(View.VISIBLE);
                }
            }
        });

        _choiceD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_choiceD.getText() == answer){
                    score += 1;
                    counter += 1;
                    updateQuestionCounter(counter);
                    updateScore(score);
                    updateQuestion();
                    correctAnim.playAnimation();
                    correctAnim.setVisibility(View.VISIBLE);

                }else {
                    counter += 1;
                    updateQuestionCounter(counter);
                    updateQuestion();
                    wrongAnim.playAnimation();
                    wrongAnim.setVisibility(View.VISIBLE);
                }
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create exit logic here.
                //1st attempt:

               AlertDialog.Builder alertDialog= new AlertDialog.Builder(QuizModule.this);

                alertDialog.setMessage("Do you want to exit? All your progress will be lost.")
                           .setTitle("Exit")
                            .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(QuizModule.this, "Exiting..", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(QuizModule.this, MainActivity.class);
                        startActivity(intent);
                    }
                })
                            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(QuizModule.this, "Canceling..", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = alertDialog.create();
                dialog.show();

            }
        });

        //end of buttons

        //start of animListeners
        wrongAnim.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                wrongAnim.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                wrongAnim.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        correctAnim.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                    correctAnim.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                    correctAnim.setVisibility(View.GONE);

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }

        });
        //end of animListeners



    }



    @SuppressLint("SetTextI18n")
    private void updateQuestionCounter(int counter) {
        _questionCounter.setText(counter + 1 + " out of " + quizObjects.getQuestionLength());
    }

    @SuppressLint("SetTextI18n")
    private void updateQuestion(){
        if(counter < quizObjects.getQuestionLength()){

            //create a random algorithm without duplicates.(done)
            currentQuestion = verify[randomizer];
            _questions.setText(quizObjects.getQuestion(currentQuestion));

            if(quizObjects.getChoicesLength(currentQuestion)){
                _choiceA.setText(quizObjects.getChoice1(currentQuestion));
                _choiceB.setText(quizObjects.getChoice2(currentQuestion));
                _choiceC.setVisibility(View.INVISIBLE);
                _choiceD.setVisibility(View.INVISIBLE);
            }else{
                _choiceA.setText(quizObjects.getChoice1(currentQuestion));
                _choiceB.setText(quizObjects.getChoice2(currentQuestion));
                _choiceC.setText(quizObjects.getChoice3(currentQuestion));
                _choiceD.setText(quizObjects.getChoice4(currentQuestion));
                _choiceC.setVisibility(View.VISIBLE);
                _choiceD.setVisibility(View.VISIBLE);
            }
            answer = quizObjects.getCorrectAnswer(currentQuestion);
            _questionCounter.setText(counter + 1 + " out of " + quizObjects.getQuestionLength());
            randomizer++;

        }else{
            Toast.makeText(getBaseContext(), "Play lottie animation", Toast.LENGTH_SHORT).show();
            if(score == quizObjects.getQuestionLength()){
                //Perfect Score
                Intent intent = new Intent(QuizModule.this, QuizResultDisplay.class);
                intent.putExtra("Perfect", score);
                intent.putExtra("quizLength", quizObjects.getQuestionLength());
                startActivity(intent);
                finish();
                Toast.makeText(getBaseContext(), "Perfect!", Toast.LENGTH_SHORT).show();
            }else if(score <= 14 && score >= 10){
                //Good Score
                Intent intent = new Intent(QuizModule.this, QuizResultDisplay.class);
                intent.putExtra("Intermediate", score);
                intent.putExtra("quizLength", quizObjects.getQuestionLength());
                startActivity(intent);
                finish();
                Toast.makeText(getBaseContext(), "Intermediate!", Toast.LENGTH_SHORT).show();
            }else{
                //Bad Score
                Intent intent = new Intent(QuizModule.this, QuizResultDisplay.class);
                intent.putExtra("Poor", score);
                intent.putExtra("quizLength", quizObjects.getQuestionLength());
                startActivity(intent);
                Toast.makeText(getBaseContext(), "Study again", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
    private void updateScore(int points){
        score = points;
       _time.setText(String.valueOf(score));
    }

    private void RandomizeQuestion(){
        Random r = new Random();
        verify = new int[quizObjects.getQuestionLength()];

        Set<Integer> uniqueNumbers = new LinkedHashSet<>();
        while (uniqueNumbers.size() < quizObjects.getQuestionLength()){
            uniqueNumbers.add(r.nextInt(quizObjects.getQuestionLength()));
        }
        for(int i : uniqueNumbers){
            verify[index] = i;
            index++;
            System.out.println(i);
        }
    }

}