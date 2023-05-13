package com.example.inmobiliaria_android_mobile.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliaria_android_mobile.modelo.Propietario;
import com.example.inmobiliaria_android_mobile.request.ApiClient;

public class PerfilViewModel extends AndroidViewModel {

    private Context context;
    private ApiClient api;
    private MutableLiveData<Propietario> dataPropietarioMutable;
    private MutableLiveData<String> valorBotonMutable;

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        api = ApiClient.getApi();

    }

    public LiveData<String> getValorBotonMutable() {
        if (valorBotonMutable == null) {
            valorBotonMutable = new MutableLiveData<>();
        }
        return valorBotonMutable;
    }

    public LiveData<Propietario> getDataPropietarioMutable() {
        if (dataPropietarioMutable == null) {
            dataPropietarioMutable = new MutableLiveData<>();
        }
        return dataPropietarioMutable;
    }

    public void cargarPropietarioLogueado() {
        if (dataPropietarioMutable == null) {
            dataPropietarioMutable = new MutableLiveData<>();
        }
        dataPropietarioMutable.setValue(api.obtenerUsuarioActual());
    }

    ;


    public void cambiarTextoBoton(String estadoBtn, Long dni, String nombre, String apellido, String email, String clave, String telefono) {
        if (valorBotonMutable == null) {
            valorBotonMutable = new MutableLiveData<>();
        }

        if (estadoBtn.equals("EDITAR")) {
            valorBotonMutable.setValue("GUARDAR");
        } else {

            Propietario propietario = dataPropietarioMutable.getValue();
            propietario.setDni(dni);
            propietario.setNombre(nombre);
            propietario.setApellido(apellido);
            propietario.setEmail(email);
            propietario.setContraseña(clave);
            propietario.setTelefono(telefono);

            api.actualizarPerfil(propietario);
            valorBotonMutable.setValue("EDITAR");
        }

    }
}






