package com.example.sendmessage;

import com.example.sendmessage.FirebaseApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://fcm.googleapis.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    FirebaseApi api = retrofit.create(FirebaseApi.class);
}
