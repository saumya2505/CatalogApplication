package com.example.catalog.Fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.catalog.Activity.Dashboard;
import com.example.catalog.Activity.Splash;
import com.example.catalog.DatabaseModel.AppTheme;
import com.example.catalog.DatabaseModel.Store;
import com.example.catalog.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddStore extends Fragment {
    Spinner spinnerAppTheme;
    EditText ETstoreName;
    Button btnAddStore;
    List<AppTheme> appThemes;
    List<Store> storeList;
    String selectedTheme,selectedAppThemeID;
    static SharedPreferences sharedPreferences;
    public static final String myPreference="mypref";
    String userID;


    public AddStore() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add_store, container, false);
        spinnerAppTheme=view.findViewById(R.id.spinnerAppTheme);
        ETstoreName=view.findViewById(R.id.ETname);
        btnAddStore=view.findViewById(R.id.btnAddStore);

        sharedPreferences=getActivity().getSharedPreferences(myPreference,getActivity().MODE_PRIVATE);
        SharedPreferences.Editor editor1=sharedPreferences.edit();
        userID=sharedPreferences.getString("userId","");

        appThemes= Splash.myAppDatabase.myDao().getAllTheme();
        for (int i=0;i<appThemes.size();i++){
            String strAppTheme=appThemes.get(i).getJsonStringAppTheme();
            Gson gson=new Gson();
            final com.example.catalog.Model.AppTheme appTheme=gson.fromJson(strAppTheme, com.example.catalog.Model.AppTheme.class);

            final ArrayList<String> appThemes=new ArrayList<>();
            appThemes.add("Select Theme");
            appThemes.add(appTheme.getThemeName());


            ArrayAdapter<String> adapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1
                    ,appThemes);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            spinnerAppTheme.setAdapter(adapter);

            spinnerAppTheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                        selectedTheme = spinnerAppTheme.getSelectedItem().toString();
                        Log.e("selectedTheme", selectedTheme);
                        if(selectedTheme==appTheme.getThemeName()){
                            selectedAppThemeID=appTheme.getAppThemeID();
                            //Log.e("selectedAppThemeID",selectedAppThemeID);
                        }


                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

        }

        btnAddStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spinnerAppTheme.getSelectedItem().equals("Select Theme")){
                    Toast.makeText(getActivity(),"Please Select Theme..",Toast.LENGTH_SHORT).show();
                }else {
                    storeList = Splash.myAppDatabase.myDao().getAllStore();
                    for (int j = 0; j < storeList.size(); j++) {
                        String strStore = storeList.get(j).getJsonStringStore();
                        Gson gsonStore = new Gson();
                        com.example.catalog.Model.Store store = gsonStore.fromJson(strStore, com.example.catalog.Model.Store.class);
                        UUID uuid = UUID.randomUUID();
                        String randomid = uuid.toString();
                        store.setStoreID(randomid);
                        store.setAppThemeId(selectedAppThemeID);

                        store.setAddedBy(userID);
                        store.setStoreName(ETstoreName.getText().toString());
                        store.setActive(store.isActive());
                        Gson gson = new Gson();
                        String s = gson.toJson(store);

                        Store store1 = new Store();
//                        UUID uuid1 = UUID.randomUUID();
//                        String randomid1 = uuid1.toString();
                        store1.setID(randomid);
                        store1.setJsonStringStore(s);
                        Splash.myAppDatabase.myDao().addStore(store1);
                        Toast.makeText(getActivity(),"Store Added",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getActivity(), Dashboard.class);
                        startActivity(intent);
                    }
                }




            }
        });

        return view;
    }

}
