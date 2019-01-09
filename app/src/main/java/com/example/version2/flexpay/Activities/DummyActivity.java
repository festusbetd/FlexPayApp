package com.example.version2.flexpay.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.version2.flexpay.Api.APIClient;
import com.example.version2.flexpay.Api.APIService;
import com.example.version2.flexpay.Model.Products;
import com.example.version2.flexpay.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DummyActivity extends AppCompatActivity {
    TextView responseText;
    APIService apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        responseText = (TextView) findViewById(R.id.responseText);
        apiInterface = APIClient.getClient().create(APIService.class);

        Call<Products> call2 = apiInterface.doGetProductsList();
        call2.enqueue(new Callback<Products>() {

            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Products products = response.body();
                        List<Products.Datum> productsList = products.data;
                        for (Products.Datum datum : productsList) {
                            Toast.makeText(getApplicationContext(), "id : " + datum.getProduct_name() + " name: " + datum.getProduct_code() + " " + datum.getProduct_short_description() + " avatar: " + datum.getProduct_booking_days(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if (response.code() >= 400 && response.code() < 599) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                                    }

                    } else {

                    Toast.makeText(DummyActivity.this, ""+response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                }

                }
            @Override
            public void onFailure(Call<Products> call, Throwable t) {
                call.cancel();
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}