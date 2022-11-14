package com.example.astudiosqltest01;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private Repository repository;
    private LiveData<List<President>> _presidents;

    public MainActivityViewModel(Application application) {
        repository = new Repository(application);
        _presidents = repository.getAllPresidents();
    }

    public LiveData<List<President>> getPresidents() {
        return _presidents;
    }
}
