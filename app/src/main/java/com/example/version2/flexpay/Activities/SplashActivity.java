package com.example.version2.flexpay.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.version2.flexpay.BuildConfig;
import com.example.version2.flexpay.R;

public class SplashActivity extends AppCompatActivity {
    private Animation animation;
    private ImageView splashscreenLogoImg;
    private TextView textViewLipiaPolePole;
    private TextView textViewFlexpay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        checkFirstRun();

        splashscreenLogoImg =  findViewById(R.id.activity_splash_splashscreen_logo_img);
        textViewFlexpay =findViewById(R.id.activity_splash_textView_flexpay);
        textViewLipiaPolePole = findViewById(R.id.activity_splash_textView_lipia_pole_pole);
        // Font path
        String fontPath = "font/JosefinSans-Light.ttf";
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        // Applying font
        textViewLipiaPolePole.setTypeface(tf);
        textViewFlexpay.setTypeface(tf);
        if (savedInstanceState == null) {
            flyIn();
        }
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                endSplash();
            }
        }, 5500);
    }

    private void checkFirstRun() {
        final String PREFS_NAME = "MyPrefsFile";
        final String PREF_VERSION_CODE_KEY = "version_code";
        final int DOESNT_EXIST = -1;

        // Get current version code
        int currentVersionCode = BuildConfig.VERSION_CODE;

        // Get saved version code
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int savedVersionCode = prefs.getInt(PREF_VERSION_CODE_KEY, DOESNT_EXIST);

        // Check for first run or upgrade
        if (currentVersionCode == savedVersionCode) {
            // This is just a normal run
            return;

        } else if (savedVersionCode == DOESNT_EXIST) {
            // TODO This is a new install (or the user cleared the shared preferences)
            Intent intent = new Intent(getApplicationContext(),WalkthroughActivity.class);
            startActivity(intent);

        } else if (currentVersionCode > savedVersionCode) {
            // TODO This is an upgrade
        }

        // Update the shared preferences with the current version code
        prefs.edit().putInt(PREF_VERSION_CODE_KEY, currentVersionCode).apply();
    }

    private void flyIn() {
        animation = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        splashscreenLogoImg.startAnimation(animation);

        animation = AnimationUtils.loadAnimation(this,
                R.anim.app_name_animation);
        textViewLipiaPolePole.startAnimation(animation);

        animation = AnimationUtils.loadAnimation(this, R.anim.pro_animation);
        textViewFlexpay.startAnimation(animation);
    }

    private void endSplash() {
        animation = AnimationUtils.loadAnimation(this,
                R.anim.logo_animation_back);
        splashscreenLogoImg.startAnimation(animation);
        animation = AnimationUtils.loadAnimation(this,
                R.anim.app_name_animation_back);
        textViewLipiaPolePole.startAnimation(animation);
        animation = AnimationUtils.loadAnimation(this,
                R.anim.pro_animation_back);
        textViewFlexpay.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation arg0) {

                Intent intent = new Intent(getApplicationContext(),
                        LoginActivity.class);
                startActivity(intent);
                finish();
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationStart(Animation arg0) {
            }
        });

    }
    @Override
    public void onBackPressed() {
        // Do nothing
    }
}

