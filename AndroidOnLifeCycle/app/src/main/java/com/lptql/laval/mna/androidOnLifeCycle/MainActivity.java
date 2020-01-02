package com.lptql.laval.mna.androidOnLifeCycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String MESSAGE = "STAR WARS 9";
    private final String LOG_TAG = MainActivity.class.getSimpleName();
    private static String value;
    public static String getValue() {
        return value;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "calling onCreate from MainActivity");
        final EditText editText = findViewById(R.id.edit_text);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {

                    case R.id.button:
                        value = editText.getText().toString().trim();
                        Intent intent = new Intent(MainActivity.this, NextActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.button2:
                        toNextActivity(v);
                        break;
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "calling onStart from MainActivity");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "calling onResume  from MainActivity");
        final EditText editText = findViewById(R.id.edit_text);
        editText.setText(MESSAGE); // TO DO
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "calling onPause  from MainActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "calling onStop  from MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "calling onDestroy  from MainActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "calling onRestart  from MainActivity");
    }
    public void toNextActivity(View view){
        Log.d(LOG_TAG, "calling Next Activity");
        final EditText editText = findViewById(R.id.edit_text);
        final TextView tv = findViewById(R.id.tv);
        String ch2=editText.getText().toString();
        String ch1= tv.getText().toString();
       String extraMessage=ch1+ " : " + ch2;
        int nbLettre = extraMessage.length();
        Intent intent = new Intent(this, NextActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("edittext", extraMessage);
        bundle.putInt("nbLettre", nbLettre);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
