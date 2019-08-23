package com.example.catalog.Activity;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.catalog.DatabaseModel.MyAppDatabase;
import com.example.catalog.Model.AppTheme;
import com.example.catalog.Model.Role;
import com.example.catalog.Model.Store;
import com.example.catalog.Model.User;
import com.example.catalog.R;
import com.google.gson.Gson;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private static MyAppDatabase myAppDatabase;
    EditText ETusername,Etpassword;
    Button btnLogin;
    List<com.example.catalog.DatabaseModel.User> userList;
    List<com.example.catalog.DatabaseModel.Store> storeList;
    List<com.example.catalog.DatabaseModel.AppTheme> appthemeList;
    String username,password,usernameDB,passwordDB;
    static SharedPreferences sharedPreferences;
    public static final String myPreference="mypref";
    static SharedPreferences sharedPreferencesAppTheme;
    public static final String myPreferenceAppTheme="myprefAppTheme";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ETusername=findViewById(R.id.ETusername);
        Etpassword=findViewById(R.id.ETpassword);
        btnLogin=findViewById(R.id.btnLogin);

        //myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "Catalog").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        userList = Splash.myAppDatabase.myDao().getAllusers();
        dataCheck();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=ETusername.getText().toString();
                password=Etpassword.getText().toString();
                if(username.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter user name", Toast.LENGTH_SHORT).show();
                }else if(password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }else {

                    checklogin();
                }
            }
        });




    }
    private void checklogin() {
        userList = Splash.myAppDatabase.myDao().getAllusers();
        for (int i = 0; i < userList.size(); i++) {

            String us = userList.get(i).getJsonStringUser();
            Gson g = new Gson();
            User u = g.fromJson(us, User.class);
            usernameDB = u.getUsername();
            passwordDB = u.getPassword();
            String userId=u.getUserID();
            String storeId=u.getStoreID();
            String roleId=u.getRoleID();
            String contactNo=u.getContactNo();
            String name=u.getName();
            String email=u.getEmail();
            String address=u.getAddress();
            String gender=u.getGender();
            boolean status=u.isActive();

            if (username.equals( usernameDB) && password.equals( passwordDB)) {
                sharedPreferences=getSharedPreferences(myPreference,getApplicationContext().MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("username",usernameDB);
                editor.putString("password",passwordDB);
                editor.putString("userId",userId);
                editor.putString("storeId",storeId);
                editor.putString("roleId",roleId);
                editor.putString("contactNo",contactNo);
                editor.putString("name",name);
                editor.putString("email",email);
                editor.putString("address",address);
                editor.putString("gender",gender);
                editor.putBoolean("status",status);
                editor.commit();

                storeList=Splash.myAppDatabase.myDao().getAllStore();
                for(int j=0;j<storeList.size();j++){



                    String strStore = storeList.get(i).getJsonStringStore();
                    Gson gsonStore = new Gson();
                    Store storeObj = gsonStore.fromJson(strStore, Store.class);
//                    Log.e("From user storeID", storeId);
//                    Log.e("From table storeID", storeObj.getStoreID());
                    if(storeId.equals(storeObj.getStoreID())){
                        String storeAppThemeID=storeObj.getAppThemeId();
                        Log.e("themeID",storeAppThemeID);

                        appthemeList=Splash.myAppDatabase.myDao().getAllTheme();
                        for(int k=0;k<appthemeList.size();k++){
                            String strApptheme=appthemeList.get(i).getJsonStringAppTheme();
                            Gson gsonApptheme=new Gson();
                            AppTheme appThemeObj=gsonApptheme.fromJson(strApptheme,AppTheme.class);
                            if(storeAppThemeID.equals(appThemeObj.getAppThemeID())){
                                sharedPreferencesAppTheme=getSharedPreferences(myPreferenceAppTheme,getApplicationContext().MODE_PRIVATE);
                                SharedPreferences.Editor editorAppTheme=sharedPreferencesAppTheme.edit();
                                editorAppTheme.putString("appThemeID",appThemeObj.getAppThemeID());
                                editorAppTheme.putString("appThemeAbout",appThemeObj.getAbout());
                                editorAppTheme.putString("appThemeColorPriDark",appThemeObj.getColorPrimaryDark());
                                editorAppTheme.putString("appThemeColorPrimary",appThemeObj.getColorPrimary());
                                editorAppTheme.putString("appThemeColorEmphasis",appThemeObj.getColorEmphasis());
                                editorAppTheme.putString("appThemeFontColorDark",appThemeObj.getFontColorDark());
                                editorAppTheme.putString("appThemeFontColorLight",appThemeObj.getFontColorLight());
                                editorAppTheme.putString("appThemeLogoUrl",appThemeObj.getLogoURL());
                                editorAppTheme.putString("appThemeIDaddedBy",appThemeObj.getAddedBy());
                                editorAppTheme.putString("appThemeAppName",appThemeObj.getAppName());
                                editorAppTheme.putBoolean("appThemeIDStatus",appThemeObj.isActive());
                                editorAppTheme.putString("themeName",appThemeObj.getThemeName());
                                editorAppTheme.commit();


                            }
                        }

                    }

                }



                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Please enter valid Username and Password..", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void dataCheck() {
        if(userList.size()==0){

            UUID SuperAdminUuid = UUID.randomUUID();
            UUID DefaultStoreUuid = UUID.randomUUID();
            UUID DefaultThemeUuid = UUID.randomUUID();
            UUID SuperAdminRoleUuid = UUID.randomUUID();

            Store store=new Store();
            store.setStoreID(DefaultStoreUuid.toString());
            //Log.e("storeid",store.getStoreID());
            store.setActive(true);
            store.setStoreName("Store 1");
            store.setAddedBy(SuperAdminUuid.toString());
            store.setAppThemeId(DefaultThemeUuid.toString());
            Gson gson=new Gson();
            String s=gson.toJson(store);

            com.example.catalog.DatabaseModel.Store store1=new com.example.catalog.DatabaseModel.Store();


            store1.setID(DefaultStoreUuid.toString());
            store1.setJsonStringStore(s);
            Splash.myAppDatabase.myDao().addStore(store1);

            com.example.catalog.Model.Role role=new Role();

            role.setRoleID(SuperAdminRoleUuid.toString());
            role.setRoleType("SuperAdmin");
            role.setAddedBy(SuperAdminUuid.toString());
            role.setAddCatagory(true);
            role.setAddProduct(true);
            role.setAppSettings(true);
            role.setAddRole(true);
            role.setUpdateRole(true);
            role.setViewOrder(true);
            role.setUpdateOrder(true);
            role.setActive(true);
            Gson gsonRole=new Gson();
            String stringRole=gsonRole.toJson(role);

            com.example.catalog.DatabaseModel.Role roleDB=new com.example.catalog.DatabaseModel.Role();
            UUID uuidRoleDB = UUID.randomUUID();
            String randomidRoleDB = uuidRoleDB.toString();
            roleDB.setID(randomidRoleDB);
            roleDB.setJsonStringRole(stringRole);

        Splash.myAppDatabase.myDao().addRole(roleDB);


            User user=new User();
            user.setUserID(SuperAdminUuid.toString());
            user.setStoreID(DefaultStoreUuid.toString());
           // Log.e("userstoreid",user.getStoreID());
            user.setRoleID(SuperAdminRoleUuid.toString());
            user.setActive(true);
            user.setContactNo("12345");
            user.setPassword("123");
            user.setUsername("superadmin");
            user.setName("Super Admin");
            user.setEmail("superadmin@gmail.com");
            user.setAddress("Bangalore");
            user.setGender("Female");

            Gson gsonUser=new Gson();
            String stringUser=gsonUser.toJson(user);

            com.example.catalog.DatabaseModel.User userDB=new com.example.catalog.DatabaseModel.User();
            UUID uuidUserDB = UUID.randomUUID();
            String randomidUserDB = uuidUserDB.toString();
            userDB.setID(randomidUserDB);
            userDB.setJsonStringUser(stringUser);
            Splash.myAppDatabase.myDao().addUser(userDB);

            AppTheme appTheme=new AppTheme();
            appTheme.setAppThemeID(DefaultThemeUuid.toString());
            appTheme.setAbout("This is App");
            appTheme.setColorPrimaryDark("#000000");
            appTheme.setColorPrimary("#A1A1A1");
            appTheme.setColorEmphasis("#64C0FF");
            appTheme.setFontColorDark("#000000");
            appTheme.setFontColorLight("#FFFFFF");
            appTheme.setAddedBy(SuperAdminUuid.toString());
            appTheme.setActive(true);
            appTheme.setLogoURL("");
            appTheme.setAppName("Catalog");
            appTheme.setThemeName("Theme 1");
            Gson gsonAppTheme=new Gson();
            String strAppTheme=gsonAppTheme.toJson(appTheme);

            com.example.catalog.DatabaseModel.AppTheme appTheme1=new com.example.catalog.DatabaseModel.AppTheme();

            UUID uuidAppThemeDB = UUID.randomUUID();
            String strRandomIdAppTheme = uuidAppThemeDB.toString();
            appTheme1.setID(strRandomIdAppTheme);
            appTheme1.setJsonStringAppTheme(strAppTheme);
            Splash.myAppDatabase.myDao().addAppTheme(appTheme1);
        }
    }
}
