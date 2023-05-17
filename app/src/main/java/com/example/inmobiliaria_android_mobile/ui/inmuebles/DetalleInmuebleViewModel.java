package com.example.inmobiliaria_android_mobile.ui.inmuebles;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria_android_mobile.modelo.Contrato;
import com.example.inmobiliaria_android_mobile.modelo.Inmueble;
import com.example.inmobiliaria_android_mobile.modelo.Pago;
import com.example.inmobiliaria_android_mobile.request.ApiClient;

import java.util.ArrayList;

public class DetalleInmuebleViewModel extends AndroidViewModel {

    private Context context;
    private ApiClient api;

    public DetalleInmuebleViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        api = ApiClient.getApi();
    }

    public void actualizarInmueble(Inmueble inmueble) {
        api.actualizarInmueble(inmueble);
    }
}