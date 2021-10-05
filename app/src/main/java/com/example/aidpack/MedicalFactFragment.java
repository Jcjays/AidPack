package com.example.aidpack;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MedicalFactFragment extends Fragment {
    TextView _txtFacts;
    String[] _listOfFacts;
    Button _btnNext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medical_fact, container, false);
        Random rand = new Random();
        _txtFacts = view.findViewById(R.id.medical_facts_content);
        _listOfFacts = getResources().getStringArray(R.array.array_medical_facts);
        _txtFacts.setText(_listOfFacts[rand.nextInt(_listOfFacts.length)]);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Random rand = new Random();
        _txtFacts = getView().findViewById(R.id.medical_facts_content);
        _btnNext = getView().findViewById(R.id.btn_next_medical_facts);
        _listOfFacts = getResources().getStringArray(R.array.array_medical_facts);
        _btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = rand.nextInt(_listOfFacts.length);
                _txtFacts.setText(_listOfFacts[x]);
            }
        });

    }
}