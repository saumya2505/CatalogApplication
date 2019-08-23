package com.example.catalog.DatabaseModel;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "AppTheme")
public class AppTheme {
    @PrimaryKey
    @NonNull
    private String ID;

    @ColumnInfo(name = "JsonString")
    private String JsonStringAppTheme;

    @NonNull
    public String getID() {
        return ID;
    }

    public String getJsonStringAppTheme() {
        return JsonStringAppTheme;
    }

    public void setID(@NonNull String ID) {
        this.ID = ID;
    }

    public void setJsonStringAppTheme(String jsonStringAppTheme) {
        JsonStringAppTheme = jsonStringAppTheme;
    }
}
