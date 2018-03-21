package com.example.rebierrequentin.lapetitehistoire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Rebierre Quentin on 20/03/2018.
 */

public class ChoixActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choisir_duree_histoire);

        this.ajouterEcouteurs();
    }

    public void ajouterEcouteurs(){
        Button boutonliste = (Button)this.findViewById(R.id.ToutesLesHistoires);
        boutonliste.setOnClickListener(this);

        Button bouton2min = (Button)this.findViewById(R.id.histoire2min);
        bouton2min.setOnClickListener(this);

        Button bouton5min = (Button)this.findViewById(R.id.histoire5min);
        bouton5min.setOnClickListener(this);

        Button bouton15min = (Button)this.findViewById(R.id.histoire15min);
        bouton15min.setOnClickListener(this);

        Button bouton30min = (Button)this.findViewById(R.id.histoire30min);
        bouton30min.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.ToutesLesHistoires){

            final Intent intentToutes = new Intent(ChoixActivity.this, ExportActivity.class);
            this.startActivity(intentToutes);
        }
        else{
            this.ecouteurExport();
            TextView histoire = (TextView)this.findViewById(R.id.TextView);
            if(v.getId() == R.id.histoire2min){
                histoire.setText("lililililli");
            }

            if(v.getId() == R.id.histoire5min){
                histoire.setText("lululululu");
            }

            if(v.getId() == R.id.histoire15min){
                histoire.setText("lololololololo");
            }

            if(v.getId() == R.id.histoire30min){
                histoire.setText("lylylylylylylylyly");
            }
        }


        if(v.getId() == R.id.Export){
            final Intent export = new Intent(ChoixActivity.this, ExportActivity.class);
            export.putExtra("titre", "LE TITRE DE L'HISTOIRE");
            this.startActivity(export);
        }
    }

    public void ecouteurExport(){
        setContentView(R.layout.histoire);
        ImageButton boutonexport = (ImageButton)this.findViewById(R.id.Export);
        boutonexport.setOnClickListener(this);
        TextView histoire = (TextView)this.findViewById(R.id.TextView);
    }
}
