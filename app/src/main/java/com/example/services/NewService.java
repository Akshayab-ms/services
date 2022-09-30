package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class NewService extends Service {


    private MediaPlayer player;

    @Override

    public int onStartCommand(Intent intent, int flags, int startId) {

        player = MediaPlayer.create( this, Settings.System.DEFAULT_RINGTONE_URI );


        player.setLooping( true );
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();



        player.start();

        return START_STICKY;
    }


    @Override


    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
