package com.example.mercy.flexpay.Activities;

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
import android.widget.Toast;

import com.example.mercy.flexpay.R;

import java.util.ArrayList;
import java.util.List;

public class DealsActivity extends AppCompatActivity {

    private Button sonyReserve,lgReserve,otherReserve;
    final Context context = this;
    private EditText lg,sony,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.activity_deals_toolbar);

        lgReserve= findViewById(R.id.activity_deals_page_lg_reserve_now);
        sonyReserve = findViewById(R.id.activity_main_page_sony_reserve_now);
        otherReserve = findViewById(R.id.activity_main_page_sony_reserve_now1);


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

        //showAddItemDialog(DealsActivity.this);
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

                                int bal = (139000 - finalAmount);

                               lg.setText("Bal:Ksh "+bal);
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

                                int bal = (139000 - finalAmount);

                                sony.setText("Bal:Ksh "+bal);
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

                                int bal = (139000 - finalAmount);

                                other.setText("Bal:Ksh "+bal);
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
