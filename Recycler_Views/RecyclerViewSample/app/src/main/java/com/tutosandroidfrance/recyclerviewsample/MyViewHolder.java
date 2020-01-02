package com.tutosandroidfrance.recyclerviewsample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import static android.view.View.*;

/**
 * Created by merlinngouagna on 01/05/16.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewView;
    private ImageView imageView;
    private LinearLayout main;

    //itemView est la vue correspondante à 1 cellule
    public MyViewHolder(final View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView
        CardView cardView = (CardView) itemView.findViewById(R.id.card_view);
        textViewView = (TextView) itemView.findViewById(R.id.text);
        imageView = (ImageView) itemView.findViewById(R.id.image);
        main = (LinearLayout) itemView.findViewById(R.id.linearLayout);

        /*cardView.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(itemView.getContext(), ImageActivity.class);

                imageView.buildDrawingCache();
                Bitmap image = imageView.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putParcelable("image", image);
                extras.putString("title", textViewView.getText().toString());
                intent.putExtras(extras);

                        Log.i("ImageActivity", "Bonjour");

                itemView.getContext().startActivity(intent);

            }
        });*/

        textViewView.setOnLongClickListener(new OnLongClickListener(){

            @Override
            public boolean onLongClick(View view) {
                MyAdapter adapter = (MyAdapter) itemView.getTag();
                adapter.removeMyObject(MyViewHolder.this.getAdapterPosition());
                Log.i("MyHolder", "onLongClick");
                return false;
            }
        });

    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(MyObject myObject){

        textViewView.setText(myObject.getText());
        Picasso.with(imageView.getContext()).load(myObject.getImageUrl()).centerCrop().fit().into(imageView);
    }


}