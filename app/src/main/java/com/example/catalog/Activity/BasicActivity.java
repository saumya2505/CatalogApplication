package com.example.catalog.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.catalog.Fragment.AddAppTheme;
import com.example.catalog.Fragment.AddRole;
import com.example.catalog.Fragment.AddStore;
import com.example.catalog.Fragment.DashBoardLeft;
import com.example.catalog.Fragment.EditProfile;
import com.example.catalog.Fragment.ViewRole;
import com.example.catalog.Fragment.ViewStore;
import com.example.catalog.R;

public class BasicActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);


        if (getIntent() != null) {
            String value=getIntent().getStringExtra("value");

            if (value.equals("1")) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                EditProfile editProfileFrag = new EditProfile();

                ft.add(R.id.LLBasicActivity, editProfileFrag);
                ft.commit();

            }else if(value.equals("2")){
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                AddStore addStoreFrag = new AddStore();

                ft.add(R.id.LLBasicActivity, addStoreFrag);
                ft.commit();
            }else if(value.equals("3")){
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ViewStore viewStoreFrag = new ViewStore();

                ft.add(R.id.LLBasicActivity, viewStoreFrag);
                ft.commit();
            }else if(value.equals("4")){
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                AddRole addRoleFrag = new AddRole();

                ft.add(R.id.LLBasicActivity, addRoleFrag);
                ft.commit();
            }else if(value.equals("5")){
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ViewRole viewRoleFrag = new ViewRole();

                ft.add(R.id.LLBasicActivity, viewRoleFrag);
                ft.commit();
            }
            else if(value.equals("6")){
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                AddAppTheme addAppTheme = new AddAppTheme();

                ft.add(R.id.LLBasicActivity, addAppTheme);
                ft.commit();

                //test commit
            }
        }

    }
}
