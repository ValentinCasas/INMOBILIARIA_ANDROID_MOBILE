package com.example.inmobiliaria_android_mobile.request;

import com.example.inmobiliaria_android_mobile.R;
import com.example.inmobiliaria_android_mobile.modelo.*;

import java.util.ArrayList;


public class ApiClient {
    private ArrayList<Propietario> propietarios = new ArrayList<>();
    private ArrayList<Inquilino> inquilinos = new ArrayList<>();
    private ArrayList<Inmueble> inmuebles = new ArrayList<>();
    private ArrayList<Contrato> contratos = new ArrayList<>();
    private ArrayList<Pago> pagos = new ArrayList<>();
    private static Propietario usuarioActual = null;
    private static ApiClient api = null;

    private ApiClient() {
        //Nos conectamos a nuestra "Base de Datos"
        cargaDatos();
    }

    //Método para crear una instancia de ApiClient
    public static ApiClient getApi() {
        if (api == null) {
            api = new ApiClient();
        }
        return api;

    }


    //Servicios
    //Para que pueda iniciar sesion
    public Propietario login(String mail, final String password) {
        for (Propietario propietario : propietarios) {
            if (propietario.getEmail().equals(mail) && propietario.getContraseña().equals(password)) {
                usuarioActual = propietario;
                return propietario;
            }
        }
        return null;
    }


    //Retorna el usuario que inició Sesión
    public Propietario obtenerUsuarioActual() {
        return usuarioActual;
    }

    //Retorna todas las propiedades del usuario propietario logueado
    public ArrayList<Inmueble> obtnerPropiedades() {
        ArrayList<Inmueble> temp = new ArrayList<>();
        for (Inmueble inmueble : inmuebles) {
            if (inmueble.getPropietario().equals(usuarioActual)) {
                temp.add(inmueble);
            }
        }
        return temp;
    }

    //Lista de inmuebles alquilados actualmente del propietario logueado.
    public ArrayList<Inmueble> obtenerPropiedadesAlquiladas() {
        ArrayList<Inmueble> temp = new ArrayList<>();
        for (Contrato contrato : contratos) {
            if (contrato.getInmueble().getPropietario().equals(usuarioActual)) {
                temp.add(contrato.getInmueble());
            }
        }
        return temp;
    }


//Dado un inmueble retorna el contrato activo de dicho inmueble

    public Contrato obtenerContratoVigente(Inmueble inmueble) {

        for (Contrato contrato : contratos) {
            if (contrato.getInmueble().equals(inmueble)) {
                return contrato;
            }
        }
        return null;
    }

    //Dado un inmueble, retorna el inquilino del ultimo contrato activo de ese inmueble.
    public Inquilino obtenerInquilino(Inmueble inmueble) {
        for (Contrato contrato : contratos) {
            if (contrato.getInmueble().equals(inmueble)) {
                return contrato.getInquilino();
            }
        }
        return null;
    }

    //Dado un Contrato, retorna los pagos de dicho contrato
    public ArrayList<Pago> obtenerPagos(Contrato contratoVer) {
        ArrayList<Pago> temp = new ArrayList<>();
        for (Contrato contrato : contratos) {
            if (contrato.equals(contratoVer)) {
                for (Pago pago : pagos) {
                    if (pago.getContrato().equals(contrato)) {
                        temp.add(pago);
                    }
                }
            }
            break;
        }
        return temp;
    }

    //Actualizar Perfil
    public void actualizarPerfil(Propietario propietario) {
        int posición = propietarios.indexOf(propietario);
        if (posición != -1) {
            propietarios.set(posición, propietario);
        }
    }

    //ActualizarInmueble
    public void actualizarInmueble(Inmueble inmueble) {
        int posicion = inmuebles.indexOf(inmueble);
        if (posicion != -1) {
            inmuebles.set(posicion, inmueble);
        }
    }

    private void cargaDatos() {

        //Propietarios
        Propietario juan = new Propietario(1, 23492012L, "Juan", "Perez", "juan@mail.com", "123", "2664553447", R.drawable.juan);
        Propietario sonia = new Propietario(2, 17495869L, "Sonia", "Lucero", "sonia@mail.com", "123", "266485417", R.drawable.sonia);
        propietarios.add(juan);
        propietarios.add(sonia);

        //Inquilinos
        Inquilino mario = new Inquilino(100, 25340691L, "Mario", "Luna", "Aiello sup.", "luna@mail.com", "2664253411", "Lucero Roberto", "2664851422");
        inquilinos.add(mario);

        //Inmuebles
        Inmueble salon = new Inmueble(501, "Colon 340", "comercial", "salon", 2, 20000, juan, true, "https://th.bing.com/th/id/R.a1cd4689da0958fe1524e4ac5a4fe01e?rik=B7B6L5nVFRAlOw&riu=http%3a%2f%2fsignificadosdelossuenos.net%2fwp-content%2fuploads%2f2016%2f11%2fso%c3%b1ar-con-casa1.jpg&ehk=1nftatmTkDEDUOxvQCmllYUad0SuQnYKmMYw1rHVCMo%3d&risl=&pid=ImgRaw&r=0");
        Inmueble casa = new Inmueble(502, "Mitre 800", "particular", "casa", 2, 15000, juan, true, "https://tse1.mm.bing.net/th/id/OIP.EQlsEd3sB3hXjLIftp-mvAHaEb?pid=ImgDet&rs=1");
        Inmueble otraCasa = new Inmueble(503, "Salta 325", "particular", "casa", 3, 17000, sonia, true, "https://tse4.mm.bing.net/th/id/OIP.-L35HHQiFf-aM9ViyJEB_AHaE8?pid=ImgDet&rs=1");
        Inmueble dpto = new Inmueble(504, "Lavalle 450", "particular", "dpto", 2, 25000, sonia, true, "https://tse3.mm.bing.net/th/id/OIP.c_0GyjYrp-z3cI7-jxy6ngHaEK?pid=ImgDet&w=1280&h=720&rs=1");
        Inmueble casita = new Inmueble(505, "Belgrano 218", "particular", "casa", 5, 90000, sonia, true, "https://tse4.mm.bing.net/th/id/OIP.5133nOxe77Y1mFgHI6PyHwHaFj?pid=ImgDet&w=640&h=480&rs=1");

        inmuebles.add(salon);
        inmuebles.add(casa);
        inmuebles.add(otraCasa);
        inmuebles.add(dpto);
        inmuebles.add(casita);

        //Contratos
        Contrato uno = new Contrato(701, "05/08/2020", "05/08/2023", 17000, mario, otraCasa);
        contratos.add(uno);
        //Pagos
        pagos.add(new Pago(900, 1, uno, 17000, "10/08/2020"));
        pagos.add(new Pago(901, 2, uno, 17000, "10/09/2020"));
        pagos.add(new Pago(902, 3, uno, 17000, "10/10/2020"));


    }
}
