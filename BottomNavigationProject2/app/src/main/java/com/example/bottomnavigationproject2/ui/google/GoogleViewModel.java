package com.example.bottomnavigationproject2.ui.google;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GoogleViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GoogleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(  "http://google.co.kr");
    }

    public LiveData<String> getText() {
        return mText;
    }
}