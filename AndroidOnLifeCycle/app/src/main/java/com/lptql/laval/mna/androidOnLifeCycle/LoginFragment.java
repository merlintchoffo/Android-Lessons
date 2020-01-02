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


public class LoginFragment extends Fragment {

     private EditText txtLogin;
     private EditText txtPassword;
     private Button btnConnect;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container,true);
        txtLogin = (EditText) rootView.findViewById(R.id.txtLogin);
        txtPassword = (EditText) rootView.findViewById(R.id.txtPassword);
        btnConnect = (Button) rootView.findViewById(R.id.btnConnect);
        btnConnect.setOnClickListener(btnConnectListener);

        return rootView;
    }

    private View.OnClickListener btnConnectListener =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.i("DEBUG",txtLogin.getText()+ " / " + txtPassword.getText());

        }
    };

}
