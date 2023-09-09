package com.example.tp4_navarro.ui.llamar;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


public class LlamarViewModel extends AndroidViewModel {

    private Context context;

    public LlamarViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }

    private MutableLiveData<String> mText;


    public LiveData<String> getText() {
        if (mText == null) {
            mText = new MutableLiveData<>();
        }

        return mText;
    }


    public void llamar(String num) {
        if (num.equals("")||num.length()<10) {
            mText.setValue("Ingrese un numero correcto");
        } else {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + num));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}





