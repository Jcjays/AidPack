package com.example.aidpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GetStarted extends AppCompatActivity {
    final String KEY_MESSAGE = "GET_STARTED_KEY";
    Button mGetStarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        mGetStarted = findViewById(R.id.btnGetStarted);

        mGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        if(!sharedPreferences.getBoolean(KEY_MESSAGE, false)){
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putBoolean(KEY_MESSAGE, Boolean.TRUE);
            myEdit.apply();
        }else {
            moveToHomePage();
        }
    }

    private void moveToHomePage() {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);

    }
}