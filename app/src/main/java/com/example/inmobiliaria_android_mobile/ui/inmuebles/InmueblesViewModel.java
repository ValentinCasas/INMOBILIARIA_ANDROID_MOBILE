package com.example.inmobiliaria_android_mobile.ui.inmuebles;

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

public class InmueblesViewModel extends AndroidViewModel {

    private Context context;
    private ApiClient api;
    private MutableLiveData<ArrayList<Inmueble>> inmueblesMutable;

    public InmueblesViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        api = ApiClient.getApi();
    }

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if(inmueblesMutable == null){
            inmueblesMutable = new MutableLiveData<>();
        }
        return inmueblesMutable;
    }

    public void obtenerPropiedades() {
        if(inmueblesMutable == null){
            inmueblesMutable = new MutableLiveData<>();
        }
        ArrayList<Inmueble> inmuebles = api.obtnerPropiedades();
        inmueblesMutable.postValue(inmuebles);
    }


}