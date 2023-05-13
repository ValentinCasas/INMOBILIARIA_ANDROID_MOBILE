package com.example.inmobiliaria_android_mobile.ui.inmuebles;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.inmobiliaria_android_mobile.R;
import com.example.inmobiliaria_android_mobile.databinding.FragmentDetalleInmuebleBinding;
import com.example.inmobiliaria_android_mobile.databinding.FragmentInmueblesBinding;
import com.example.inmobiliaria_android_mobile.modelo.Inmueble;
import com.example.inmobiliaria_android_mobile.request.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class DetalleInmuebleFragment extends Fragment {

    private DetalleInmuebleViewModel mv;
    private FragmentDetalleInmuebleBinding binding;
    private Inmueble inmueble;
    private ApiClient api;

    public static DetalleInmuebleFragment newInstance() {
        return new DetalleInmuebleFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetalleInmuebleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        api = ApiClient.getApi();

        api = ApiClient.getApi();
        Bundle bundle = getArguments();
        inmueble = (Inmueble) bundle.getSerializable("inmueble");

        binding.tvCodigo.setText(String.valueOf(inmueble.getIdInmueble()));
        binding.tvAmbientes.setText(String.valueOf(inmueble.getAmbientes()));
        binding.tvDireccion.setText(inmueble.getDireccion());
        binding.tvPrecio.setText(String.valueOf(inmueble.getPrecio()));
        binding.tvUso.setText(inmueble.getUso());
        binding.tvTipo.setText(inmueble.getTipo());
        Picasso.get().load(inmueble.getImagen()).into(binding.imageView2);
        binding.cbEstado.setChecked(inmueble.isEstado());
        binding.cbEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inmueble.setEstado(binding.cbEstado.isChecked());
                api.actualizarInmueble(inmueble);
            }
        });


        return root;
    }


}