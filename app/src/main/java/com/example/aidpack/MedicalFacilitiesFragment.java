package com.example.aidpack;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.concurrent.locks.ReentrantLock;

public class MedicalFacilitiesFragment extends Fragment {
    LocationRequest locationRequest;
    double mDestinationLat;
    double mDestinationLong;
    double userLat, userLong;
    int REQUEST_CODE = 1;
    int REQUEST_CHECK_SETTING = 1001;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medical_facilities, container, false);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireContext());

        Button _btnGraceMemorial = view.findViewById(R.id.btn_Direction_Grace_Memorial);
        Button _btnUnified = view.findViewById(R.id.btn_Direction_Unified);
        Button _btnGraceMemorialMaternity = view.findViewById(R.id.btn_Direction_Grace_Memorial_Maternity);
        Button _btnCentralle =  view.findViewById(R.id.btn_Direction_Centralle_Medical);
        Button _btnFernandoEyeClinic =  view.findViewById(R.id.btn_Direction_Fernando_Eye_Clinic);
        Button _btnGubatan =  view.findViewById(R.id.btn_Direction_Gubatan_Medical);
        Button _btnPadrePio =  view.findViewById(R.id.btn_Direction_Padre_Pio);
        Button _btnPolycare =  view.findViewById(R.id.btn_Direction_Polycare);
        Button _btnPhysicalTheraphy =  view.findViewById(R.id.btn_Direction_Physical_Theraphy);
        Button _btnVGchildrenClinic =  view.findViewById(R.id.btn_Direction_VGChildren_Clinic);
        Button _btnDBVL =  view.findViewById(R.id.btn_Direction_DBVL);
        Button _btnHernandezSkinCare =  view.findViewById(R.id.btn_Direction_Hernandez_Skin_Care);
        Button _btnGalelaMultiSpecialty =  view.findViewById(R.id.btn_Direction_Galela_Multi_Specialty);
        Button _btnNacDentalClinic =  view.findViewById(R.id.btn_Direction_NAC_Dental_Clinic);
        Button _btnGalvezDentalClinic =  view.findViewById(R.id.btn_Direction_Galvez_Dental_Clinic);
        Button _btnSolinDentalClinic =  view.findViewById(R.id.btn_Direction_Solin_Dental_Clinic);
        Button _btnRfbDentalClinic =  view.findViewById(R.id.btn_Direction_RFB_Dental_Clinic);
        Button _btnMiraculousUltraSound =  view.findViewById(R.id.btn_Direction_Miraculous_Ultrasound);
        Button _btnCocolifeClinic =  view.findViewById(R.id.btn_Direction_Cocolife_Clinic);

        _btnGraceMemorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.829332;
                mDestinationLong = 120.904965;
                RequestLocationPermission();
            }
        });
        _btnUnified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.819043;
                mDestinationLong = 120.904192;
                RequestLocationPermission();
            }
        });
        _btnGraceMemorialMaternity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.823275;
                mDestinationLong = 120.912990;
                RequestLocationPermission();
            }
        });
        _btnCentralle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.818504;
                mDestinationLong = 120.906574;
                RequestLocationPermission();
            }
        });
        _btnFernandoEyeClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.822237;
                mDestinationLong = 120.903913;
                RequestLocationPermission();
            }
        });
        _btnGubatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.836218;
                mDestinationLong = 120.904729;
                RequestLocationPermission();
            }
        });
        _btnPadrePio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.818462;
                mDestinationLong = 120.905930;
                RequestLocationPermission();
            }
        });
        _btnPolycare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.821822;
                mDestinationLong = 120.903613;
                RequestLocationPermission();
            }
        });
        _btnPhysicalTheraphy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.827879;
                mDestinationLong = 120.905029;
                RequestLocationPermission();
            }
        });
        _btnVGchildrenClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.830243;
                mDestinationLong = 120.904342;
                RequestLocationPermission();
            }
        });
        _btnDBVL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.820950;
                mDestinationLong = 120.904600;
                RequestLocationPermission();
            }
        });
        _btnHernandezSkinCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.819872;
                mDestinationLong = 120.905372;
                RequestLocationPermission();
            }
        });
        _btnGalelaMultiSpecialty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.820784;
                mDestinationLong = 120.903870;
                RequestLocationPermission();
            }
        });
        _btnNacDentalClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.819083;
                mDestinationLong = 120.905973;
                RequestLocationPermission();
            }
        });
        _btnGalvezDentalClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.825679;
                mDestinationLong = 120.899107;
                RequestLocationPermission();
            }
        });
        _btnSolinDentalClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.819290;
                mDestinationLong = 120.905501;
                RequestLocationPermission();
            }
        });
        _btnRfbDentalClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.819498;
                mDestinationLong = 120.904943;
                RequestLocationPermission();
            }
        });
        _btnMiraculousUltraSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.818212;
                mDestinationLong = 120.906488;
                RequestLocationPermission();
            }
        });
        _btnCocolifeClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDestinationLat = 14.819166;
                mDestinationLong = 120.905544;
                RequestLocationPermission();
            }
        });

        return view;
    }


    private void locationTurnOn(){
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(3000);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);

        Task<LocationSettingsResponse> result = LocationServices.getSettingsClient(requireContext())
                .checkLocationSettings(builder.build());
        result.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            @Override
            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {
                try {
                    LocationSettingsResponse response = task.getResult(ApiException.class);
                } catch (ApiException e) {
                    switch (e.getStatusCode()){
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                            try {
                                ResolvableApiException resolvableApiException = (ResolvableApiException)e;
                                resolvableApiException.startResolutionForResult(requireActivity(), REQUEST_CHECK_SETTING);
                            } catch (IntentSender.SendIntentException sendIntentException) {
                                sendIntentException.printStackTrace();
                            }
                            break;
                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            Toast.makeText(getContext(), "No location detected", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }
        });
    }

    private void RequestLocationPermission(){
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) {
                new AlertDialog.Builder(getContext())
                        .setTitle("Permission Required")
                        .setMessage("This is required to get your location.")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
                            }
                        })
                        .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create()
                        .show();
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            }
        } else {
            locationTurnOn();
            if(isNetworkAvailable()){
                fusedLocationProviderClient.getLastLocation().addOnSuccessListener(requireActivity(), new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            userLat = location.getLatitude();
                            userLong = location.getLongitude();
                            DisplayTrack(userLat, userLong, mDestinationLat, mDestinationLong);
                        }
                    }
                });
            }else{
                Toast.makeText(getContext(), "Internet Required", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void DisplayTrack(double userLAT, double userLONG, double destinationLat, double destinationLong){
        try {
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + userLAT + "," + userLONG + "/" + destinationLat + "," + destinationLong);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private boolean isNetworkAvailable(){
        ConnectivityManager connectivityManager = (ConnectivityManager) requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }


}