package com.example.catalog;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catalog.Activity.Dashboard;
import com.example.catalog.Activity.Splash;
import com.example.catalog.Fragment.ViewStore;
import com.example.catalog.Model.Store;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class StoreListView extends RecyclerView.Adapter<StoreListView.MyViewHolder> {
    ArrayList<Store> stores;
    Context context;
    Store store,storeStatus;

    public StoreListView(Context context, ArrayList<Store> stores)
    {
        this.stores=stores;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_list_view_store,viewGroup,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        store=stores.get(i);
        myViewHolder.store_name.setText(store.getStoreName());

        if(store.isActive()){
            myViewHolder.active.setChecked(true);
        }else {
            myViewHolder.active.setChecked(false);
        }
        myViewHolder.active.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                storeStatus=new Store();
                if(isChecked){
                    myViewHolder.active.setChecked(true);

                    storeStatus.setStoreID(stores.get(i).getStoreID());
                    storeStatus.setStoreName(stores.get(i).getStoreName());
                    storeStatus.setAddedBy(stores.get(i).getAddedBy());
                    storeStatus.setAppThemeId(stores.get(i).getAppThemeId());
                    storeStatus.setActive(true);
                    Gson gsonStore=new Gson();
                    String stringstore=gsonStore.toJson(storeStatus);

                    Splash.myAppDatabase.myDao().updateStatus(stringstore,stores.get(i).getStoreID());
                    myViewHolder.active.setChecked(store.isActive());
                    Intent intent=new Intent(context, Dashboard.class);
                    context.startActivity(intent);
                    Toast.makeText(context, "User Enabled", Toast.LENGTH_SHORT).show();
                }
                else{
                    myViewHolder.active.setChecked(false);
                    storeStatus.setStoreID(stores.get(i).getStoreID());
                    storeStatus.setStoreName(stores.get(i).getStoreName());
                    storeStatus.setAddedBy(stores.get(i).getAddedBy());
                    storeStatus.setAppThemeId(stores.get(i).getAppThemeId());
                    storeStatus.setActive(false);
                    Gson gsonStoreFalse=new Gson();
                    String stringstoreFalse=gsonStoreFalse.toJson(storeStatus);
                    Splash.myAppDatabase.myDao().updateStatus(stringstoreFalse,stores.get(i).getStoreID());
                    myViewHolder.active.setChecked(store.isActive());
                    Intent intent=new Intent(context, Dashboard.class);
                    context.startActivity(intent);
                    Toast.makeText(context, "User Disabled", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return stores.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView store_name;
        CheckBox active;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            store_name=itemView.findViewById(R.id.showname);
            active=itemView.findViewById(R.id.actvie);

        }
    }
}
