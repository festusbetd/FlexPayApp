package com.example.mercy.flexpay.Activities;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mercy.flexpay.R;

public class MainPage extends AppCompatActivity {
     //private LinearLayoutManager layoutManager;
     private TextView activityMainPageTextViewGetStarted;
     private Button activityMainPageButtonLgReserveNow;
     private Button activityMainPageButtonSonyReserveNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        activityMainPageTextViewGetStarted = findViewById(R.id.activity_main_page_button_get_started);
        activityMainPageButtonLgReserveNow = findViewById(R.id.activity_main_page_lg_reserve_now);
        activityMainPageButtonSonyReserveNow = findViewById(R.id.activity_main_page_sony_reserve_now);

        activityMainPageTextViewGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        activityMainPageButtonLgReserveNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        activityMainPageButtonSonyReserveNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    }


