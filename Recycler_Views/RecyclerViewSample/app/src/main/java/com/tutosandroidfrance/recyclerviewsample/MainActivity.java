package com.tutosandroidfrance.recyclerviewsample;

import android.content.Context;
/* import android.support.v7.app.ActionBarActivity;
The use of ActionBarActivity now is deprecated */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


/**
 * Created by merlinngouagna on 01/05/16.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;

    private List<MyObject> cities = new ArrayList<>();
    int g_Position;
    MyAdapter g_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //remplir la ville
        ajouterVilles();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //définit l'agencement des cellules, ici de façon verticale, comme une ListView
        recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));

        //pour adapter en grille comme une RecyclerView, avec 2 cellules par ligne
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        //puis créer un MyAdapter, lui fournir notre liste de villes.
        //cet adapter servira à remplir notre recyclerview
        g_Adapter=new MyAdapter(cities,this);
        recyclerView.setAdapter(g_Adapter);
    }

    public class WrapContentLinearLayoutManager extends LinearLayoutManager {
        public WrapContentLinearLayoutManager(Context context, int vertical, boolean b) {
            super(context);
        }

        //... constructor
        @Override
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                super.onLayoutChildren(recycler, state);
            } catch (IndexOutOfBoundsException e) {
                Log.e("probe", "meet a IOOBE in RecyclerView");
            }
        }
    }

    private void ajouterVilles() {
       // Resources res = getResources();
        //Drawable drawable = res.getDrawable(R.drawable.parisguidetower);

        //Uri path= Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.parisguidetower);
        cities.add(new MyObject("France", "android.resource://" + getPackageName() + "/" + R.drawable.parisguidetower));
        cities.add(new MyObject("Angleterre","android.resource://" + getPackageName() + "/" + R.drawable.image));
        cities.add(new MyObject("Allemagne","android.resource://" + getPackageName() + "/" + R.drawable.image));
        cities.add(new MyObject("Espagne","android.resource://" + getPackageName() + "/" + R.drawable.image));
        cities.add(new MyObject("Italie","android.resource://" + getPackageName() + "/" + R.drawable.image));
        cities.add(new MyObject("Russie","android.resource://" + getPackageName() + "/" + R.drawable.image));
    }

    private void save(){
        Toast.makeText(this,R.string.action_save,Toast.LENGTH_LONG).show();
    }

    private void delete(int position){
        g_Adapter.removeMyObject(position);
        Toast.makeText(this,position,Toast.LENGTH_LONG).show();
        //Toast.makeText(this,R.string.action_delete,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    //gère le click sur une action de l'ActionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save:
                save();
                return true;
            case R.id.action_delete:
                delete(g_Position);
                return true;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (view.getTag()!=null){
             g_Position = (int) view.getTag();
            Toast.makeText(this,cities.get(g_Position).getText() ,Toast.LENGTH_LONG).show();

        }
    }

}
