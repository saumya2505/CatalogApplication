package com.example.catalog.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catalog.Activity.Splash;
import com.example.catalog.DatabaseModel.Role;
import com.example.catalog.R;
import com.example.catalog.RoleListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewRole extends Fragment {
    RecyclerView recyclerView;


    public ViewRole() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_view_role, container, false);
        recyclerView=view.findViewById(R.id.recyclerview);
        List<Role> roles;
        roles= Splash.myAppDatabase.myDao().getAllRole();
        ArrayList<com.example.catalog.Model.Role> roleArrayList=new ArrayList<>();

        for (int i=0;i<roles.size();i++){
            Gson gson=new Gson();
            com.example.catalog.Model.Role role=gson.fromJson(roles.get(i).getJsonStringRole(), com.example.catalog.Model.Role.class);
            roleArrayList.add(role);
        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        RoleListView roleListView=new RoleListView(getActivity(),roleArrayList);
        recyclerView.setAdapter(roleListView);

        return view;
    }

}
