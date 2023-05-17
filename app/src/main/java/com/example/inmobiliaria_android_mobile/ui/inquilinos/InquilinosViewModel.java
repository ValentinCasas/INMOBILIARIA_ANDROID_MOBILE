package com.example.inmobiliaria_android_mobile.ui.inquilinos;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria_android_mobile.modelo.Inmueble;
import com.example.inmobiliaria_android_mobile.request.ApiClient;

import java.util.ArrayList;

public class InquilinosViewModel extends AndroidViewModel {
    private Context context;
    private ApiClient api;
    private MutableLiveData<ArrayList<Inmueble>> inmueblesAlquilados;

    public InquilinosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        api = ApiClient.getApi();
    }

    public LiveData<ArrayList<Inmueble>> getInmueblesAlquilados() {
        if(inmueblesAlquilados == null){
            inmueblesAlquilados = new MutableLiveData<>();
        }
        return inmueblesAlquilados;
    }

    public void obtenerPropiedadesAlquiladas(){
        if(inmueblesAlquilados == null){
            inmueblesAlquilados = new MutableLiveData<>();
        }
        ArrayList<Inmueble> inmuebles = api.obtenerPropiedadesAlquiladas();
        inmueblesAlquilados.postValue(inmuebles);
    }

}