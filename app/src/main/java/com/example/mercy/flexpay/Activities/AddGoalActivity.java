package com.example.mercy.flexpay.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mercy.flexpay.R;

import java.util.Calendar;

public class AddGoalActivity extends AppCompatActivity implements View.OnClickListener {
    private int mYear, mMonth, mDay;
    private  EditText txtDate,txtDate2;
    private  EditText editTextAddGoalName,editTextEnterDescription;
    private  String goalName,goalDescription;
    private  Button btnAddGoal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.add_goals_toolbar);
        mToolbar.setTitle(getString(R.string.app_name_add_goals));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        editTextAddGoalName = findViewById(R.id.activity_add_goal_add_trip);
        editTextEnterDescription = findViewById(R.id.activity_add_goal_field_active_goals);
        btnAddGoal = findViewById(R.id.activity_add_goal_btn_add_goal);
        txtDate=findViewById(R.id.in_date);
        txtDate2=findViewById(R.id.in_date2);


        txtDate.setOnClickListener(this);
        txtDate2.setOnClickListener(this);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),GoalsActivity.class));
                finish();
            }
        });
            btnAddGoal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goalName = editTextAddGoalName.getText().toString().trim();
                    goalDescription = editTextEnterDescription.getText().toString().trim();

                    if (TextUtils.isEmpty(goalName) ){
                        editTextAddGoalName.setError("Enter a Goal Name");
                        editTextAddGoalName.requestFocus();
                        return;
                    }
                    if (TextUtils.isEmpty(goalDescription)) {
                        editTextEnterDescription.setError("Enter a Goal Description");
                        editTextEnterDescription.requestFocus();
                        return;

                    }
                    else {
                        proceedToAddGoal();
                    }
                }
            });

    }

    private void proceedToAddGoal() {
        Toast.makeText(this, "Proceed To add Goal", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v == txtDate) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        else  if (v == txtDate2) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            txtDate2.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }


}
