package com.example.mercy.flexpay.Activities;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mercy.flexpay.Api.APIService;
import com.example.mercy.flexpay.Api.APIUrl;
import com.example.mercy.flexpay.Model.AuthUser;
import com.example.mercy.flexpay.Model.User;
import com.example.mercy.flexpay.R;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SignUpActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    private static final String SHARED_PREF_NAME = "profile";
    EditText editTextEmail, editTextPhone,editTextUsername, editTextFirst,editTextLast,editTextPassword,editTextConfirm_password;
    TextView textViewSignUp;
    String email,phone_number_1,username,first_name,last_name,password,confirm_password;
    int user_type = 1;

    LinearLayout linearLayout;
    Button buttonSignup;
    CheckBox terms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        progressDialog = new ProgressDialog(this);

        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextFirst = (EditText) findViewById(R.id.editTextFirst);
        editTextLast = (EditText) findViewById(R.id.editTextLast);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextConfirm_password = (EditText) findViewById(R.id.editTextConfirm_password);
        terms=  findViewById(R.id.termsCheck);

        buttonSignup = (Button) findViewById(R.id.buttonSignup);
      // Font path
        String fontPath = "font/JosefinSans-Light.ttf";
        String sansPath = "font/OpenSans-Regular.ttf";
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        Typeface sf = Typeface.createFromAsset(getAssets(), sansPath);
       /* // Applying font
        editTextPhone.setTypeface(tf);
        editTextEmail.setTypeface(tf);
        editTextUsername.setTypeface(tf);
        editTextFirst.setTypeface(tf);
        editTextLast.setTypeface(tf);
        editTextEmail.setTypeface(tf);
        editTextPassword.setTypeface(tf);
        editTextConfirm_password.setTypeface(tf);
        terms = findViewById(R.id.termsCheck);
*/
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

                editor.putString("reg_email", email);
                editor.putString("reg_phone", phone_number_1);
                editor.putString("reg_username", username);
                editor.putString("reg_fname", first_name);
                editor.putString("reg_lname", last_name);
                editor.putString("reg_password", password);
                editor.putString("reg_confirm_password", confirm_password);

                editor.apply();
                 if (TextUtils.isEmpty(phone_number_1) || phone_number_1.length() < 12) {
                    editTextPhone.setError("Enter a valid Phone number");
                    editTextPhone.requestFocus();
                    return;
                }
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    editTextEmail.setError("Enter a valid email");
                    editTextEmail.requestFocus();
                    return;
                }   else if (TextUtils.isEmpty(username)) {
                    editTextUsername.setError("Please enter username");
                    editTextUsername.requestFocus();
                    return;
                }
                else if (TextUtils.isEmpty(first_name)) {
                    editTextUsername.setError("Please enter first name");
                    editTextUsername.requestFocus();
                    return;
                }
                else if (TextUtils.isEmpty(last_name)) {
                    editTextLast.setError("Please enter last name");
                    editTextFirst.requestFocus();
                    return;
                } else if (TextUtils.isEmpty(password)) {
                    editTextPassword.setError("Enter a password");
                    editTextPassword.requestFocus();
                    return;
                } else if (TextUtils.isEmpty(confirm_password)) {
                    editTextConfirm_password.setError("Confirm password");
                    editTextConfirm_password.requestFocus();
                    return;

                }  else if (TextUtils.isEmpty(password) || confirm_password.length() < 6) {
                    editTextPassword.setError("Atleast 6 characters");
                    editTextPassword.requestFocus();
                    editTextConfirm_password.setError("Atleast 6 characters");
                    editTextConfirm_password.requestFocus();
                    return;
                }
                else if (!password.equals(confirm_password)) {
                    editTextConfirm_password.setError("Both passwords should match");
                    editTextConfirm_password.requestFocus();
                    return;
                }
                else if (!isNetworkConnected()) {
                    Snackbar snackbar = Snackbar
                            .make(linearLayout, "No Internet", Snackbar.LENGTH_INDEFINITE)
                            .setAction("RETRY", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    registerUser();
                                }
                            });
                    snackbar.show();

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
                    if (response.body() != null) {
                  /*  Snackbar snackbar = Snackbar.make(linearLayout,"Registration Successful",Snackbar.LENGTH_INDEFINITE)
                            .setAction("Login", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                                }
                            });*/

                       Intent intentDashboard = new Intent(getApplicationContext(),DashboardActivity.class);
                        startActivity(intentDashboard);
                    }

                }


                else {
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
