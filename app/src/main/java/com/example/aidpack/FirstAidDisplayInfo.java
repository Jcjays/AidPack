package com.example.aidpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FirstAidDisplayInfo extends AppCompatActivity {
    ImageView _title_image;
    Button _button_play;

    TextView _first_description;
    TextView _second_description;
    TextView _third_description;
    TextView _fourth_description;
    TextView _fifth_description;
    TextView _sixth_description;

    String _description_data;
    String _description_data_2;
    String _description_data_3;
    String _description_data_4;
    String _description_data_5;
    String _description_data_6;

    String _links_data;
    int _images_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid_display_info);

        _first_description = findViewById(R.id.first_aid_details_description_1);
        _second_description = findViewById(R.id.first_aid_details_description_2);
        _third_description = findViewById(R.id.first_aid_details_description_3);
        _fourth_description = findViewById(R.id.first_aid_details_description_4);
        _fifth_description = findViewById(R.id.first_aid_details_description_5);
        _sixth_description = findViewById(R.id.first_aid_details_description_6);

        _title_image = findViewById(R.id.first_aid_details_image_1);
        _button_play = findViewById(R.id.btnPlayYoutube);

        getData();
        setData();
    }

    private void setData() {
        _first_description.setText(_description_data);
        _second_description.setText(_description_data_2);
        _third_description.setText(_description_data_3);
        _fourth_description.setText(_description_data_4);
        _fifth_description.setText(_description_data_5);
        _sixth_description.setText(_description_data_6);

        _title_image.setImageResource(_images_data);

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
        if(getIntent().hasExtra("image_1") &&
                getIntent().hasExtra("youtubelinks") &&
                getIntent().hasExtra("description_1")&&
                getIntent().hasExtra("description_2")&&
                getIntent().hasExtra("description_3")&&
                getIntent().hasExtra("description_4")&&
                getIntent().hasExtra("description_5")&&
                getIntent().hasExtra("description_6")){

            _images_data = getIntent().getIntExtra("image_1", 1);
            _links_data = getIntent().getStringExtra("youtubelinks");
            _description_data = getIntent().getStringExtra("description_1");
            _description_data_2 = getIntent().getStringExtra("description_2");
            _description_data_3 = getIntent().getStringExtra("description_3");
            _description_data_4 = getIntent().getStringExtra("description_4");
            _description_data_5 = getIntent().getStringExtra("description_5");
            _description_data_6 = getIntent().getStringExtra("description_6");

        }else{
            Toast.makeText(this, "No data received", Toast.LENGTH_SHORT).show();
        }
    }
}