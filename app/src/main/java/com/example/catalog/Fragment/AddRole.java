package com.example.catalog.Fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.catalog.Activity.Dashboard;
import com.example.catalog.Activity.Splash;
import com.example.catalog.DatabaseModel.Role;
import com.example.catalog.R;
import com.google.gson.Gson;

import java.util.List;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddRole extends Fragment {
    EditText ETaddRoleType;
    CheckBox CBaddProduct,CBaddCategory,CBappSettings,CBaddRole,CBupdateRole,CBviewOrder,CBupdateOrder;
    Button btnAdd;
    List<Role> roleList;
    com.example.catalog.Model.Role role;
    static SharedPreferences sharedPreferences;
    public static final String myPreference="mypref";
    String userID;


    public AddRole() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add_role, container, false);

        sharedPreferences=getActivity().getSharedPreferences(myPreference,getActivity().MODE_PRIVATE);
        SharedPreferences.Editor editor1=sharedPreferences.edit();
        userID=sharedPreferences.getString("userId","");

        ETaddRoleType=view.findViewById(R.id.ETroleType);
        CBaddProduct=view.findViewById(R.id.CBaddProduct);
        CBaddCategory=view.findViewById(R.id.CBaddCategory);
        CBappSettings=view.findViewById(R.id.CBappSettings);
        CBaddRole=view.findViewById(R.id.CBaddRole);
        CBupdateRole=view.findViewById(R.id.CBupdateRole);
        CBviewOrder=view.findViewById(R.id.CBviewOrder);
        CBupdateOrder=view.findViewById(R.id.CBupdateOrder);
        btnAdd=view.findViewById(R.id.btnAdd);

        roleList= Splash.myAppDatabase.myDao().getAllRole();
        for (int i=0;i<roleList.size();i++){
            String strRole=roleList.get(i).getJsonStringRole();
            Gson gson=new Gson();
            role = gson.fromJson(strRole, com.example.catalog.Model.Role.class);
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UUID uuid = UUID.randomUUID();
                String randomid = uuid.toString();
                role.setRoleID(randomid);
                role.setAddedBy(userID);
                role.setActive(true);
                role.setRoleType(ETaddRoleType.getText().toString());
                if(CBaddProduct.isChecked()){
                    role.setAddProduct(true);
                }else{
                    role.setAddProduct(false);
                }
                if(CBaddCategory.isChecked()){
                    role.setAddCatagory(true);
                }else{
                    role.setAddCatagory(false);
                }
                if(CBaddRole.isChecked()){
                    role.setAddRole(true);
                }else{
                    role.setAddRole(false);
                }
                if(CBappSettings.isChecked()){
                    role.setAppSettings(true);
                }else{
                    role.setAppSettings(false);
                }
                if(CBupdateOrder.isChecked()){
                    role.setUpdateOrder(true);
                }else{
                    role.setUpdateOrder(false);
                }
                if(CBupdateRole.isChecked()){
                    role.setUpdateRole(true);
                }else{
                    role.setUpdateRole(false);
                }
                if(CBviewOrder.isChecked()){
                    role.setViewOrder(true);
                }else{
                    role.setViewOrder(false);
                }
                Gson gsonDB = new Gson();
                String r = gsonDB.toJson(role);
                Role roleDB=new Role();
                roleDB.setID(randomid);
                roleDB.setJsonStringRole(r);
                Splash.myAppDatabase.myDao().addRole(roleDB);
                Toast.makeText(getActivity(),"Role Added",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(), Dashboard.class);
                startActivity(intent);

            }
        });

        return view;
    }

}
