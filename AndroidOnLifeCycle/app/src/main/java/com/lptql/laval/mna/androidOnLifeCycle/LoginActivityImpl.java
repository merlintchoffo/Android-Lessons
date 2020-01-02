package com.lptql.laval.mna.androidOnLifeCycle;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivityImpl extends AppCompatActivity
                               implements LoginFragment2Impl.OnFragmentInteractionListener {
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtEmail = (EditText) findViewById(R.id.username);
        txtPassword = (EditText) findViewById(R.id.password);
        btnConnect = (Button) findViewById(R.id.login);
        btnConnect.setEnabled(true);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.i("INFO",txtEmail.getText()+ " / " + txtPassword.getText());

    }
}
