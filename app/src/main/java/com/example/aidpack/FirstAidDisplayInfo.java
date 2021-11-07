package com.example.aidpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class FirstAidDisplayInfo extends AppCompatActivity {
    private ImageView _title_image;
    private Button _button_play;

    private TextView _first_description;
    private TextView _second_description;
    private TextView _third_description;
    private TextView _fourth_description;
    private TextView _fifth_description;
    private TextView _sixth_description;

    private String _description_data;
    private String _description_data_2;
    private String _description_data_3;
    private String _description_data_4;
    private String _description_data_5;
    private String _description_data_6;

    private String _links_data;

    private int _header_image;
    private int _step1_image;
    private int _step2_image;
    private int _step3_image;
    private int _step4_image;
    private int _step5_image;
    private int _step6_image;

    private ImageView _first_image;
    private ImageView _second_image;
    private ImageView _third_image;
    private ImageView _fourth_image;
    private ImageView _fifth_image;
    private ImageView _sixth_image;

    private TextToSpeech mTTs;
    private Button mSpeak;

    private boolean mTurnOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid_display_info);
        //hooks
        _first_description = findViewById(R.id.first_aid_details_description_1);
        _second_description = findViewById(R.id.first_aid_details_description_2);
        _third_description = findViewById(R.id.first_aid_details_description_3);
        _fourth_description = findViewById(R.id.first_aid_details_description_4);
        _fifth_description = findViewById(R.id.first_aid_details_description_5);
        _sixth_description = findViewById(R.id.first_aid_details_description_6);

        _first_image = findViewById(R.id.first_aid_details_image_2);
        _second_image = findViewById(R.id.first_aid_details_image_3);
        _third_image = findViewById(R.id.first_aid_details_image_4);
        _fourth_image = findViewById(R.id.first_aid_details_image_5);
        _fifth_image = findViewById(R.id.first_aid_details_image_6);
        _sixth_image = findViewById(R.id.first_aid_details_image_7);

        _title_image = findViewById(R.id.first_aid_details_image_1);
        _button_play = findViewById(R.id.btnPlayYoutube);

        mSpeak = findViewById(R.id.btnSpeak);

        getData();
        setData();
        initializeTextToSpeech();

        mSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTurnOn){
                    speak();
                    mSpeak.setBackgroundResource(R.drawable.ic_baseline_stop_24);
                    mTurnOn = false;
                }else{
                    stop();
                    mTurnOn = true;
                    mSpeak.setBackgroundResource(R.drawable.ic_baseline_mic_24);
                }
            }
        });

    } //on create



    private void initializeTextToSpeech() {
        mTTs = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int setLangResult = mTTs.setLanguage(Locale.US);
                    if(setLangResult == TextToSpeech.LANG_MISSING_DATA
                            || setLangResult == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS", "Language not supported");
                        Toast.makeText(FirstAidDisplayInfo.this, "Text-to-speech failed to load", Toast.LENGTH_SHORT).show();
                    }else {
                        mSpeak.setEnabled(true);
                    }
                }else {
                    Log.e("TTS", "Language failed to initialized");
                }
            }
        });
    }

    private void speak() {
        String currentTextToSpeak = _description_data + _description_data_2 + _description_data_3
                + _description_data_4 + _description_data_5 + _description_data_6;

        mTTs.setSpeechRate(-30f);
        mTTs.speak(currentTextToSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }

    private void stop() {
        mTTs.stop();
    }

    @Override
    protected void onDestroy() {
        if(mTTs != null){
            mTTs.stop();
            mTTs.shutdown();
        }
        super.onDestroy();
    }

    private void setData() {
        //setting the data
        _first_description.setText(_description_data);
        _second_description.setText(_description_data_2);
        _third_description.setText(_description_data_3);
        _fourth_description.setText(_description_data_4);
        _fifth_description.setText(_description_data_5);
        _sixth_description.setText(_description_data_6);

        _title_image.setImageResource(_header_image);

        _first_image.setImageResource(_step1_image);
        _second_image.setImageResource(_step2_image);
        _third_image.setImageResource(_step3_image);
        _fourth_image.setImageResource(_step4_image);
        _fifth_image.setImageResource(_step5_image);
        _sixth_image.setImageResource(_step6_image);

        _button_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), youtubePlayer.class);
                intent.putExtra("linkToPlay", _links_data);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        if(getIntent().hasExtra("youtubelinks") &&
                getIntent().hasExtra("description_1")&&
                getIntent().hasExtra("description_2")&&
                getIntent().hasExtra("description_3")&&
                getIntent().hasExtra("description_4")&&
                getIntent().hasExtra("description_5")&&
                getIntent().hasExtra("description_6")&&
                getIntent().hasExtra("header_image")&&
                getIntent().hasExtra("step_1_image")&&
                getIntent().hasExtra("step_2_image")&&
                getIntent().hasExtra("step_3_image")&&
                getIntent().hasExtra("step_4_image")&&
                getIntent().hasExtra("step_5_image")&&
                getIntent().hasExtra("step_6_image")){

            _links_data = getIntent().getStringExtra("youtubelinks");

            _description_data = getIntent().getStringExtra("description_1");
            _description_data_2 = getIntent().getStringExtra("description_2");
            _description_data_3 = getIntent().getStringExtra("description_3");
            _description_data_4 = getIntent().getStringExtra("description_4");
            _description_data_5 = getIntent().getStringExtra("description_5");
            _description_data_6 = getIntent().getStringExtra("description_6");

            _header_image = getIntent().getIntExtra("header_image", 1);
            _step1_image = getIntent().getIntExtra("step_1_image", 1);
            _step2_image = getIntent().getIntExtra("step_2_image", 1);
            _step3_image = getIntent().getIntExtra("step_3_image", 1);
            _step4_image = getIntent().getIntExtra("step_4_image", 1);
            _step5_image = getIntent().getIntExtra("step_5_image", 1);
            _step6_image = getIntent().getIntExtra("step_6_image", 1);

        }else{
            Toast.makeText(this, "No data received", Toast.LENGTH_SHORT).show();
        }
    }
}