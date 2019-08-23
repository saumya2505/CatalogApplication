package com.example.catalog.Activity;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.catalog.DatabaseModel.MyAppDatabase;
import com.example.catalog.R;

public class Splash extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    public static MyAppDatabase myAppDatabase;
    static SharedPreferences sharedPreferences;
    public static final String myPreference="mypref";
    static SharedPreferences sharedPreferencesAppTheme;
    public static final String myPreferenceAppTheme="myprefAppTheme";
    String username;
    TextView logoText;

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "Catalog").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        sharedPreferencesAppTheme = getSharedPreferences(myPreferenceAppTheme, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferencesAppTheme.edit();

        String appName = sharedPreferencesAppTheme.getString("appThemeAppName", "");
        Log.e("appname",appName);


        logoText=findViewById(R.id.logo_text);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"font/font.ttf.otf");
        logoText.setTypeface(typeface);
        logoText.setText(appName);

        sharedPreferences=getSharedPreferences(myPreference,getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor editor1=sharedPreferences.edit();
        username=sharedPreferences.getString("username","");


        new Thread()
        {
            public void run()
            {

                try {
                    Thread.sleep(3000);
                    if(username.equals("")) {
                        Intent i = new Intent(Splash.this, MainActivity.class);
                        startActivity(i);
                    }else {
                        Intent i = new Intent(Splash.this, Dashboard.class);
                        startActivity(i);
                    }
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();



    }
}
