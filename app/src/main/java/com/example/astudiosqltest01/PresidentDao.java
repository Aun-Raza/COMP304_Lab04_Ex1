package com.example.astudiosqltest01;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

@Dao
public interface PresidentDao {
    @Insert
    void insertPresident(President president);

    @Query("select * from President order by name")
    LiveData<List<President>> getPresidents();
}
