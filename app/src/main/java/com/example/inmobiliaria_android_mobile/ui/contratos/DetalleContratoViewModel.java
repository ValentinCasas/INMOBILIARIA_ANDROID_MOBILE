package com.example.inmobiliaria_android_mobile.ui.contratos;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria_android_mobile.modelo.Contrato;
import com.example.inmobiliaria_android_mobile.modelo.Pago;
import com.example.inmobiliaria_android_mobile.request.ApiClient;

import java.util.ArrayList;

public class DetalleContratoViewModel extends AndroidViewModel {

    private Context context;
    private ApiClient api;
    private MutableLiveData<ArrayList<Pago>> pagosMutable;
    public DetalleContratoViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        api = ApiClient.getApi();
    }

    public LiveData<ArrayList<Pago>> getPagosMutable() {
        if(pagosMutable == null){
            pagosMutable = new MutableLiveData<>();
        }
        return pagosMutable;
    }

    public void obtenerPagos(Contrato contrato){
        if(pagosMutable == null){
            pagosMutable = new MutableLiveData<>();
        }
        ArrayList<Pago> pagos = api.obtenerPagos(contrato);
        pagosMutable.postValue(pagos);
    }


}