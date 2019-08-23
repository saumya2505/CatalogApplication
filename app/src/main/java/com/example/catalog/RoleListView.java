package com.example.catalog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.catalog.Model.Role;
import com.example.catalog.Model.Store;

import java.util.ArrayList;

public class RoleListView extends RecyclerView.Adapter<RoleListView.MyViewHolder> {
    ArrayList<Role> roles;
    Context context;
    Role role,storeStatus;

    public RoleListView(Context context, ArrayList<Role> roles)
    {
        this.roles=roles;
        this.context=context;
    }


    @NonNull
    @Override
    public RoleListView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_list_view_role,viewGroup,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RoleListView.MyViewHolder myViewHolder, int i) {
            role=roles.get(i);
            myViewHolder.TVroleType.setText(role.getRoleType());
    }

    @Override
    public int getItemCount() {
        return roles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView TVroleType;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            TVroleType=itemView.findViewById(R.id.showname);
        }
    }
}
