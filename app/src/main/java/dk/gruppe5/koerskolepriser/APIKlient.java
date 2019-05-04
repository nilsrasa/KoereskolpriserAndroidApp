package dk.gruppe5.koerskolepriser;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIKlient {

    private static Retrofit retrofit = null;

    static Retrofit getKlient() {

        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/koereskole_REST/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }
}
