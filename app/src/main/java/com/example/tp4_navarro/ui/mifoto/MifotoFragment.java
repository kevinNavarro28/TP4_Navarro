package com.example.tp4_navarro.ui.mifoto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.tp4_navarro.R;
import com.example.tp4_navarro.databinding.FragmentMifotoBinding;

public class MifotoFragment extends Fragment {

    private FragmentMifotoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MifotoViewModel galleryViewModel =
                new ViewModelProvider(this).get(MifotoViewModel.class);

        binding = FragmentMifotoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        binding.ImgFoto.setImageResource(R.drawable.loro);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}