package com.lptql.laval.mna.androidOnLifeCycle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class LoginFragment2 extends Fragment {

     private EditText txtEmail;
     private EditText txtPassword;
     private Button btnConnect;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login2, container,true);
        txtEmail = (EditText) rootView.findViewById(R.id.username);
        txtPassword = (EditText) rootView.findViewById(R.id.password);
        btnConnect = (Button) rootView.findViewById(R.id.login);
        //    btnConnect.setEnabled(true);
        btnConnect.setOnClickListener(btnConnectListener);

        return rootView;
    }

    private View.OnClickListener btnConnectListener =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.i("DEBUG",txtEmail.getText()+ " / " + txtPassword.getText());

        }
    };

}
