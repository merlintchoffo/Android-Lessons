package com.lptql.laval.mna.androidOnLifeCycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    private final String LOG_TAG = NextActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Log.d(LOG_TAG, "calling onCreate from Next Activity");
        TextView textView = findViewById(R.id.text_view);
        textView.setText(MainActivity.getValue());
        Intent intent = getIntent();

        if (intent != null) {
            // Le code pour récupérer les extras ira ici
            if (intent.hasExtra("edittext")) { // vérifie qu'une valeur est associée à la clé “edittext”
                Bundle extra=intent.getExtras();
                String extraMessage = extra.getString("edittext"); // on récupère la valeur associée à la clé
                int nbLettre = intent.getIntExtra("nbLettre", 0);
                textView = (TextView) findViewById(R.id.text_view);
                textView.setText(extraMessage + "; " + nbLettre);
            }
        }

        Button button = findViewById(R.id.gotoregister);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {

                    case R.id.gotoregister:
                        Intent intent = new Intent(NextActivity.this, InscriptionActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "calling onStart from Next Activity");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "calling onResume  from Next Activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "calling onPause  from Next Activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "calling onStop  from Next Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "calling onDestroy  from Next Activity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "calling onRestart  from Next Activity");
    }
}
