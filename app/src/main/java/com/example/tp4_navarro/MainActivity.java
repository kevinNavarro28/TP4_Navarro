package com.example.tp4_navarro;

import static androidx.core.content.PermissionChecker.checkSelfPermission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.tp4_navarro.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mv;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)
                != PermissionChecker.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},2500);
        }
        binding.BtIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.ingresar(binding.EtEmail.getText().toString(),binding.EtPassword.getText().toString());

            }

        });
        mv.getMAle().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvAlerta.setText(s);
            }
        });

    }


}