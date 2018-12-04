package com.example.mercy.flexpay.Activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mercy.flexpay.R;

public class walletActivity extends AppCompatActivity {

    private Button buttonWithdraw,btnLoanRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        buttonWithdraw = findViewById(R.id.activity_wallet_btnWithdraw);
        btnLoanRequest = findViewById(R.id.activity_wallet_btnRequest_loan);

        buttonWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                proceedWithdraw();

            }
        });
        btnLoanRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                proceedRequestLoan();

            }
        });

        Toolbar mToolbar = (Toolbar) findViewById(R.id.wallet_toolbar);
        mToolbar.setTitle(getString(R.string.app_name_wallet));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
                finish();
            }
        });
    }

    private void proceedWithdraw() {
    /*    Toast.makeText(this, "Unable to withdraw now", Toast.LENGTH_SHORT).show();*/
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage("Unable to withdraw now");
        builder.setNegativeButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void proceedRequestLoan() {
        /*Toast.makeText(this, "Unable to borrow loan", Toast.LENGTH_SHORT).show();*/
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage("Unable to Borrow now");
        builder.setNegativeButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
