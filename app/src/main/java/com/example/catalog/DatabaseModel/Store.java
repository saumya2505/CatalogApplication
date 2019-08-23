package com.example.catalog.DatabaseModel;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Store")
public class Store {

    @PrimaryKey
    @NonNull
    private String ID;

    @ColumnInfo(name = "JsonString")
    private String JsonStringStore;

    @NonNull
    public String getID() {
        return ID;
    }

    public String getJsonStringStore() {
        return JsonStringStore;
    }

    public void setID(@NonNull String ID) {
        this.ID = ID;
    }

    public void setJsonStringStore(String jsonStringStore) {
        JsonStringStore = jsonStringStore;
    }
}
