package com.example.astudiosqltest01;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class Repository {
    private final PresidentDao presidentDao;
    private LiveData<List<President>> presidentList;

    public Repository(Context context) {
        //create a database object
        AppDatabase db = AppDatabase.getInstance(context);
        //create an interface object
        presidentDao = db.presidentDao();
        //call interface method
        presidentList = presidentDao.getPresidents();
    }

    LiveData<List<President>> getAllPresidents() {
        return presidentList;
    }

    public void insert(President president) {
        presidentDao.insertPresident(president);
    }
}
