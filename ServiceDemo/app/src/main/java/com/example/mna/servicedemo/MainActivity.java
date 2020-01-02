package com.example.mna.servicedemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
;

public class MainActivity extends Activity {

    Button startButton;
    Button stopButton;
    Context savedThis = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        startButton = (Button) findViewById((R.id.start));
        stopButton = (Button) findViewById((R.id.stop));
    }

    public void startService(View v) {
        // start the service
        startService(new Intent(savedThis, MyService.class));
    }

    public void stopService(View v) {
        // stop the service
        stopService(new Intent(savedThis, MyService.class));
    }

}