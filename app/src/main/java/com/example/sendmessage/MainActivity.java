package com.example.sendmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;

import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private EditText title, message, token;
    private Button btn;
    private FirebaseApi apiService;
    /*   public static String TOPIC = "SONU";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.etTitle);
        message = findViewById(R.id.etMessage);
        token = findViewById(R.id.etToken);
        btn = findViewById(R.id.btnSend);
        apiService = Client.getClient("https://fcm.googleapis.com/").create(FirebaseApi.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("MyNotification", "MyNotification", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificationChannel);

        }
        FirebaseMessaging.getInstance().subscribeToTopic("general");
              /*  .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isSuccessful()) {
                            String msg = "Failed";
                            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                        }

                    }
                });*/


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*    sendNotificationTo();*/
              sendNotificationTo();
                /*    Intent intent = new Intent(this,  .class)*/
              /*  Kotlinclassbus kotlin = new Kotlinclassbus();
                kotlin.onlytext(title);*/
              /*  if (!title.getText().toString().equals("")) {
                    Kotlin send = new Kotlin();
                    send.sendnotificationmethod(title.getText().toString(), message.getText().toString(), TOPIC);
                } else {
                    Toast.makeText(MainActivity.this, " chod", Toast.LENGTH_SHORT).show();
                }*/
            }
        });
    }

    public void sendNotificationTo() {
        NotificationData data = new NotificationData("title", "message");
        Message sender = new Message("general", data);
        apiService.sendNotifcation(sender).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if (response.isSuccessful()) {
                       Log.d("Numan", " Response:   Response:${Gson().toJson(response)}" );
                    Toast.makeText(MainActivity.this, "Response", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {

            }
        });

  /*      Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fcm.googleapis.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FirebaseApi api = retrofit.create(FirebaseApi.class);*/
        /* Call<Message> call = api.sendMessage("key=AAAAB7O4O3w:APA91bEM_tcnUxW5DmgKAZB5jlGFU183j7d0Icjznid4A9behUj7RrGNq8kVV6-ZKAVoGI-ViKIiekFHdl0ZYuOWWskKmpyrbmYrVKP-2SELunD9alhkfkvP-RyXEP00fJrmFGeaKpfE", message);*/
  /*      call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if (call.isExecuted()) {
                    Toast.makeText(MainActivity.this, "abvga", Toast.LENGTH_SHORT).show();
                }
                if (response.isSuccessful()) {
                    *//*     Toast.makeText(MainActivity.this, "Response", Toast.LENGTH_SHORT).show();*//*
                } else {
                    Toast.makeText(MainActivity.this, "problem", Toast.LENGTH_SHORT).show();
                }
                *//*  Toast.makeText(MainActivity.this, "Response", Toast.LENGTH_SHORT).show();*//*
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failure", Toast.LENGTH_SHORT).show();
            }
        });*/



/*    private void secondmethod() {
        RequestQueue mRequestQue = Volley.newRequestQueue(this);
        JSONObject json = new JSONObject();
        try {
            json.put("to", "general");
            JSONObject notificationobject = new JSONObject();
            notificationobject.put("title", "NEW ORDER");
            notificationobject.put("body", "bla  bla bla");
            json.put("notification", notificationobject);

            String URL = "https://fcm.googleapis.com/fcm/send";
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, URL, json, response -> Log.d("MUR", "onREsponse: ")
                    , error -> Log.d("MUR", "onError: " + error.networkResponse)) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> header = new HashMap<>();
                    header.put("content-type", "application/json");
                    header.put("authorization", "key=AAAAB7O4O3w:APA91bEM_tcnUxW5DmgKAZB5jlGFU183j7d0Icjznid4A9behUj7RrGNq8kVV6-ZKAVoGI-ViKIiekFHdl0ZYuOWWskKmpyrbmYrVKP-2SELunD9alhkfkvP-RyXEP00fJrmFGeaKpfE");
                    return header;
                }
            };
            mRequestQue.add(request);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }*/
    }
}
