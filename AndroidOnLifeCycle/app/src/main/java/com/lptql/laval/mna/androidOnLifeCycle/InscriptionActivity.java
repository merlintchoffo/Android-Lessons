package com.lptql.laval.mna.androidOnLifeCycle;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class InscriptionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String profileType="parent";
    private Connector connector;
    private int newId=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        Spinner leSpinner=(Spinner)findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.users_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        leSpinner.setAdapter(adapter);
        leSpinner.setOnItemSelectedListener(this);

        final EditText nom=(EditText) findViewById(R.id.inscriNom);
        final EditText prenom=(EditText)findViewById(R.id.inscriPrenom);
        final EditText telephone=(EditText)findViewById(R.id.inscriTelephone);
        final EditText ville=(EditText)findViewById(R.id.inscriVille);
        final EditText email=(EditText)findViewById(R.id.inscriMail);
        final EditText mdp=(EditText)findViewById(R.id.inscriMdp);

        Button leOk=(Button)findViewById(R.id.inscriptOK);
        leOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!nom.getText().toString().equals("") &&
                        !prenom.getText().toString().equals("") &&
                        !telephone.getText().toString().equals("") &&
                        !ville.getText().toString().equals("") &&
                        !email.getText().toString().equals("") &&
                        !mdp.getText().toString().equals("")) {
                    Call<String> call = connector.registerUser(
                            nom.getText().toString(),
                            prenom.getText().toString(),
                            Integer.parseInt(telephone.getText().toString()),
                            email.getText().toString(),
                            ville.getText().toString(),
                            mdp.getText().toString(),
                            profileType,
                            "insert");
                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                            System.out.println(response.raw());
                            finish();
                            //Intent myIntent = new Intent(Inscription.this, Logon.class);
                            //startActivity(myIntent);
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast toast = Toast.makeText(getApplicationContext(), "echec: " + t.toString(), Toast.LENGTH_SHORT);
                            toast.show();
                            t.printStackTrace();
                        }
                    });
                }


                }
        });
          buildClient();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        /**
         * TO DO
         **/
        profileType="nounou";
        if(!adapterView.getItemAtPosition(i).equals("Nounou")){
            //child=getLayoutInflater().inflate(R.layout.inscription_parent, null);
            profileType="parent";
        }
        /**
        item.addView(child);
         **/
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /**
     * Clean all the fields
     */
    public void clean(){
        EditText nom=(EditText) findViewById(R.id.inscriNom);
        nom.setText("");
        EditText prenom=(EditText)findViewById(R.id.inscriPrenom);
        prenom.setText("");
        EditText telephone=(EditText)findViewById(R.id.inscriTelephone);
        telephone.setText("");
        EditText ville=(EditText)findViewById(R.id.inscriVille);
        ville.setText("");
        EditText email=(EditText)findViewById(R.id.inscriMail);
        email.setText("");
        EditText mdp=(EditText)findViewById(R.id.inscriMdp);
        mdp.setText("");
    }

    /**
     * If enough parameters
     */
    public boolean checkCa(){
        boolean ret=false;
        EditText nom=(EditText) findViewById(R.id.inscriNom);
        EditText prenom=(EditText)findViewById(R.id.inscriPrenom);
        EditText telephone=(EditText)findViewById(R.id.inscriTelephone);
        EditText ville=(EditText)findViewById(R.id.inscriVille);
        EditText email=(EditText)findViewById(R.id.inscriMail);
        EditText mdp=(EditText)findViewById(R.id.inscriMdp);
        if(!nom.getText().toString().equals("") &&
                !prenom.getText().toString().equals("") &&
                !telephone.getText().toString().equals("") &&
                !ville.getText().toString().equals("") &&
                !email.getText().toString().equals("") &&
                !mdp.getText().toString().equals("")){
            ret=true;
        }
        return ret;
    }

    public void buildClient(){
        Retrofit retrofit = null;
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Connector.ENDPOINT)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        connector = retrofit.create(Connector.class);
    }

}
