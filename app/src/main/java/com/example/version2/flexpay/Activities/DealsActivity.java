package com.example.version2.flexpay.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.version2.flexpay.R;

import java.util.ArrayList;
import java.util.List;

public class DealsActivity extends AppCompatActivity {

    private Button sonyReserve,lgReserve,otherReserve;
    final Context context = this;
    private TextView lg,sony,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.activity_deals_toolbar);

        lgReserve= findViewById(R.id.activity_deals_page_lg_reserve_now);
        sonyReserve = findViewById(R.id.activity_main_page_sony_reserve_now);
        otherReserve = findViewById(R.id.activity_main_page_sony_reserve_now1);

// Spinner element
        Spinner spinner =  findViewById(R.id.spinnerProductsCategory);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Tuskys Deals poa");
        categories.add("Flex Travel");
        categories.add("Jenga pole pole");
        categories.add("Buy motor vehicle");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected" + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Spinner element
        Spinner spinner_products_types =  findViewById(R.id.spinnerProductsTypes);

        // Spinner Drop down elements
        List<String> products_types = new ArrayList<String>();
        products_types.add("Retail Deals");
        products_types.add("Travel Deals");
        products_types.add("Rent Deals");
        products_types.add("Motor Vehicle Deals");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, products_types);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_products_types.setAdapter(dataAdapter2);
        spinner_products_types.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();

                Toast.makeText(parent.getContext(), "Selected" + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        lg = findViewById(R.id.editTextLg);
        sony = findViewById(R.id.editTextResultSony);
        other = findViewById(R.id.editTextOther);

        lgReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                lgBooking();
            }
        });
        sonyReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                sonyBooking();
            }
        });
        otherReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otherBooking();
            }
        });
        mToolbar.setTitle(getString(R.string.app_name_deals));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
                finish();
            }
        });


    }


    private void lgBooking() {

        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.prompts, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

         final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Book Now",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text
                               String amount = userInput.getText().toString().replaceAll("([0-9]{4})([0-9]{4})", "$1-$2");
                                userInput.setText(amount);

                                int finalAmount =Integer.parseInt(amount);

                                int bal = (139000 - finalAmount);

                               lg.setText("Bal:Ksh "+bal+" within 60 days");
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
    private void sonyBooking() {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.prompts, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Add Booking",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text
                                String amount = userInput.getText().toString().replaceAll("([0-9]{4})([0-9]{4})", "$1-$2");
                                userInput.setText(amount);

                                int finalAmount =Integer.parseInt(amount);

                                int bal = (115000 - finalAmount);

                                sony.setText("Bal:Ksh "+bal+" within 60 days");
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
    private void otherBooking() {
// get prompts.xml view
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.prompts, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text
                                String amount = userInput.getText().toString().replaceAll("([0-9]{4})([0-9]{4})", "$1-$2");
                                userInput.setText(amount);

                                int finalAmount =Integer.parseInt(amount);
                                int bal = (85000 - finalAmount);
                                other.setText("Bal:Ksh "+bal+" within 60 days");
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }


}
