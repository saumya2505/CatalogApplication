package com.example.catalog.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catalog.Activity.Splash;
import com.example.catalog.DatabaseModel.Store;
import com.example.catalog.R;
import com.example.catalog.StoreListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewStore extends Fragment {
    RecyclerView recyclerView;


    public ViewStore() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_view_store, container, false);
        recyclerView=view.findViewById(R.id.recyclerview);
        List<Store> stores;
        stores= Splash.myAppDatabase.myDao().getAllStore();

        ArrayList<com.example.catalog.Model.Store> jsonStore = new ArrayList<>();

        for(int j=0;j<stores.size();j++) {

            Gson g = new Gson();
            com.example.catalog.Model.Store p = g.fromJson(stores.get(j).getJsonStringStore(), com.example.catalog.Model.Store.class);
            jsonStore.add(p);

        }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(linearLayoutManager);
            StoreListView rd = new StoreListView(getActivity(),jsonStore);
            recyclerView.setAdapter(rd);

        return view;
    }

}
