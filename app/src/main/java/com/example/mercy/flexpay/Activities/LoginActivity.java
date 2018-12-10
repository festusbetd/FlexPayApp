package com.example.mercy.flexpay.Activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mercy.flexpay.Api.APIService;
import com.example.mercy.flexpay.Api.APIUrl;
import com.example.mercy.flexpay.BuildConfig;
import com.example.mercy.flexpay.Model.AuthUser;
import com.example.mercy.flexpay.R;
import com.example.mercy.flexpay.helper.SessionManager;
import com.example.mercy.flexpay.helper.Validation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    public static final String ACCESS_TOKEN = "accessToken";
    public static final String REFRESH_TOKEN = "refreshToken";
    private static final String SHARED_PREF_NAME = "customer_profile";
    String access_token, refresh_token;
    String token;
    SharedPreferences prefs;
    SessionManager session;

    private EditText editTextLoginEmail;
    private EditText editTextLoginPin;
    String email, password;
    private Button btnlogin;
    LinearLayout linearLayout;
    TextView textSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_2);

        linearLayout = findViewById(R.id.linearlayout);
        editTextLoginEmail = findViewById(R.id.editTextLoginEmail);
        editTextLoginPin = findViewById(R.id.editTextLoginPin);
        btnlogin = findViewById(R.id.btnlogin);
        textSign = findViewById(R.id.textSign);
        // Font path
        String fontPath = "font/JosefinSans-Light.ttf";
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        // Applying font
        editTextLoginEmail.setTypeface(tf);
        editTextLoginPin.setTypeface(tf);

        final TextInputLayout floatingPasswordLabel = (TextInputLayout) findViewById(R.id.editTextLoginPasswordTextInputLayoutLogin);
        floatingPasswordLabel.getEditText().addTextChangedListener(new TextWatcher() {
            // ...
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() > 0 && text.length() <= 5) {
                    floatingPasswordLabel.setError(getString(R.string.minimum_of_6));
                    floatingPasswordLabel.setErrorEnabled(true);
                }
                else {
                    floatingPasswordLabel.setErrorEnabled(false);
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




        textSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signupIntent);
            }
        });

        // Session Manager
        session = new SessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        token = user.get("access_token");

        if (session.isLoggedIn()) {
            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
            finish();
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (loginValidation()) {
                    email = editTextLoginEmail.getText().toString();
                    password = editTextLoginPin.getText().toString();
                    checkConnection();
//
                } else {


                }
            }
        });

    }

    private boolean loginValidation() {
        boolean ret = true;

        if (!Validation.hasText(editTextLoginEmail)) ret = false;
        if (!Validation.hasText(editTextLoginPin)) ret = false;
        return ret;
    }
    private void loginUser() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing in...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        Call<AuthUser> call = service.loginUser(email, password);

        call.enqueue(new Callback<AuthUser>() {
            @Override
            public void onResponse(Call<AuthUser> call, Response<AuthUser> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                       /* AuthUser authUser = response.body();
                        access_token = authUser.getAccessToken();
                        refresh_token = authUser.getRefreshToken();

                        prefs.edit().putString(ACCESS_TOKEN, access_token).apply();
                        prefs.edit().putString(REFRESH_TOKEN, refresh_token).apply();

                        session.createLoginSession(email, password, access_token);*/
                   //     getCustomerProfile();
                        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                        finish();
                    }

                } else if (response.code() >= 400 && response.code() < 599) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setTitle("Error");
                    builder.setMessage("Wrong username or password");
                    builder.setNegativeButton("OK", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();

                    /*Snackbar snackbar = Snackbar
                            .make(linearLayout, "Wrong username or password", Snackbar.LENGTH_INDEFINITE)
                            .setAction("RETRY", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    loginUser();

                                }
                            });

                    snackbar.show();*/
                } else {
                    Snackbar snackbar = Snackbar
                            .make(linearLayout, "Something went wrong", Snackbar.LENGTH_INDEFINITE)
                            .setAction("RETRY", new View.OnClickListener() {

                                @Override
                                public void onClick(View v) {
                                    loginUser();
                                }
                            });

                    snackbar.show();
                }

            }

            @Override
            public void onFailure(Call<AuthUser> call, Throwable t) {
                progressDialog.dismiss();
                t.printStackTrace();
                Snackbar snackbar = Snackbar
                        .make(linearLayout, " " + (t), Snackbar.LENGTH_INDEFINITE)
                        .setAction("RETRY", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                loginUser();
                            }
                        });

                snackbar.show();

            }
        });

    }
    private void checkConnection() {
        if (isNetworkConnected()) {
            loginUser();
        } else {

            Snackbar snackbar = Snackbar
                    .make(linearLayout, "Please check your internet connection", Snackbar.LENGTH_LONG)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            checkConnection();
                        }
                    });

            snackbar.show();
        }
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

   /* private void getCustomerProfile() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://176.58.103.227:8083/api/customers", new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);
//                    pDialog.dismiss();
                    if (jsonObject != null) {
                        JSONObject data = jsonObject.getJSONObject("data");

                        String id= data.getString("id");
                        String username= data.getString("username");
                        String email = data.getString("email");
                        String user_type = data.getString("user_type");

                        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("individual_id", id);
                        editor.putString("individual_username", username);
                        editor.putString("individual_email", email);
                        editor.putString("individual_lname", user_type);
                        editor.apply();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                pDialog.dismiss();
                Toast.makeText(getApplicationContext(), "An Error Occurred while loading Individual client profile" + error.getMessage(), Toast.LENGTH_LONG).show();

            }


        }) {


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                session = new SessionManager(getApplicationContext());
                HashMap<String, String> user = session.getUserDetails();
                String accessToken = user.get("access_token");

                String bearer = "Bearer " + accessToken;
                Map<String, String> headersSys = super.getHeaders();
                Map<String, String> headers = new HashMap<String, String>();
                headersSys.remove("Authorization");
                headers.put("Authorization", bearer);
                headers.putAll(headersSys);
                return headers;
            }
        };

        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);

    }*/
    //end
}
