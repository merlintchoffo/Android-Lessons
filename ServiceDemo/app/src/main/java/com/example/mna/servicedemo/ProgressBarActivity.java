package com.example.mna.servicedemo;

import java.lang.ref.WeakReference;

import android.app.Activity;
import android.content.Context;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by mna on 15/03/2016.
 */
public class ProgressBarActivity extends Activity {
    // Taille maximale du téléchargement

    public final static int MAX_SIZE = 100;

    // Identifiant de la boîte de dialogue

    public final static int ID_DIALOG = 0;

    // Bouton qui permet de démarrer le téléchargement

    private Button mBouton;


    private ProgressTask mProgress = null;

    // La boîte en elle-même

    private ProgressDialog mDialog = null;


    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mBouton = (Button) findViewById(R.id.button);

        mBouton.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View arg0) {

                // On recrée à chaque fois l'objet

                mProgress = new ProgressTask(ProgressBarActivity.this);

                // On l'exécute

                mProgress.execute();

            }

        });


        // On recupère l'AsyncTask perdu dans le changement de configuration

       mProgress = (ProgressTask) getLastNonConfigurationInstance();


        if(mProgress != null)

            // On lie l'activité à l'AsyncTask

            mProgress.link(this);

    }


    @Override

    protected Dialog onCreateDialog (int id) {

        mDialog = new ProgressDialog(this);

        mDialog.setCancelable(true);

        mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override

            public void onCancel(DialogInterface arg0) {

                mProgress.cancel(true);

            }

        });

        mDialog.setTitle("Téléchargement en cours");

        mDialog.setMessage("Patientez...");

        mDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        mDialog.setMax(MAX_SIZE);

        return mDialog;

    }


    @Override

    public Object onRetainNonConfigurationInstance () {

        return mProgress;

    }


    // Met à jour l'avancement dans la boîte de dialogue

    void updateProgress(int progress) {

        mDialog.setProgress(progress);

    }


    // L'AsyncTask est bien une classe interne statique

    static class ProgressTask extends AsyncTask<Void, Integer, Boolean> {

        // Référence faible à l'activité

        private WeakReference<ProgressBarActivity> mActivity = null;

        // Progression du téléchargement

        private int mProgression = 0;


        public ProgressTask (ProgressBarActivity pActivity) {

            link(pActivity);

        }


        @Override

        protected void onPreExecute () {

            // Au lancement, on affiche la boîte de dialogue

            if(mActivity.get() != null)

                mActivity.get().showDialog(ID_DIALOG);

        }


        @Override

        protected void onPostExecute (Boolean result) {

            if (mActivity.get() != null) {

                if(result)

                    Toast.makeText(mActivity.get(), "Téléchargement terminé", Toast.LENGTH_SHORT).show();

                else

                    Toast.makeText(mActivity.get(), "Echec du téléchargement", Toast.LENGTH_SHORT).show();

            }

        }


        @Override

        protected Boolean doInBackground (Void... arg0) {

            try {

                while(download() != MAX_SIZE) {

                    publishProgress(mProgression);

                    Thread.sleep(1000);

                }

                return true;

            }catch(InterruptedException e) {

                e.printStackTrace();
                Log.d("Exception", "doInBackground: ");

                return false;

            }

        }


        @Override

        protected void onProgressUpdate (Integer... prog) {

            // À chaque avancement du téléchargement, on met à jour la boîte de dialogue

            if (mActivity.get() != null)

                mActivity.get().updateProgress(prog[0]);

        }


        @Override

        protected void onCancelled () {

            if(mActivity.get() != null)

                Toast.makeText(mActivity.get(), "Annulation du téléchargement", Toast.LENGTH_SHORT).show();

        }


        public void link (ProgressBarActivity pActivity) {

            mActivity = new WeakReference<ProgressBarActivity>(pActivity);

        }


        public int download() {

            if(mProgression <= MAX_SIZE) {

                mProgression=mProgression+10;

                return mProgression;

            }

            return MAX_SIZE;

        }

    }
}
