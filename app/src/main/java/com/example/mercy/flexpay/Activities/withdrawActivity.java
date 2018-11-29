package com.example.mercy.flexpay.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mercy.flexpay.R;

public class withdrawActivity extends AppCompatActivity {

    private EditText edit_text_withdraw_number;
    private Button withdraw_next;
    private String withdraw_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.withdraw_toolbar);
        mToolbar.setTitle(getString(R.string.app_name_withdraw));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        edit_text_withdraw_number = findViewById(R.id.withdrwEditTextPhone);
        withdraw_next =  findViewById(R.id.withdraw_mpesa_btn);

        withdraw_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             withdraw_no = edit_text_withdraw_number.getText().toString().trim();

            if(TextUtils.isEmpty(withdraw_no)){
                edit_text_withdraw_number.setError("Enter the number");
                edit_text_withdraw_number.requestFocus();
            }
            else if(withdraw_no.length()<10){
                edit_text_withdraw_number.setError("Atleast 6 characters");
            }
            else{
                proceesWithdraw();
            }
            }
        });
    }

    private void proceesWithdraw() {
        Toast.makeText(this, "Allow payments", Toast.LENGTH_SHORT).show();
    }
}
