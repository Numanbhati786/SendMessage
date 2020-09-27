package com.example.sendmessage;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static android.app.PendingIntent.FLAG_ONE_SHOT;

public class FirebaseServise extends FirebaseMessagingService {

    private static String CHANNEL_ID = "my_channel";
    Intent intent;

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        intent = new Intent(this, MainActivity.class);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Toast.makeText(this, "Reciiived", Toast.LENGTH_SHORT).show();
        showNotification(remoteMessage.getNotification().getBody(), remoteMessage.getNotification().getTitle());
     /*   FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isSuccessful()) {
                            String msg = "Failed";
                        }

                    }
                });*/
    }

    public void showNotification(String message, String title) {
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, FLAG_ONE_SHOT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setAutoCancel(true)
                .setContentText(message)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_launcher_background);
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(999, builder.build());
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private void createNotificationChannel(NotificationManager notificationManager) {
        String channelName = "channelName";
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_HIGH);

        {
           /* description = "My channel description";
            enableLights(true)
            lightColor = Color.GREEN*/
        }
        notificationManager.createNotificationChannel(channel);
    }
}
