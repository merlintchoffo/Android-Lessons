package com.tutosandroidfrance.recyclerviewsample;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Created by merlinngouagna on 01/05/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    List<MyObject> list;
    View.OnClickListener itemClickListener;

    //ajouter un constructeur prenant en entrée une liste
    public MyAdapter(List<MyObject> list,View.OnClickListener itemClickListener) {
        this.list = list;
        this.itemClickListener=itemClickListener;
    }


    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_cards,viewGroup,false);
        //view.setTag(this);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        Log.i("MyAdapter", "0");
        MyObject myObject = list.get(position);
        myViewHolder.itemView.setOnClickListener(itemClickListener);
        myViewHolder.itemView.setTag(this);
        myViewHolder.bind(myObject);
        Log.i("MyAdapter", "1");
    }

    public void removeMyObject(int pos){
        list.remove(pos);
        // notification de la vue sans animation du layout
        notifyDataSetChanged();
        // notification de la vue avec animation du layout
        /*notifyItemRemoved(pos);
        notifyItemRangeChanged(pos, getItemCount());*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
