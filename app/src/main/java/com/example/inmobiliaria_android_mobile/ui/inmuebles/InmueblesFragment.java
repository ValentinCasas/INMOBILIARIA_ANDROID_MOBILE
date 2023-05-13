package com.example.inmobiliaria_android_mobile.ui.inmuebles;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inmobiliaria_android_mobile.R;
import com.example.inmobiliaria_android_mobile.databinding.FragmentInmueblesBinding;
import com.example.inmobiliaria_android_mobile.modelo.Inmueble;
import com.example.inmobiliaria_android_mobile.request.ApiClient;

import java.util.ArrayList;

public class InmueblesFragment extends Fragment {

    private InmueblesViewModel mv;
    private FragmentInmueblesBinding binding;
    private ApiClient api;

    public static InmueblesFragment newInstance() {
        return new InmueblesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentInmueblesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        api = ApiClient.getApi();

        ArrayList<Inmueble> inmuebles = api.obtnerPropiedades();
        RecyclerView rv = binding.rvLista;
        GridLayoutManager grilla = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(grilla);
        InmueblesAdapter adapter = new InmueblesAdapter(getContext(), inmuebles, getLayoutInflater());
        rv.setAdapter(adapter);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mv = new ViewModelProvider(this).get(InmueblesViewModel.class);
        // TODO: Use the ViewModel
    }

}