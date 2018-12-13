package com.example.mercy.flexpay.Activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mercy.flexpay.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class walletActivity extends AppCompatActivity {

    private Button buttonWithdraw,btnLoanRequest;
    LineChartView lineChartView;
    String[] axisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
            "Oct", "Nov", "Dec"};
    int[] yAxisData = {1000, 1000, 30000, 3000, 4000, 3000, 4000, 5000, 6000,6000 , 7000, 7000};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        buttonWithdraw = findViewById(R.id.activity_wallet_btnWithdraw);
        btnLoanRequest = findViewById(R.id.activity_wallet_btnRequest_loan);

        lineChartView = findViewById(R.id.chart);


        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();

        Line line = new Line(yAxisValues).setColor(Color.parseColor("#005B77"));

        for (int i = 0; i < axisData.length; i++) {
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++) {
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }

        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextSize(16);
        axis.setTextColor(Color.parseColor("#005B77"));
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        yAxis.setName("Amount in Shillings");
        yAxis.setTextColor(Color.parseColor("#066e8a"));
        yAxis.setTextSize(16);
        data.setAxisYLeft(yAxis);

        lineChartView.setLineChartData(data);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 10000;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);


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
        startActivity(new Intent(getApplicationContext(),withdrawActivity.class));
        finish();
    /*    Toast.makeText(this, "Unable to withdraw now", Toast.LENGTH_SHORT).show();*/
      /*  AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage("Unable to withdraw now");
        builder.setNegativeButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();*/
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
