package com.example.inmobiliaria_android_mobile.ui.inquilinos;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria_android_mobile.modelo.Inmueble;
import com.example.inmobiliaria_android_mobile.request.ApiClient;

import java.util.ArrayList;

public class InquilinosViewModel extends AndroidViewModel {
    private Context context;
    private ApiClient api;

    public InquilinosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        api = ApiClient.getApi();
    }

    public ArrayList<Inmueble> obtenerPropiedadesAlquiladas(){
        ArrayList<Inmueble> inmuebles = api.obtenerPropiedadesAlquiladas();
        return inmuebles;
    }

}