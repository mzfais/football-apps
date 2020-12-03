package id.ac.itn.gibolapps;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class Gibol extends Application {
    public static final String CHANNEL_ID = "GibolChannel";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel myChannel = new NotificationChannel(CHANNEL_ID, "Channel 1", NotificationManager.IMPORTANCE_HIGH);
            myChannel.setDescription("This Gila Bola Channel");
            Context context;
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(myChannel);
        }
    }

}
