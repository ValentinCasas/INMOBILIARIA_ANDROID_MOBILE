package com.example.inmobiliaria_android_mobile.ui.contratos;

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
import com.example.inmobiliaria_android_mobile.databinding.FragmentContratosBinding;
import com.example.inmobiliaria_android_mobile.databinding.FragmentInquilinosBinding;
import com.example.inmobiliaria_android_mobile.modelo.Inmueble;
import com.example.inmobiliaria_android_mobile.request.ApiClient;
import com.example.inmobiliaria_android_mobile.ui.inquilinos.InquilinosAdapter;
import com.example.inmobiliaria_android_mobile.ui.inquilinos.InquilinosFragment;

import java.util.ArrayList;

public class ContratosFragment extends Fragment {

    private ContratosViewModel mv;
    private FragmentContratosBinding binding;

    public static InquilinosFragment newInstance() {
        return new InquilinosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentContratosBinding.inflate(inflater, container, false);
        mv = new ViewModelProvider(this).get(ContratosViewModel.class);
        View root = binding.getRoot();


        ArrayList<Inmueble> inmuebles = mv.propiedadesAlquiladas();

        RecyclerView rv = binding.rvLista;
        GridLayoutManager grilla = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(grilla);
        ContratosAdapter adapter = new ContratosAdapter(getContext(), inmuebles, getLayoutInflater());
        rv.setAdapter(adapter);

        return root;
    }


}