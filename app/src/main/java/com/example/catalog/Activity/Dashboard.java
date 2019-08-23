package com.example.catalog.Activity;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.catalog.Fragment.DashBoardLeft;
import com.example.catalog.R;

import java.util.List;

public class Dashboard extends AppCompatActivity {
    Toolbar toolbar;
    TextView TVtoolbarTitle;
    LinearLayout LLdashboard;
    static SharedPreferences sharedPreferencesAppTheme;
    public static final String myPreferenceAppTheme="myprefAppTheme";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TVtoolbarTitle=findViewById(R.id.TVtoolbarTitle);
        LLdashboard=findViewById(R.id.LLdashboard);

        sharedPreferencesAppTheme = getSharedPreferences(myPreferenceAppTheme, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferencesAppTheme.edit();

        String appThemeColorPrimaryDark = sharedPreferencesAppTheme.getString("appThemeColorPriDark", "");
        String appThemeFontColorLight = sharedPreferencesAppTheme.getString("appThemeFontColorLight", "");
        String appThemeAppName = sharedPreferencesAppTheme.getString("appThemeAppName", "");
        String appThemeColorPrimary = sharedPreferencesAppTheme.getString("appThemeColorPrimary", "");

        toolbar=findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.parseColor(appThemeColorPrimaryDark));
        toolbar.setTitle("");
        TVtoolbarTitle.setText(appThemeAppName);
        TVtoolbarTitle.setTextColor(Color.parseColor(appThemeFontColorLight));
        Typeface typeface=Typeface.createFromAsset(getAssets(),"font/font.ttf.otf");
        TVtoolbarTitle.setTypeface(typeface);
        setSupportActionBar(toolbar);
        LLdashboard.setBackgroundColor(Color.parseColor(appThemeColorPrimary));


            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            DashBoardLeft adsFrag = new DashBoardLeft();

            ft.add(R.id.fragmentLeftContainer, adsFrag);
            ft.commit();



    }
}
