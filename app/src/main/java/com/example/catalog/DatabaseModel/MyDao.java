package com.example.catalog.DatabaseModel;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addStore(Store store);

    @Query("Select * from Store")
    List<Store> getAllStore();

    @Insert
    public void addRole(Role role);

    @Insert
    public void addUser(User user);

    @Insert
    public void addAppTheme(AppTheme appTheme);

    @Query("Select * from User")
    List<User> getAllusers();

    @Query("Select * from Role")
    List<Role> getAllRole();

    @Query("Select * from AppTheme")
    List<AppTheme> getAllTheme();

    @Update
    public void updateUser(User user);

    @Query("Update Store set JsonString=:jsonString where ID=:id ")
    void updateStatus(String jsonString,String id);





}
