package com.example.catalog.DatabaseModel;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "User")
public class User {
    @PrimaryKey
    @NonNull
    private String ID;

    @ColumnInfo(name = "JsonString")
    private String JsonStringUser;

    @NonNull
    public String getID() {
        return ID;
    }

    public String getJsonStringUser() {
        return JsonStringUser;
    }

    public void setID(@NonNull String ID) {
        this.ID = ID;
    }

    public void setJsonStringUser(String jsonStringUser) {
        JsonStringUser = jsonStringUser;
    }
}
