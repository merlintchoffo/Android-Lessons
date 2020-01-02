package com.tutosandroidfrance.recyclerviewsample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by merlinngouagna on 22/03/2018.
 */


public class ImageActivity extends Activity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Log.i("ImageActivity", "Bonjour onCreate");
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            imageView.setImageBitmap((Bitmap) bundle.getParcelable("image"));
            textView.setText(bundle.getString("title"));
        }

    }


}
