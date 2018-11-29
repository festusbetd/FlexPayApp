package com.example.mercy.flexpay.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mercy.flexpay.R;

import java.util.ArrayList;
import java.util.List;

public class BookingActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Spinner spinner_status,spinner_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        spinner_status = findViewById(R.id.activity_booking_spinner_status);
        spinner_show = findViewById(R.id.activity_booking_spinner_status);


        Toolbar mToolbar = (Toolbar) findViewById(R.id.activity_booking_toolbar);
        mToolbar.setTitle(getString(R.string.app_name_booking));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
                finish();
            }
        });

        spinner_status.setOnItemClickListener(this);
        List<String>  status = new ArrayList<String>();
        status.add("Open");
        status.add("Open");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, status);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner_status.setAdapter(dataAdapter);

        spinner_show.setOnItemClickListener(this);

        List<String> status_show = new ArrayList<String>();
        status_show.add("10");
        status_show.add("20");
        status_show.add("30");

        ArrayAdapter<String> dataAdapter_show = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,status_show);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_status.setAdapter(dataAdapter_show);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
// On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }
}
