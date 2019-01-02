package com.example.mercy.flexpay.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.codemybrainsout.onboarder.AhoyOnboarderActivity;
import com.codemybrainsout.onboarder.AhoyOnboarderCard;
import com.example.mercy.flexpay.R;

import java.util.ArrayList;
import java.util.List;

public class WalkthroughActivity extends AhoyOnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard("", "Welcome to FlexPay,set your goals or buy products.", R.drawable.emptydashboard);
        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard("", "Because you plan to spend the money you need to set aside some money.", R.drawable.wallet);
        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard("", "Search products by image, discover items in a more natural way.", R.drawable.holiday);

        ahoyOnboarderCard1.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard2.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard3.setBackgroundColor(R.color.black_transparent);

        List<AhoyOnboarderCard> pages = new ArrayList<>();

        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard2);
        pages.add(ahoyOnboarderCard3);

        for (AhoyOnboarderCard page : pages) {
            page.setTitleColor(R.color.blue_lagoon);
            page.setDescriptionColor(R.color.grey_200);
            //page.setTitleTextSize(dpToPixels(12, this));
            //page.setDescriptionTextSize(dpToPixels(8, this));
            //page.setIconLayoutParams(width, height, marginTop, marginLeft, marginRight, marginBottom);
        }

        setFinishButtonTitle("Finish");
        showNavigationControls(true);
        setGradientBackground();

        //set the button style you created
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setFinishButtonDrawableStyle(ContextCompat.getDrawable(this, R.drawable.rounded_button));
        }
          // Font path
        String fontPath = "font/Roboto-Light.ttf";
        Typeface face = Typeface.createFromAsset(getAssets(), fontPath);
        setFont(face);

        setOnboardPages(pages);
    }

    @Override
    public void onFinishButtonPressed() {
        //Toast.makeText(this, "Finish Pressed", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }
}
