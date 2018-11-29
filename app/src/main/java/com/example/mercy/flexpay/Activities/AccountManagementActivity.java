package com.example.mercy.flexpay.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mercy.flexpay.R;

public class AccountManagementActivity extends AppCompatActivity {
private Button login_btn;
private Button register_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_management);

        login_btn = findViewById(R.id.account_management_login_btn);
        register_btn = findViewById(R.id.account_management_register_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(AccountManagementActivity.this,LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(AccountManagementActivity.this,SignUpActivity.class);
                startActivity(registerIntent);
            }
        });
    }
}
