package com.example.rebierrequentin.lapetitehistoire;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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

    }
}