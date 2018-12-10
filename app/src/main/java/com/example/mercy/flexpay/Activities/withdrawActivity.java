package com.example.mercy.flexpay.Activities;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),walletActivity.class));
                finish();
            }
        });

        edit_text_withdraw_number = findViewById(R.id.withdrwEditTextPhone);
        withdraw_next =  findViewById(R.id.withdraw_mpesa_btn);

        final TextInputLayout floatingPhoneWithdrawLabel = (TextInputLayout) findViewById(R.id.editTextPhoneTextInputLayoutWithdraw);
        floatingPhoneWithdrawLabel.getEditText().addTextChangedListener(new TextWatcher() {
            // ...
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() > 0 && text.length() < 12) {
                    floatingPhoneWithdrawLabel.setError(getString(R.string.enter_valid_phone_number));
                    floatingPhoneWithdrawLabel.setErrorEnabled(true);
                }
                else if (text.length() > 12) {
                    floatingPhoneWithdrawLabel.setError(getString(R.string.enter_valid_phone_number));
                    floatingPhoneWithdrawLabel.setErrorEnabled(true);
                }
                else {
                    floatingPhoneWithdrawLabel.setErrorEnabled(false);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        withdraw_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             withdraw_no = edit_text_withdraw_number.getText().toString().trim();

            if(TextUtils.isEmpty(withdraw_no)){
                floatingPhoneWithdrawLabel.setError(getString(R.string.enter_phone_number));
                floatingPhoneWithdrawLabel.setErrorEnabled(true);
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
