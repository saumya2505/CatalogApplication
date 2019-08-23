package com.example.catalog.Fragment;


import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catalog.Activity.Dashboard;
import com.example.catalog.Activity.Splash;
import com.example.catalog.DatabaseModel.MyAppDatabase;
import com.example.catalog.DatabaseModel.Store;
import com.example.catalog.DatabaseModel.User;
import com.example.catalog.R;
import com.google.gson.Gson;

import java.util.List;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditProfile extends Fragment {
    Toolbar toolbar;
    TextView TVtoolbarTitle;
    ImageView IVarrowBack;
    List<User> userList;
    List<Store> storeList;
    String userIdDBModel,userID;

    TextView TVstoreName;
    Button btnUpdate;
    EditText ETname,ETaddress,ETemail,ETphone,ETgender;
    private static MyAppDatabase myAppDatabase;
    static SharedPreferences sharedPreferencesAppTheme;
    public static final String myPreferenceAppTheme="myprefAppTheme";
    static SharedPreferences sharedPreferences;
    public static final String myPreference="mypref";
    com.example.catalog.Model.User u;


    public EditProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_edit_profile, container, false);
        toolbar=view.findViewById(R.id.toolbar);
        sharedPreferencesAppTheme = getActivity().getSharedPreferences(myPreferenceAppTheme, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferencesAppTheme.edit();

        String appThemeColorPrimaryDark = sharedPreferencesAppTheme.getString("appThemeColorPriDark", "");
        String appThemeFontColorLight = sharedPreferencesAppTheme.getString("appThemeFontColorLight", "");
        String appThemeFontColorDark = sharedPreferencesAppTheme.getString("appThemeFontColorDark", "");
        TVtoolbarTitle=view.findViewById(R.id.TVtoolbarTitle);
        ETname=view.findViewById(R.id.ETname);
        ETaddress=view.findViewById(R.id.ETaddress);
        ETemail=view.findViewById(R.id.ETemail);
        ETgender=view.findViewById(R.id.ETgender);
        ETphone=view.findViewById(R.id.ETPhone);
        IVarrowBack=view.findViewById(R.id.IVarrowBack);
        TVstoreName=view.findViewById(R.id.ETstoreName);
        btnUpdate=view.findViewById(R.id.btnUpdate);
        toolbar.setBackgroundColor(Color.parseColor(appThemeColorPrimaryDark));
        toolbar.setTitle("");
        TVtoolbarTitle.setText("Edit Profile");
        TVtoolbarTitle.setTextColor(Color.parseColor(appThemeFontColorLight));
        ETname.setTextColor(Color.parseColor(appThemeFontColorDark));
        ETaddress.setTextColor(Color.parseColor(appThemeFontColorDark));
        ETemail.setTextColor(Color.parseColor(appThemeFontColorDark));
        ETphone.setTextColor(Color.parseColor(appThemeFontColorDark));
        ETgender.setTextColor(Color.parseColor(appThemeFontColorDark));
        TVstoreName.setTextColor(Color.parseColor(appThemeFontColorDark));
        btnUpdate.setTextColor(Color.parseColor(appThemeFontColorLight));
        btnUpdate.setBackgroundColor(Color.parseColor(appThemeFontColorDark));
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        IVarrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), Dashboard.class);
                startActivity(intent);
            }
        });
        myAppDatabase = Room.databaseBuilder(getActivity().getApplicationContext(), MyAppDatabase.class, "Catalog").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        sharedPreferences=getActivity().getSharedPreferences(myPreference,getActivity().MODE_PRIVATE);
        SharedPreferences.Editor editor1=sharedPreferences.edit();
        userID=sharedPreferences.getString("userId","");

        userList= Splash.myAppDatabase.myDao().getAllusers();
        for (int i=0;i<userList.size();i++){
            String us = userList.get(i).getJsonStringUser();
            userIdDBModel=userList.get(i).getID();
            Gson g = new Gson();
            u = g.fromJson(us, com.example.catalog.Model.User.class);

            if(userID.equals(u.getUserID()))
            {
            ETname.setText(u.getName());
            ETaddress.setText(u.getAddress());
            ETemail.setText(u.getEmail());
            ETphone.setText(u.getContactNo());
            ETgender.setText(u.getGender());


            storeList=Splash.myAppDatabase.myDao().getAllStore();
            for (int j=0;j<storeList.size();j++) {
                String store = storeList.get(i).getJsonStringStore();
                Gson gsonStore = new Gson();
                com.example.catalog.Model.Store store1 = gsonStore.fromJson(store, com.example.catalog.Model.Store.class);

               // Log.e("userstoreID", u.getStoreID());
               // Log.e("storeID", store1.getStoreID());

                if (u.getStoreID().equals(store1.getStoreID())) {
                    TVstoreName.setText(store1.getStoreName());
                    //Log.e("storename", store1.getStoreName());
                }
            }
            }

            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    com.example.catalog.Model.User user=new com.example.catalog.Model.User();

                    user.setUserID(u.getUserID());
                    user.setStoreID(u.getStoreID());
                    user.setRoleID(u.getRoleID());
                    user.setActive(true);
                    user.setContactNo(ETphone.getText().toString());
                    user.setPassword("123");
                    user.setUsername("superadmin");
                    user.setName(ETname.getText().toString());
                    user.setEmail(ETemail.getText().toString());
                    user.setAddress(ETaddress.getText().toString());
                    user.setGender(ETgender.getText().toString());

                    Gson gsonUser=new Gson();
                    String stringUser=gsonUser.toJson(user);

                    com.example.catalog.DatabaseModel.User userDB=new com.example.catalog.DatabaseModel.User();
                    userDB.setID(userIdDBModel);
                    userDB.setJsonStringUser(stringUser);
                    Splash.myAppDatabase.myDao().updateUser(userDB);
                    Toast.makeText(getActivity(),"User Updated",Toast.LENGTH_SHORT).show();

                    sharedPreferences=getActivity().getSharedPreferences(myPreference,getActivity().MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("username",user.getUsername());
                    editor.putString("password",user.getPassword());
                    editor.putString("userId",user.getUserID());
                    editor.putString("storeId",user.getStoreID());
                    editor.putString("roleId",user.getRoleID());
                    editor.putString("contactNo",user.getContactNo());
                    editor.putString("name",user.getName());
                    editor.putString("email",user.getEmail());
                    editor.putString("address",user.getAddress());
                    editor.putString("gender",user.getGender());
                    editor.putBoolean("status",user.isActive());
                    editor.commit();



                }
            });



        }
        return view;
    }

}
