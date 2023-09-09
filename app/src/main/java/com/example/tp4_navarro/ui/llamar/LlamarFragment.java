package com.example.tp4_navarro.ui.llamar;

import static androidx.core.app.ActivityCompat.requestPermissions;
import static androidx.core.content.PermissionChecker.checkSelfPermission;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.Manifest;


import com.example.tp4_navarro.databinding.FragmentLlamarBinding;

public class LlamarFragment extends Fragment {
    private LlamarViewModel mv;

    private FragmentLlamarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LlamarViewModel LlamarViewModedl =
               mv = new ViewModelProvider(this).get(LlamarViewModel.class);

            binding = FragmentLlamarBinding.inflate(inflater, container, false);
            View root = binding.getRoot();



        mv.getText().observe(getViewLifecycleOwner(),  new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.TvMensajeError.setText(s);
            }
        });
        binding.BtLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.llamar(binding.EtLlamar.getText().toString());


            }
        });



            return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

