package com.example.mercy.flexpay.Activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mercy.flexpay.R;

import java.util.Calendar;

public class AddGoalActivity extends AppCompatActivity implements View.OnClickListener {
    private int mYear, mMonth, mDay;
    private  EditText txtDate,txtDate2;
    private  EditText editTextAddGoalName,editTextEnterDescription;
    private  String goalName,goalDescription;
    private  Button btnAddGoal;

    private Context mContext;
    private Activity mActivity;

    private RelativeLayout mRelativeLayout;
    private Button mButton;

    private PopupWindow mPopupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);

        // Get the application context
        mContext = getApplicationContext();

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

         /*   // Get Current Date
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
            datePickerDialog.show();*/


            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

            // Inflate the custom layout/view
            View customView = inflater.inflate(R.layout.custom_layout,null);


            // Initialize a new instance of popup window
            mPopupWindow = new PopupWindow(
                    customView,
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );

            // Set an elevation value for popup window
            // Call requires API level 21
            if(Build.VERSION.SDK_INT>=21){
                mPopupWindow.setElevation(5.0f);
            }

            // Get a reference for the custom view close button
            ImageButton closeButton = (ImageButton) customView.findViewById(R.id.ib_close);

            // Set a click listener for the popup window close button
            closeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Dismiss the popup window
                    mPopupWindow.dismiss();
                }
            });

                /*
                    public void showAtLocation (View parent, int gravity, int x, int y)
                        Display the content view in a popup window at the specified location. If the
                        popup window cannot fit on screen, it will be clipped.
                        Learn WindowManager.LayoutParams for more information on how gravity and the x
                        and y parameters are related. Specifying a gravity of NO_GRAVITY is similar
                        to specifying Gravity.LEFT | Gravity.TOP.

                    Parameters
                        parent : a parent view to get the getWindowToken() token from
                        gravity : the gravity which controls the placement of the popup window
                        x : the popup's x location offset
                        y : the popup's y location offset
                */
            // Finally, show the popup window at the center location of root relative layout
            mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER,0,0);

        }
    }


}
