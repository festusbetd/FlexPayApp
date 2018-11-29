package com.example.mercy.flexpay.Activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mercy.flexpay.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button getStartedButton;
    private Button setGoalsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        getStartedButton = findViewById(R.id.activity_content_btnAddGoals);
        setGoalsButton = findViewById(R.id.activity_dashboard_btn_setup_goals);
        setGoalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddGoalActivity.class);
                startActivity(intent);
            }
        });

        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddGoalActivity.class);
                startActivity(intent);
            }
        });
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
       // jsoncall();
        // Spinner element
        Spinner spinner =  findViewById(R.id.spinner);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Category 1");
        categories.add("Category 2");
        categories.add("Category 3");
        categories.add("Category 4");

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
        products_types.add("Products Type_1");
        products_types.add("Products Type_2");
        products_types.add("Products Type_3");
        products_types.add("Products Type_4");
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
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

      //  initProductViews();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_signout) {
            //Toast.makeText(this, "Sign Out Clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashboardActivity.this,DummyActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_wallet) {
            Intent walletIntent = new Intent(DashboardActivity.this,walletActivity.class);
            startActivity(walletIntent);
            return true;
        }
        else if (id == R.id.nav_goals) {
            Intent goalsIntent = new Intent(DashboardActivity.this,GoalsActivity.class);
            startActivity(goalsIntent);
            return true;
        }
        else if (id == R.id.nav_booking) {
            Intent bookingIntent = new Intent(DashboardActivity.this,BookingActivity.class);
            startActivity(bookingIntent);
            return true;
        }
        else if (id == R.id.nav_deals) {
            Toast.makeText(this, "DealsClicked", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_profile) {
            Intent dealsIntent = new Intent(getApplicationContext(),ProfileActivity.class);
            startActivity(dealsIntent);
            return true;
        }
      /*  else if (id == R.id.nav_settings) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
            builder.setTitle("Error");
            builder.setMessage("No settings activity");
            builder.setNegativeButton("OK", null);
            AlertDialog dialog = builder.create();
            dialog.show();
            return true;
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
