package com.example.roshannimje.baseballstadium;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.roshannimje.baseballstadium.datamodel.UserDataModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class SpinnerActivity extends AppCompatActivity {


    FirebaseFirestore database = FirebaseFirestore.getInstance();


    String[] ZONELIST = {"Zone 1", "Zone 2", "Zone 3", "Zone 4"};
    String[] BLOCKLIST = {"Block 1", "Block 2", "Block 3", "Block 4"};
    String[] ROWLIST = {"Row 1", "Row 2", "Row 3", "Row 4"};
    String[] SEATLIST = {"Seat 1", "Seat 2", "Seat 3", "Seat 4"};

    MaterialBetterSpinner materialDesignZoneSpinner, materialDesignBlockSpinner, materialDesignRowSpinner, materialDesignSeatSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        ArrayAdapter<String> zonearrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, ZONELIST);
        materialDesignZoneSpinner = (MaterialBetterSpinner) findViewById(R.id.zonespinner);
        materialDesignZoneSpinner.setAdapter(zonearrayAdapter);


        ArrayAdapter<String> blockarrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, BLOCKLIST);
        materialDesignBlockSpinner = (MaterialBetterSpinner) findViewById(R.id.blockspinner);
        materialDesignBlockSpinner.setAdapter(blockarrayAdapter);

        ArrayAdapter<String> rowarrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, ROWLIST);
        materialDesignRowSpinner = (MaterialBetterSpinner) findViewById(R.id.rowspinner);
        materialDesignRowSpinner.setAdapter(rowarrayAdapter);

        ArrayAdapter<String> seatarrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SEATLIST);
        materialDesignSeatSpinner = (MaterialBetterSpinner) findViewById(R.id.seatspinner);
        materialDesignSeatSpinner.setAdapter(seatarrayAdapter);


    }

    public void onSave(View view) {

        UserDataModel user = new UserDataModel("rutuja", materialDesignZoneSpinner.getText().toString(), materialDesignBlockSpinner.getText().toString(), materialDesignRowSpinner.getText().toString(), materialDesignSeatSpinner.getText().toString());


        database.collection("SeatInfo").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Seat information added successfully", Toast.LENGTH_SHORT).show();
                System.out.print("Hello");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("SpinnerActivity", "" + e.getMessage());
                Toast.makeText(getApplicationContext(), "Error while adding information" , Toast.LENGTH_SHORT).show();
            }
        });

    }
}
