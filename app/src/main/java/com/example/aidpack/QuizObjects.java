package com.example.aidpack;

public class QuizObjects {

    private final String[] mQuestions = {
            "What is android?",
            "How many sizes are supported by android?",
            "How many threads are there in asyncTask in android?"
    };

    private final String[][] mChoices ={
            {"Android is a stack", "Google mobile device name", "Virtual machine", "None of the above"},
            {"Android supported all size", "Android does not support all size", "Android supports small,normal, large and extra-large sizes", "Size in unidentified"},
            {"Only one", "Two", "AsyncTask doesn't have a thread", "None of the above"},
    };

    private final String[] mAnswerKey = {"Android is a stack", "Android does not support all size", "None of the above"};



    public String getQuestion(int a){
        return mQuestions[a];
    }

    public String getChoice1(int a){
        return mChoices [a][0];
    }

    public String getChoice2(int a){
        return mChoices [a][1];
    }

    public String getChoice3(int a){
        return mChoices [a][2];
    }

    public String getChoice4(int a){
        return mChoices [a][3];
    }

    public String getCorrectAnswer(int a){
        return mAnswerKey [a];
    }
    public  int getQuestionLength(){
        return mQuestions.length;
    }

}
