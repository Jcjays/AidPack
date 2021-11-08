package com.example.aidpack;

import android.app.ApplicationExitInfo;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.thecode.aestheticdialogs.AestheticDialog;
import com.thecode.aestheticdialogs.DialogStyle;
import com.thecode.aestheticdialogs.DialogType;

import org.w3c.dom.Text;

import java.io.File;
import java.util.Objects;

public class HomeFragment extends Fragment implements PopupMenu.OnMenuItemClickListener {

    final String ANDROID_TYPE = "application/vnd.android.package-archive";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btnSettings = view.findViewById(R.id.btnHomeSetting);
        Button btnDonate = view.findViewById(R.id.btnDonateBlood);
        Button btnCall911 = view.findViewById(R.id.btnEmergencyCall);


        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });

        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://redcross.org.ph/give-blood/"));
                startActivity(intent);
            }
        });

        btnCall911.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:911"));
                startActivity(intent);
            }
        });

        String[] medicalReminders  = view.getResources().getStringArray(R.array.medical_reminders);
        TextView mReminders = view.findViewById(R.id.homePageRemindersTV);
        TextViewAnimator textViewAnimator = new TextViewAnimator(mReminders, medicalReminders);
        textViewAnimator.startAnimation();
        return view;
    }

    public void showPopup(View v){
        PopupMenu popupMenu = new PopupMenu(getContext(), v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.item1) {
            Toast.makeText(getContext(), "item 1 clicked", Toast.LENGTH_SHORT).show();
            ApplicationInfo api = getContext().getApplicationInfo();
            String apkpath = api.sourceDir;
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType(ANDROID_TYPE);
            intent.putExtra(Intent.EXTRA_SUBJECT,Uri.fromFile(new File(apkpath)));
            intent.putExtra(Intent.EXTRA_TEXT, apkpath);
            startActivity(Intent.createChooser(intent, "ShareVia"));
        }

        if(id == R.id.item2) {
            Toast.makeText(getContext(), "item 2 clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getContext(), EmailDevelopers.class);
            startActivity(intent);
        }

        if(id == R.id.item3) {
            Toast.makeText(getContext(), "item 3 clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getContext(), AboutUs.class);
            startActivity(intent);
        }
        return true;
    }

}