package com.iut.laval.mna.commerlinexamunitdevandroid2019;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ConstraintLayout l2 = (ConstraintLayout) findViewById(R.id.header_3);
        TextView tv = (TextView) l2.findViewById(R.id.included_text_view);
        tv.setText("Header Text 3");
    }
}
