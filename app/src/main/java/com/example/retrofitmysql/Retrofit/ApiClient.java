package com.example.retrofitmysql.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://192.168.43.151:8080/PhpScript/";// check this line i have forget 8080
   public static Retrofit retrofit=null;
    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            Gson gson = new GsonBuilder().setLenient().create();// also true this line
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create(gson)).build();// check this line in add json
        }
        return retrofit;
    }
}
