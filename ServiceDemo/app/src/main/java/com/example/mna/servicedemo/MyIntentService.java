package com.example.mna.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    /**
     * Create an IntentService. Invoked by your subclass's constructor.
     *
     * @param name Used to namethe worker thread, important only for debugging.
     */

    public MyIntentService() {

        super("MyIntentThreadWorker");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(this, "service Started", Toast.LENGTH_SHORT).show();
        return  super.onStartCommand(intent,flags,startId);
    }

    /* no add stopSelf() because this IntentService is able to handle itself when all the works in
     * the thread are done
      */
    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this){
            try {
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy(){
        Toast.makeText(this, "service Destroyed",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

}
