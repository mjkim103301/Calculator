package com.example.bottomnavigationproject2.ui.daum;

import android.app.ProgressDialog;
import android.webkit.WebView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DaumViewModel extends ViewModel {

    private MutableLiveData<String> mText;


    public DaumViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(  "http://daum.net");
}


    public LiveData<String> getText() {
        return mText;
    }


}