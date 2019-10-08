package com.example.bottomnavigationproject2.ui.naver;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NaverViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NaverViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(  "http://naver.com");
    }

    public LiveData<String> getText() {
        return mText;
    }
}