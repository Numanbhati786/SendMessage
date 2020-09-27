package com.example.sendmessage;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface FirebaseApi {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAYHGEzgo:APA91bFnuPwUzFELXYjJIt9sj8_1JjgrqtTxLa6BgfGCEUsH96xvHyVvAqPAAvQAw0Rwu9t1UMkhXoZg55VjNYJNb1timZsM_ftXPsGq9eGwY3h6u5inyeaxZ3yABZzgah2QbHARU1-u" // Your server key refer to video for finding your server key
            }
    )

    @POST("fcm/send")
    Call<Message> sendNotifcation(@Body Message body);
}
