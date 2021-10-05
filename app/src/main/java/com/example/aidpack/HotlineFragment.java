package com.example.aidpack;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HotlineFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotline, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final String bfp = "tel:09257348169";
        final String pnpGlobe = "tel:09278523232";
        final String bjmp = "tel:(044)3082145";
        final String clinic = "tel:(044)6935808";
        final String dswd = "tel:(044)7690675";
        final String mdrrmc = "tel:(02)9111406";
        final String redcross = "tel:(044)8960568";
        final String meralco = "tel:(044)7951445";


        //hook
        Button btnPnp = getView().findViewById(R.id.btn_Hotline_PNP);
        Button btnBfp = getView().findViewById(R.id.btn_Hotline_BFP);
        Button btnBjmp = getView().findViewById(R.id.btn_hotline_BJMP);
        Button btnClinic = getView().findViewById(R.id.btn_Hotline_Clinic);
        Button btnDswd = getView().findViewById(R.id.btn_Hotline_DSWD);
        Button btnMdrrmc = getView().findViewById(R.id.btn_Hotline_MDRRMC);
        Button btnRedcross = getView().findViewById(R.id.btn_Hotline_RedCross);
        Button btnMeralco = getView().findViewById(R.id.btn_Hotline_Meralco);

        //Listeners

        btnPnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(pnpGlobe));
                startActivity(intent);
            }
        });

        btnBfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(bfp));
                startActivity(intent);
            }
        });

        btnBjmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(bjmp));
                startActivity(intent);
            }
        });

        btnClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(clinic));
                startActivity(intent);
            }
        });

        btnDswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(dswd));
                startActivity(intent);
            }
        });

        btnMdrrmc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(mdrrmc));
                startActivity(intent);
            }
        });

        btnRedcross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(redcross));
                startActivity(intent);
            }
        });


        btnMeralco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(meralco));
                startActivity(intent);
            }
        });
    }
}