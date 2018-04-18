package com.example.rebierrequentin.lapetitehistoire;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Rebierre Quentin on 20/03/2018.
 */

public class FavorisActivity extends AppCompatActivity implements View.OnClickListener{


    String titre1 = "";
    String texte1= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoris);


        this.ajouterEcouteurs();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

        titre1 = pref.getString("FAVORI1", "NO");
        texte1 = pref.getString("FAVORI2", "NO");
    }

    public void ajouterEcouteurs(){
        Button boutonfav1 = (Button)this.findViewById(R.id.fav1);
        boutonfav1.setOnClickListener(this);

        Button boutonfav2 = (Button)this.findViewById(R.id.fav2);
        boutonfav2.setOnClickListener(this);

        Button boutonfav3 = (Button)this.findViewById(R.id.fav3);
        boutonfav3.setOnClickListener(this);
    }

    public void ecouteurExport(){
        setContentView(R.layout.histoire);
        ImageButton boutonexport = (ImageButton)this.findViewById(R.id.Export);
        boutonexport.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        setContentView(R.layout.histoire_fav);
        TextView histoire = (TextView) this.findViewById(R.id.TextView_fav);
        TextView Titre = (TextView) this.findViewById(R.id.Titre_fav);

        //String Titre_fav = "Histoires favorites";
       // String Texte_fav = "Pas encore d'histoire favorites pour le moment!";

        if (v.getId() == R.id.fav1) {
            histoire.setText(titre1);
            Titre.setText(texte1);
        }

    }
}
