package com.example.version2.flexpay.Activities;
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
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.version2.flexpay.Api.APIService;
import com.example.version2.flexpay.Api.APIUrl;
import com.example.version2.flexpay.Model.AuthUser;
import com.example.version2.flexpay.Model.User;
import com.example.version2.flexpay.R;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SignUpActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    private static final String SHARED_PREF_NAME = "profile";
    EditText editTextEmail, editTextPhone,editTextUsername, editTextFirst,editTextLast,editTextPassword,editTextConfirm_password;
    TextInputLayout floatingPhoneLabel,floatingEmailLabel,floatingUsernameLabel,floatingFirstNameLabel,floatingLastNameLabel,floatingPasswordLabel,
    floatingConfirmPasswordLabel;
    TextView textViewSignUp;
    String email,phone_number_1,username,first_name,last_name,password,confirm_password;
    int user_type = 1;

    LinearLayout linearLayout;
    Button buttonSignup;
    CheckBox terms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_2);

        progressDialog = new ProgressDialog(this);

        linearLayout = (LinearLayout) findViewById(R.id.activity_sign_up_linearlayout);



        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextFirst = (EditText) findViewById(R.id.editTextFirst);
        editTextLast = (EditText) findViewById(R.id.editTextLast);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextConfirm_password = (EditText) findViewById(R.id.editTextConfirm_password);
        terms=  findViewById(R.id.termsCheck);

        floatingPhoneLabel = (TextInputLayout) findViewById(R.id.editTextSignUpPhoneTextInputLayoutRegister);
        floatingEmailLabel = (TextInputLayout) findViewById(R.id.editTextLoginEmailTextInputLayout);
        floatingUsernameLabel = (TextInputLayout) findViewById(R.id.editTextSignUpUsernameTextInputLayoutRegister);
        floatingFirstNameLabel = (TextInputLayout) findViewById(R.id.editTextSignUpFirstNameTextInputLayoutFirstNameRegister);
        floatingLastNameLabel = (TextInputLayout) findViewById(R.id.editTextSignUpLAstNameTextInputLayoutLastNameRegister);
        floatingPasswordLabel = (TextInputLayout) findViewById(R.id.editTextSignUpPasswordTextInputLayoutPasswordRegister);
        floatingConfirmPasswordLabel = (TextInputLayout) findViewById(R.id.editTextSignUpConfirmPasswordTextInputLayoutConfirmPasswordRegister);

        buttonSignup = (Button) findViewById(R.id.buttonSignup);
      // Font path
        String fontPath = "font/JosefinSans-Light.ttf";
        String sansPath = "font/OpenSans-Regular.ttf";
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface sf = Typeface.createFromAsset(getAssets(), sansPath);
        // Applying font
      /*  editTextPhone.setTypeface(tf);
        editTextEmail.setTypeface(tf);
        editTextUsername.setTypeface(tf);
        editTextFirst.setTypeface(tf);
        editTextLast.setTypeface(tf);
        editTextEmail.setTypeface(tf);
        editTextPassword.setTypeface(tf);
        editTextConfirm_password.setTypeface(tf);*/

        terms = findViewById(R.id.termsCheck);

        final TextInputLayout floatingPhoneLabel = (TextInputLayout) findViewById(R.id.editTextSignUpPhoneTextInputLayoutRegister);
        floatingPhoneLabel.getEditText().addTextChangedListener(new TextWatcher() {
            // ...
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() > 0 && text.length() < 12) {
                    floatingPhoneLabel.setError(getString(R.string.enter_valid_phone_number));
                    floatingPhoneLabel.setErrorEnabled(true);
                }
                else if (text.length() > 12) {
                    floatingPhoneLabel.setError(getString(R.string.enter_valid_phone_number));
                    floatingPhoneLabel.setErrorEnabled(true);
                }
               else {
                    floatingPhoneLabel.setErrorEnabled(false);
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
        final TextInputLayout floatingEmailLabel = (TextInputLayout) findViewById(R.id.editTextSingUpEmailTextInputLayoutRegister);
        floatingEmailLabel.getEditText().addTextChangedListener(new TextWatcher() {
            // ...
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() < 5 ) {
                    floatingEmailLabel.setError(getString(R.string.enter_valid_email_address));
                    floatingEmailLabel.setErrorEnabled(true);
                }
                else {
                    floatingEmailLabel.setErrorEnabled(false);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                floatingEmailLabel.setError(null);
            }
        });
        final TextInputLayout floatingUsernameLabel = (TextInputLayout) findViewById(R.id.editTextSignUpUsernameTextInputLayoutRegister);
        floatingUsernameLabel.getEditText().addTextChangedListener(new TextWatcher() {
            // ...
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() < 1 ) {
                    floatingUsernameLabel.setError(getString(R.string.enter_username));
                    floatingUsernameLabel.setErrorEnabled(true);
                }
                else {
                    floatingUsernameLabel.setErrorEnabled(false);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                floatingUsernameLabel.setError(null);
            }
        });
        //first name
        final TextInputLayout floatingFirstNameLabel = (TextInputLayout) findViewById(R.id.editTextSignUpFirstNameTextInputLayoutFirstNameRegister);
        floatingFirstNameLabel.getEditText().addTextChangedListener(new TextWatcher() {
            // ...
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() < 1 ) {
                    floatingFirstNameLabel.setError(getString(R.string.enter_username));
                    floatingFirstNameLabel.setErrorEnabled(true);
                }
                else {
                    floatingFirstNameLabel.setErrorEnabled(false);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                floatingFirstNameLabel.setError(null);
            }
        });
        //second name
        final TextInputLayout floatingLastNameLabel = (TextInputLayout) findViewById(R.id.editTextSignUpLAstNameTextInputLayoutLastNameRegister);
        floatingLastNameLabel.getEditText().addTextChangedListener(new TextWatcher() {
            // ...
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() < 1 ) {
                    floatingLastNameLabel.setError(getString(R.string.enter_username));
                    floatingLastNameLabel.setErrorEnabled(true);
                }
                else {
                    floatingLastNameLabel.setErrorEnabled(false);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                floatingLastNameLabel.setError(null);
            }
        });
        final TextInputLayout floatingPasswordLabel = (TextInputLayout) findViewById(R.id.editTextSignUpPasswordTextInputLayoutPasswordRegister);
        floatingPasswordLabel.getEditText().addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() > 0 && text.length() < 6) {
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
        final TextInputLayout floatingConfirmPasswordLabel = (TextInputLayout) findViewById(R.id.editTextSignUpConfirmPasswordTextInputLayoutConfirmPasswordRegister);
        floatingConfirmPasswordLabel.getEditText().addTextChangedListener(new TextWatcher() {
            // ...
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() < 6) {
                    floatingConfirmPasswordLabel.setError(getString(R.string.minimum_of_6));
                    floatingConfirmPasswordLabel.setErrorEnabled(true);
                }
                else {
                    floatingConfirmPasswordLabel.setErrorEnabled(false);
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


        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*store reg details on shared prefs*/
                SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                     email = editTextEmail.getText().toString();
                     phone_number_1 = editTextPhone.getText().toString();
                     username = editTextUsername.getText().toString();
                     first_name = editTextFirst.getText().toString();
                    last_name = editTextLast.getText().toString();
                     password = editTextPassword.getText().toString();
                     confirm_password = editTextConfirm_password.getText().toString();

             /*   editor.putString("reg_email", email);
                editor.putString("reg_phone", phone_number_1);
                editor.putString("reg_username", username);
                editor.putString("reg_fname", first_name);
                editor.putString("reg_lname", last_name);
                editor.putString("reg_password", password);
                editor.putString("reg_confirm_password", confirm_password);*/

                editor.apply();
                 if (TextUtils.isEmpty(phone_number_1) || phone_number_1.length() < 12) {
                     floatingPhoneLabel.setError("Enter a valid Phone number");
                     floatingPhoneLabel.setErrorEnabled(true);
                    return;
                }
                else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                     floatingEmailLabel.setError(getString(R.string.enter_valid_email_address));
                     floatingEmailLabel.setErrorEnabled(true);
                    // Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                    return;
                }   else if (TextUtils.isEmpty(username)) {
                      floatingUsernameLabel .setError("Please enter username");
                     floatingUsernameLabel .setErrorEnabled(true);
                    return;
                }
                else if (TextUtils.isEmpty(first_name)) {
                      floatingFirstNameLabel.setError(getString(R.string.enter_first_name));
                     floatingFirstNameLabel.setErrorEnabled(true);
                    return;
                }
                else if (TextUtils.isEmpty(last_name)) {
                      floatingLastNameLabel.setError(getString(R.string.enter_last_name));
                     floatingLastNameLabel.setErrorEnabled(true);
                    return;
                } else if (TextUtils.isEmpty(password)) {
                       floatingPasswordLabel.setError(getString(R.string.minimum_of_6));
                     floatingPasswordLabel.setErrorEnabled(true);
                    return;
                } else if (TextUtils.isEmpty(confirm_password)) {
                      floatingConfirmPasswordLabel.setError(getString(R.string.minimum_of_6));
                     floatingConfirmPasswordLabel.setErrorEnabled(true);
                    return;

                }
                else if (!password.equals(confirm_password)) {

                      floatingConfirmPasswordLabel.setError(getString(R.string.both_passwords_should_match));
                     floatingConfirmPasswordLabel.setErrorEnabled(true);
                    return;
                }
                else if (!isNetworkConnected()) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                    builder.setTitle("Error");
                    builder.setMessage("No Internet");
                    builder.setNegativeButton("OK", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();

                    /*Snackbar snackbar = Snackbar
                            .make(linearLayout, "No Internet", Snackbar.LENGTH_INDEFINITE)
                            .setAction("RETRY", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    registerUser();
                                }
                            });
                    snackbar.show();*/
                }
               else if(terms.isChecked()){
                    registerUser();
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                    builder.setTitle("Error");
                    builder.setMessage("Click to Accept Terms and Conditions");
                    builder.setNegativeButton("OK", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }


            }

        });
    }




    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    private void registerUser() {
      /*  final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing in...");
        progressDialog.show();
        //getText
        StringRequest stringRequest = new StringRequest(Request.Method.POST, RegisterUrl, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                try {
                    //converting response to json object

                    JSONObject obj = new JSONObject(response);

                    String message = obj.getString("message");
                    String success = obj.getString("success");
//                            JSONObject data = new JSONObject("data");
                    if (success.equalsIgnoreCase("true")) {
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    } else if (success.equalsIgnoreCase("false")) {

                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    }
                    JSONArray jsonArray = obj.getJSONArray("data");
                    for (int k = 0; k < jsonArray.length(); k++) {
                        String data_message = jsonArray.getString(k);

                        if (success.equalsIgnoreCase("false")) {
                            Toast.makeText(getApplicationContext(), data_message, Toast.LENGTH_SHORT).show();
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "An error occurred" + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }


        ) {

            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> params = new HashMap<>();

                params.put("user_type", "1");
                params.put("email", editTextEmail.getText().toString());
                params.put("phone_number_1", editTextPhone.getText().toString());
                params.put("username", editTextUsername.getText().toString());
                params.put("first_name", editTextFirst.getText().toString());
                params.put("last_name", editTextLast.getText().toString());
                params.put("password", editTextPassword.getText().toString());
                params.put("confirm_password", editTextConfirm_password.getText().toString());
                return params;
            }

        };*/



        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing in...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        User user = new User(user_type,username, email,confirm_password,password, first_name, last_name,phone_number_1);

        Call<AuthUser> call = service.createUser(
                user.getUser_type(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getConfirm_password(),
                user.getFirst_name(),
                user.getLast_name(),
                user.getPhone_number_1()
        );

        call.enqueue(new Callback<AuthUser>() {

            @Override
            public void onResponse(Call<AuthUser> call, retrofit2.Response<AuthUser> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    Intent intentDashboard = new Intent(getApplicationContext(),DashboardActivity.class);
                    startActivity(intentDashboard);
                    if (response.body() != null) {
                  /*  Snackbar snackbar = Snackbar.make(linearLayout,"Registration Successful",Snackbar.LENGTH_INDEFINITE)
                            .setAction("Login", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                                }
                            });*/

                      /* Intent intentDashboard = new Intent(getApplicationContext(),DashboardActivity.class);
                        startActivity(intentDashboard);*/
                    }

                }


                else {

                    Toast.makeText(getApplicationContext(),""+response.body(), Toast.LENGTH_SHORT).show();
                   Snackbar snackbar = Snackbar
                            .make(linearLayout, "Username or Phone Number Exists", Snackbar.LENGTH_INDEFINITE)
                            .setAction("RETRY", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    registerUser();
                                }
                            });

                    snackbar.show();
                }
            }
            @Override
            public void onFailure(Call<AuthUser> call, Throwable t) {
                progressDialog.dismiss();
                t.printStackTrace();
                Snackbar snackbar = Snackbar.make(linearLayout, "Error: "+t, Snackbar.LENGTH_INDEFINITE).setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                            }
                        });
                snackbar.show();

            }
        });
// add it to the RequestQueue
     //   stringRequest.setShouldCache(false);
     //   requestQueue.add(stringRequest);
    }



}
