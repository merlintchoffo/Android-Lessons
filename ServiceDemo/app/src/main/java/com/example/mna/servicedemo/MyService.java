package com.example.mna.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    final class MyThread implements Runnable{
        int serviceId;
        MyThread(int serviceId){
            this.serviceId=serviceId;
        }

        @Override
        public void run() {
            synchronized (this){
                try {
                    wait(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            stopSelf(this.serviceId);
        }
    }
    MediaPlayer player;

    public MyService() {
    }

    @Override
    public void onCreate(){
        //super.onCreate();
        Toast.makeText(this,"service Created",Toast.LENGTH_LONG).show();
        Uri path= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.chien_du_voisin);
        player=MediaPlayer.create(this,path);
        player.setLooping(false);
        player.start();

        //To set setVolume to any value in this range (0-49)
        //player.setVolume(0.2f, 0.0f);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(this, "service Started",Toast.LENGTH_SHORT).show();
        Thread thread=new Thread(new MyThread(startId));
        thread.start();
        return  START_STICKY;
    }

    @Override
    public void onDestroy(){
        Toast.makeText(this, "service Destroyed",Toast.LENGTH_LONG).show();
        player.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }
}
