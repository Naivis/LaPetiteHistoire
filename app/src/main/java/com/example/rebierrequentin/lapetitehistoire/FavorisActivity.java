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



public class FavorisActivity extends AppCompatActivity implements View.OnClickListener{


    String titre1 = "";
    String texte1= "";
    String titre2 = "";
    String texte2= "";
    String titre3 = "";
    String texte3= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoris);


        this.ajouterEcouteurs();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

        titre1 = pref.getString("TEXTFAV1", "NO");
        texte1 = pref.getString("TITREFAV1", "NO");
        titre2 = pref.getString("TEXTFAV2", "NO");
        texte2 = pref.getString("TITREFAV2", "NO");
        titre3 = pref.getString("TEXTFAV3", "NO");
        texte3 = pref.getString("TITREFAV3", "NO");
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


        if (v.getId() == R.id.fav1) {
                histoire.setText(titre1);
                Titre.setText(texte1);
        }
        if (v.getId() == R.id.fav2) {
                histoire.setText(titre2);
                Titre.setText(texte2);
        }
        if (v.getId() == R.id.fav3) {
                histoire.setText(titre3);
                Titre.setText(texte3);

        }

    }
}
