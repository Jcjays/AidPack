package com.example.aidpack;

import android.app.ApplicationExitInfo;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.L;
import com.thecode.aestheticdialogs.AestheticDialog;
import com.thecode.aestheticdialogs.DialogStyle;
import com.thecode.aestheticdialogs.DialogType;

import org.w3c.dom.Text;

import java.io.File;
import java.util.Objects;

public class HomeFragment extends Fragment implements PopupMenu.OnMenuItemClickListener {

    final String ANDROID_TYPE = "application/vnd.android.package-archive";
    ConstraintLayout home;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView btnSettings = view.findViewById(R.id.btnHomeSetting);
        RelativeLayout btnDonate = view.findViewById(R.id.btnDonateBlood);
        RelativeLayout btnCall911 = view.findViewById(R.id.btnEmergencyCall);
        home = view.findViewById(R.id.homeFragment);

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
            ApplicationInfo api = getContext().getApplicationInfo();
            String apkpath = api.sourceDir;
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType(ANDROID_TYPE);
            intent.putExtra(Intent.EXTRA_SUBJECT,Uri.fromFile(new File(apkpath)));
            intent.putExtra(Intent.EXTRA_TEXT, apkpath);
            startActivity(Intent.createChooser(intent, "ShareVia"));
        }

        if(id == R.id.item2) {
            Intent intent = new Intent(getContext(), EmailDevelopers.class);
            startActivity(intent);
        }

        if(id == R.id.item3) {
            Intent intent = new Intent(getContext(), AboutUs.class);
            startActivity(intent);
        }

        if(id == R.id.item5){
            LocaleHelper.setLocale(getContext(), "en");
            refreshThisLayout();
        }

        if(id == R.id.item6){
            LocaleHelper.setLocale(getContext(), "phi");
            refreshThisLayout();
        }
        return true;
    }

    public void refreshThisLayout(){
        Intent intent = new Intent(getContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}