package com.project.newsapp.network;

import android.content.Context;

import com.ashokvarma.gander.GanderInterceptor;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    //todo: asign API key here
    private static final String API_KEY = "fbe1027061c94e6b8790073f39a19e60";
    private static final String BASE_URL = "https://newsapi.org/v2/";

    public static Retrofit newInstance(Context context) {
        // create an OkHttpClient (equivalent to Apache)
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor()) //headerInterceptor
                //.addInterceptor(new GanderInterceptor(context).showNotification(true))
                .addNetworkInterceptor(new StethoInterceptor())

                .build();

        //provide BASE_URL, converterFactory Gson used less memory but slower than Jackson
        //Android choose Gson for smaller memory/space
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    // header interceptor, add data in header
    // the key required in header might be the same, just initialize in request to store key
    private static class HeaderInterceptor implements Interceptor {

        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request original = chain.request();
            Request request = original
                    .newBuilder()
                    .header("X-Api-Key", API_KEY) // add parameter to reduce duplicate code
                    .build();
            return chain.proceed(request);
        }
    }
}
