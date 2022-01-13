package com.example.aidpack;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

public class FirstaidListFragment extends Fragment {
    RecyclerView _recycler;
    String[] _title;
    String[] _first_aid_links;

    String[] _first_aid_description_step_1;
    String[] _first_aid_description_step_2;
    String[] _first_aid_description_step_3;
    String[] _first_aid_description_step_4;
    String[] _first_aid_description_step_5;
    String[] _first_aid_description_step_6;

    int NO_DATA = 0;
    int[] _images_of_first_aid_services_title = {R.drawable.cpr, R.drawable.burn,
                    R.drawable.blood, R.drawable.choking, R.drawable.sprain, R.drawable.asthma,
                    R.drawable.broken_bone, R.drawable.recovery, R.drawable.lie_down, R.drawable.wound_care,
                    R.drawable.poison, R.drawable.heart_attack, R.drawable.shocked, R.drawable.stroke,
                    R.drawable.allergy, R.drawable.bites_sting_img, R.drawable.sweets, R.drawable.overdose,
                    R.drawable.eye, R.drawable.head, R.drawable.chiropractic};

    int [] first_aid_description_images_step_1 = {R.drawable.cpr_injury_step_1,R.drawable.burn_injury_step_1,
            R.drawable.bleeding_injury_step_1,R.drawable.choking_injury_step_1,R.drawable.sprains_injury_step_1,R.drawable.asthma_injury_step_1,
            R.drawable.bleeding_injury_step_4,R.drawable.recovery_position_step_1,R.drawable.seizure_injury_step_1,R.drawable.wound_injury_step_1,
            R.drawable.poison_injury_step_1,R.drawable.heart_injury_step_1,R.drawable.shock_injury_step_1,R.drawable.stroke_injury_step_1,
            R.drawable.allergy_injury_step_1,R.drawable.bites_injury_step_1,R.drawable.diabetic_injury_step_1,R.drawable.drug_overdose_injury_step_1,
            R.drawable.eye_injury_step_1,R.drawable.head_injury_step_1,R.drawable.spinal_injury_step_1};

    int [] first_aid_description_images_step_2 = {R.drawable.cpr_injury_step_2,R.drawable.burn_injury_step_2,
            R.drawable.bleeding_injury_step_2,R.drawable.choking_injury_step_2,R.drawable.sprains_injury_step_2,R.drawable.asthma_injury_step_2,
            R.drawable.fracture_injury_step_2,R.drawable.recovery_position_step_2,R.drawable.seizure_injury_step_2,R.drawable.wound_injury_step_2,
            R.drawable.poison_injury_step_2,R.drawable.heart_injury_step_2,NO_DATA,R.drawable.stroke_injury_step_2,
            R.drawable.allergy_injury_step_2,R.drawable.bites_injury_step_2,R.drawable.diabetic_injury_step_2,R.drawable.drug_overdose_injury_step_2,
            R.drawable.eye_injury_step_2,R.drawable.head_injury_step_2,R.drawable.spinal_injury_step_2};

    int [] first_aid_description_images_step_3 = {R.drawable.cpr_injury_step_3,R.drawable.burn_injury_step_3,
            R.drawable.bleeding_injury_step_3,R.drawable.choking_injury_step_3,R.drawable.sprains_injury_step_3,R.drawable.asthma_injury_step_3,
            R.drawable.fracture_injury_step_3,R.drawable.recovery_position_step_3,R.drawable.seizure_injury_step_3,R.drawable.wound_injury_step_3,
            R.drawable.poison_injury_step_3,R.drawable.heart_injury_step_3,R.drawable.shock_injury_step_3,R.drawable.stroke_injury_step_3,
            R.drawable.allergy_injury_step_3,R.drawable.bites_injury_step_3,R.drawable.diabetic_injury_step_3,R.drawable.drug_overdose_injury_step_3,
            R.drawable.eye_injury_step_3,R.drawable.head_injury_step_3,R.drawable.spinal_injury_step_3};

    int [] first_aid_description_images_step_4 = {R.drawable.cpr_injury_step_4,R.drawable.burn_injury_step_4,
            R.drawable.bleeding_injury_step_4,R.drawable.choking_injury_step_4,R.drawable.sprains_injury_step_4,R.drawable.spinal_injury_step_1,
            R.drawable.fracture_injury_step_4,R.drawable.recovery_position_step_4,R.drawable.seizure_injury_step_4,R.drawable.wound_injury_step_4,
            NO_DATA,R.drawable.heart_injury_step_4,R.drawable.shock_injury_step_4,R.drawable.stroke_injury_step_4,
            NO_DATA,R.drawable.bites_injury_step_4,NO_DATA,R.drawable.drug_overdose_injury_step_4,
            R.drawable.eye_injury_step_4,R.drawable.head_injury_step_4,R.drawable.spinal_injury_step_4};

    int [] first_aid_description_images_step_5 = {R.drawable.cpr_injury_step_5,R.drawable.burn_injury_step_5,
            NO_DATA,NO_DATA,R.drawable.sprains_injury_step_5,NO_DATA,
            R.drawable.fracture_injury_step_5,R.drawable.recovery_position_step_5,NO_DATA,NO_DATA,
            NO_DATA,R.drawable.heart_injury_step_5,NO_DATA,NO_DATA,
            NO_DATA,R.drawable.bites_injury_step_5,R.drawable.diabetic_injury_step_5,NO_DATA,
            NO_DATA,NO_DATA,NO_DATA};

    int [] first_aid_description_images_step_6 = {NO_DATA,NO_DATA,
            NO_DATA,NO_DATA,NO_DATA,NO_DATA,
            NO_DATA,R.drawable.recovery_position_step_6,NO_DATA,NO_DATA,
            NO_DATA,R.drawable.heart_injury_step_6,NO_DATA,NO_DATA,
            NO_DATA,R.drawable.bites_injury_step_6,NO_DATA,NO_DATA,
            NO_DATA,NO_DATA,NO_DATA};

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        _title = getResources().getStringArray(R.array.list_of_first_aid_services);
        _recycler = requireView().findViewById(R.id.recyclerView);
        _first_aid_links = getResources().getStringArray(R.array.links_of_first_aid_services);

        _first_aid_description_step_1 = getResources().getStringArray(R.array.details_of_first_aid_services);
        _first_aid_description_step_2 = getResources().getStringArray(R.array.details_of_first_aid_services_2);
        _first_aid_description_step_3 = getResources().getStringArray(R.array.details_of_first_aid_services_3);
        _first_aid_description_step_4 = getResources().getStringArray(R.array.details_of_first_aid_services_4);
        _first_aid_description_step_5 = getResources().getStringArray(R.array.details_of_first_aid_services_5);
        _first_aid_description_step_6 = getResources().getStringArray(R.array.details_of_first_aid_services_6);

        MyAdapter adapter = new MyAdapter(getContext(), _title, _images_of_first_aid_services_title,
                _first_aid_description_step_1, _first_aid_description_step_2, _first_aid_description_step_3,
                _first_aid_description_step_4, _first_aid_description_step_5, _first_aid_description_step_6,
                _first_aid_links, _images_of_first_aid_services_title, first_aid_description_images_step_1,
                first_aid_description_images_step_2,first_aid_description_images_step_3,first_aid_description_images_step_4,
                first_aid_description_images_step_5,first_aid_description_images_step_6);

        _recycler.setAdapter(adapter);
        _recycler.setHasFixedSize(true);
        _recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_firstaid_list, container, false);
    }
}