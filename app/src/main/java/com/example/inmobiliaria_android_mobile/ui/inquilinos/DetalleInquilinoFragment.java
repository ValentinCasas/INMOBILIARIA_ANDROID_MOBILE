package com.example.inmobiliaria_android_mobile.ui.inquilinos;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inmobiliaria_android_mobile.R;
import com.example.inmobiliaria_android_mobile.databinding.FragmentDetalleInmuebleBinding;
import com.example.inmobiliaria_android_mobile.databinding.FragmentDetalleInquilinoBinding;
import com.example.inmobiliaria_android_mobile.modelo.Inmueble;
import com.example.inmobiliaria_android_mobile.modelo.Inquilino;
import com.example.inmobiliaria_android_mobile.request.ApiClient;

public class DetalleInquilinoFragment extends Fragment {

    private FragmentDetalleInquilinoBinding binding;
    private Inquilino inquilino;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDetalleInquilinoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Bundle bundle = getArguments();
        inquilino = (Inquilino) bundle.getSerializable("inquilino");


        binding.tvCodigo.setText(String.valueOf(inquilino.getIdInquilino()));
        binding.tvDni.setText(String.valueOf(inquilino.getDNI()));
        binding.tvNombre.setText(inquilino.getNombre());
        binding.tvApellido.setText(inquilino.getApellido());
        binding.tvMail.setText(inquilino.getEmail());
        binding.tvTelefono.setText(inquilino.getTelefono());
        binding.tvTelefonoGarante.setText(inquilino.getTelefonoGarante());
        binding.tvGarante.setText(inquilino.getNombreGarante());


        return root;
    }
}
