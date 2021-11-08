package com.example.aidpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.aidpack.FirstaidListFragment;
import com.example.aidpack.HotlineFragment;
import com.example.aidpack.MedicalFacilitiesFragment;
import com.example.aidpack.MedicalFactFragment;
import com.example.aidpack.MedicalQuizFragment;
import com.example.aidpack.R;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {
        MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.medical_fact_check));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.medilcal_quiz));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.first_aid_services));
        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.medical_facilities_location));
        bottomNavigation.add(new MeowBottomNavigation.Model(6, R.drawable.medical_hotline));
        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
                switch (item.getId()){
                    case 1:
                        fragment = new HomeFragment();
                        break;
                    case 2:
                        fragment = new MedicalFactFragment();
                        break;
                    case 3:
                        fragment = new MedicalQuizFragment();
                        break;
                    case 4:
                        fragment = new FirstaidListFragment();
                        break;
                    case 5:
                        fragment = new MedicalFacilitiesFragment();
                        break;
                    case 6:
                        fragment = new HotlineFragment();
                        break;
                }
                loadFragment(fragment);
            }
        });

        bottomNavigation.show(1, true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame_layout, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {

    }
}