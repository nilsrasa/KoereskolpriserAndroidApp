package dk.gruppe5.koerskolepriser;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class APIKlient {

    private static Retrofit retrofit = null;

    public static Retrofit getKlient() {

        retrofit = new Retrofit.Builder()
                .baseUrl("http://dist.saluton.dk:5401/koereskole_REST/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }
}
