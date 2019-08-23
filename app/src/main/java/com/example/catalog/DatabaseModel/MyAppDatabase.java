package com.example.catalog.DatabaseModel;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Store.class,Role.class,User.class,AppTheme.class},version = 2,exportSchema = false)

public abstract class MyAppDatabase extends RoomDatabase {
    public abstract MyDao myDao();

    public static MyAppDatabase mydb;

    public static synchronized MyAppDatabase getDBInstanc(Context context) {
        if (mydb == null) {
            mydb = Room.databaseBuilder(context.getApplicationContext(), MyAppDatabase.class, "Mydatabase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return mydb;
    }
}