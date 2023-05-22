package com.example.inmobiliaria_android_mobile.request;

import com.example.inmobiliaria_android_mobile.modelo.Propietario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public class ApiClientRetrofit {

    private static final String BASE_URL = "http://192.168.0.102:5190/";
    private static EndpointInmobiliaria endpoint;

    public static EndpointInmobiliaria getEndpoint() {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        endpoint = retrofit.create(EndpointInmobiliaria.class);
        return endpoint;
    }

    public interface EndpointInmobiliaria {

        @POST("propietarios/login")
        Call<String> login(@Body Propietario propietario);


        @GET("propietarios/perfil")
        Call<Propietario> obtenerPerfil(@Header("Authorization") String token);
//
//        //        @GET("Inmuebles/{id}") para mandarle un id como parametro (@Path("id") int id)
//        @GET("Inmuebles/0") // Harcodeado 0 por ahora
//        Call<List<Inmueble>> obtenerInmuebles(@Header("Authorization") String token);

    }
}


