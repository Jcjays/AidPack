package com.example.aidpack;

public class QuizObjects {

    private final String[] mQuestions = {
            "What is RICE stands for in sprain injury?",
            "In case of burns how many minutes do use ice pack?",
            "When a person is experiencing choking what steps you should avoid when the victims can talk?",
            "What is the 1st step for implementing first-aid on victim experiencing bleeding?",
            "What can you used for asthma?",
            "Suck a snake bite to get the venom out.",
            "The cause of anemia is letting sweat dried on your back.",
            "A lack of exercise can cause as many deaths as smoking.",
            "Playing musical instruments can boost your brain.",
            "Peeking on someone who is taking a bath or dressing can cause a stye(kuliti).",
            "On what age you can allow the victim to take pain reliever like aspirin or ibuprofen?",
            "It helps to decrease the enlarging and soothe torment?",
            "How many minutes do smoking can reduce your lifespan?",
            "Women will have a higher chance of getting pregnant with the help of HILOT.",
            "In recovery position what specific step states that \"Kneel at the victim side.\"?",
            "National emergency hotline in the philippines?",
            "Relieved heartburn or stomach-ache  by drinking coffee in the morning.",
            "Agency tasked to prepare for, and respond to. natural calamities, like typhoons and earthquakes.",
            "If you are having a headache, what medicine do you think you can take to relieve the pain.",
            "Exercise can give you energy even when you are tired.",
            "A person can get appendicitis by swallowing seeds or doing heavy work after eating.",
            "Applying toothpaste or butter on burned skin.",
            "How fast the message being sent to your brain when you touch something.",
            "When a new born baby pinches their nose, they can have a pointed nose.",
            "First thing that you need to do when you get stung by a bee or any similar insects?"


    };

    private final String[][] mChoices ={
            {"Roll, Inhale, Care, Evaluate", "Rest, Ice,  Compress, Elevate", "Rest, Inhale, Care, Elevate", "Roll, Ice, Compress, Evaluate"},
            {"5 to 10 minutes", "10 to 15 minutes", "15 to 18 minutes", "15 to 20 minutes"},
            {"Encourage the person to cough", "Reassure the person", "Do not use back blows", "Use back blows"},
            {"Stop the person from panicking and try to create a conversation", "Use any cloth and apply pressure to the bleeding area", "Raise the bleeding part of the are from the heart", "Call an emergency"},
            {"Aspirin", "Biogesic", "Prescribed Inhaler", "None of the Above"},
            {"Myth", "Fact", "", ""},
            {"Myth", "Fact", "", ""},
            {"Myth", "Fact", "", ""},
            {"Myth", "Fact", "", ""},
            {"Myth", "Fact", "", ""},
            {"18 years old and above", "22 years old and above", "16 years old and above", "None of the Above"},
            {"Ice packs", "Toothpaste", "Aspirin", "Antibiotic"},
            {"13", "11", "9", "17"},
            {"Myth", "Fact", "", ""},
            {"STEP 1", "STEP 2", "STEP 3", "STEP 4"},
            {"911", "8080", "143", "8888"},
            {"Myth", "Fact", "", ""},
            {"BFP", "PNP", "BJMP", "MDRRMO"},
            {"Aspirin", "Paracetamol", "Ibuprofen", "B and C"},
            {"Myth", "Fact", "", ""},
            {"Myth", "Fact", "", ""},
            {"Myth", "Fact", "", ""},
            {"20 km/h", "150 km/h", "200 km/h", "500 km/h"},
            {"Myth", "Fact", "", ""},
            {"Do not remove the sting and get to the hospital immediately", "Wash it as fast as you can", "Remove sting", " All of the above"}

    };

    private final String[] mAnswerKey = {"Rest, Ice,  Compress, Elevate", "15 to 20 minutes",
            "Do not use back blows","Stop the person from panicking and try to create a conversation",
            "Prescribed Inhaler", "Myth", "Myth", "Fact", "Fact", "Myth", "16 years old and above","Ice packs","11","Myth","STEP 1",
            "911","Myth", "MDRRMO", "B and C", "Fact", "Myth" ,"Myth" ,"200 km/h", "Myth", "Remove sting"};


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

    public boolean getChoicesLength(int a){
        boolean verify = false;
        if (mChoices[a][2].equals("") && mChoices[a][3].equals("")){
         verify = true;
        }
        return verify;
    }


}
