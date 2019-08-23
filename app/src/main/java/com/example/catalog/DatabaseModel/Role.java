package com.example.catalog.DatabaseModel;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Role")
public class Role {
    @PrimaryKey
    @NonNull
    private String ID;

    @ColumnInfo(name = "JsonString")
    private String JsonStringRole;

    @NonNull
    public String getID() {
        return ID;
    }

    public String getJsonStringRole() {
        return JsonStringRole;
    }

    public void setID(@NonNull String ID) {
        this.ID = ID;
    }

    public void setJsonStringRole(String jsonStringRole) {
        JsonStringRole = jsonStringRole;
    }
}
