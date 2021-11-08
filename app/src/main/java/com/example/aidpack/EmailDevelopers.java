package com.example.aidpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.thecode.aestheticdialogs.AestheticDialog;
import com.thecode.aestheticdialogs.DialogAnimation;
import com.thecode.aestheticdialogs.DialogStyle;
import com.thecode.aestheticdialogs.DialogType;
import com.thecode.aestheticdialogs.OnDialogClickListener;

import java.util.concurrent.RunnableScheduledFuture;

public class EmailDevelopers extends AppCompatActivity {

    EditText mSubject;
    EditText mMessage;
    Button mSendEmail;

    DialogStyle dialogStyle;
    DialogType dialogType;
    DialogAnimation dialogAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_developers);

        mSubject = findViewById(R.id.editTextEmailSubject);
        mMessage = findViewById(R.id.editTextMessage);
        mSendEmail = findViewById(R.id.btnSendEmail);

        mSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
                mSubject.setText("");
                mMessage.setText("");
            }
        });
    }

    private void sendMail() {
        String subject = mSubject.getText().toString();
        String message = mMessage.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"Jcjaysl2k00@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Send Via"));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        AestheticDialog.Builder builder = new AestheticDialog.Builder(
                EmailDevelopers.this, DialogStyle.FLAT, DialogType.SUCCESS
        );
        builder.setTitle("Thank you! for your feedback");
        builder.setMessage("We will make sure to look into your concerns! :)");
        builder.setAnimation(DialogAnimation.SHRINK);
        builder.setGravity(Gravity.CENTER);
        builder.setOnClickListener(new OnDialogClickListener() {
            @Override
            public void onClick(AestheticDialog.Builder builder) {
                Intent intent = new Intent(EmailDevelopers.this, MainActivity.class);
                startActivity(intent);
            }
        });
        builder.show();
    }
}