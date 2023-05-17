package com.example.inmobiliaria_android_mobile.ui.contratos;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inmobiliaria_android_mobile.R;;
import com.example.inmobiliaria_android_mobile.databinding.FragmentDetalleContratoBinding;
import com.example.inmobiliaria_android_mobile.modelo.Contrato;
import com.example.inmobiliaria_android_mobile.modelo.Inmueble;
import com.example.inmobiliaria_android_mobile.modelo.Inquilino;
import com.example.inmobiliaria_android_mobile.modelo.Pago;
import com.example.inmobiliaria_android_mobile.request.ApiClient;

import java.util.ArrayList;


public class DetalleContratoFragment extends Fragment {

    private FragmentDetalleContratoBinding binding;
    private Contrato contrato;
    private DetalleContratoViewModel mv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDetalleContratoBinding.inflate(getLayoutInflater());
        mv = new ViewModelProvider(this).get(DetalleContratoViewModel.class);
        View root = binding.getRoot();


        Bundle bundle = getArguments();
        contrato = (Contrato) bundle.getSerializable("contratoDelInmueble");

        Inquilino inquilino = contrato.getInquilino();
        Inmueble inmueble = contrato.getInmueble();

        binding.tvCodigo.setText(String.valueOf(contrato.getIdContrato()));
        binding.tvMontoMensual.setText(String.valueOf(contrato.getMontoAlquiler()));
        binding.tvFechaInicio.setText(contrato.getFechaInicio());
        binding.tvFechaFinalizacion.setText(contrato.getFechaFin());
        binding.tvInquilino.setText(inquilino.getNombre());
        binding.tvInmueble.setText(inmueble.getDireccion());

        binding.btnPagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                Bundle bundle = new Bundle();
                bundle.putSerializable("pagosAsociados", mv.obtenerPagos(contrato));
                navController.navigate(R.id.nav_detallePagosFragment, bundle);
            }
        });

        return root;
    }


}