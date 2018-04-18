package com.example.rebierrequentin.lapetitehistoire;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

import static java.security.AccessController.getContext;

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

        Button bouton2min = (Button)this.findViewById(R.id.histoire2min);
        bouton2min.setOnClickListener(this);

        Button bouton5min = (Button)this.findViewById(R.id.histoire5min);
        bouton5min.setOnClickListener(this);

        Button bouton15min = (Button)this.findViewById(R.id.histoire10min);
        bouton15min.setOnClickListener(this);

        Button bouton30min = (Button)this.findViewById(R.id.histoire30min);
        bouton30min.setOnClickListener(this);
    }

    public static int getStringIdentifier(Context context, String titre) {
        return context.getResources().getIdentifier(titre, "string", context.getPackageName());
    }

    @Override
    public void onClick(View v) {

        if ((v.getId() == R.id.histoire2min) || (v.getId() == R.id.histoire5min) || (v.getId() == R.id.histoire10min) || (v.getId() == R.id.histoire30min)) {
            this.ecouteurExport();
            TextView histoire = (TextView) this.findViewById(R.id.TextView);
            TextView Titre = (TextView) this.findViewById(R.id.Titre);
            if (v.getId() == R.id.histoire2min) {
                Random rand = new Random();
                int n = rand.nextInt(3);
                n = n+1;
                String num = String.valueOf(n);

                //Titre
                String titre = "Titre2_" + num;
                int titreH = getStringIdentifier(this, titre);

                //Texte Histoire
                String texte = "Histoire2_"+num;
                int texteH = getStringIdentifier(this, texte);
                histoire.setText(texteH);
                Titre.setText(titreH);
            }

            if (v.getId() == R.id.histoire5min) {

                Random rand = new Random();
                int n = rand.nextInt(3);
                n = n+1;
                String num = String.valueOf(n);

                //Titre
                String titre = "Titre5_" + num;
                int titreH = getStringIdentifier(this, titre);

                //Texte Histoire
                String texte = "Histoire5_"+num;
                int texteH = getStringIdentifier(this, texte);


                histoire.setText(texteH);
                Titre.setText(titreH);
            }

            if (v.getId() == R.id.histoire10min) {

                Random rand = new Random();
                int n = rand.nextInt(2);
                n = n+1;
                String num = String.valueOf(n);

                //Titre
                String titre = "Titre10_" + num;
                int titreH = getStringIdentifier(this, titre);

                //Texte Histoire
                String texte = "Histoire10_"+num;
                int texteH = getStringIdentifier(this, texte);
                histoire.setText(texteH);
                Titre.setText(titreH);

                histoire.setText(texteH);
                Titre.setText(titreH);
            }

            if (v.getId() == R.id.histoire30min) {
                String texte = "Histoire30_1";
                String titre = "Titre30_1";

                int titreH = getStringIdentifier(this, titre);
                int texteH = getStringIdentifier(this, texte);

                histoire.setText(texteH);
                Titre.setText(titreH);
            }
        }
        TextView Titre = (TextView) this.findViewById(R.id.Titre);
        TextView Histoire = (TextView) this.findViewById(R.id.TextView);
        String TextTitre = Titre.getText().toString();
        String TextHistoire = Histoire.getText().toString();
        if (v.getId() == R.id.Export) {
            final Intent export = new Intent(ChoixActivity.this, ExportActivity.class);
            export.putExtra("titre", TextTitre);
            this.startActivity(export);
        }

        if (v.getId() == R.id.boutonFavoris) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            String titre = TextTitre;
            String texte = TextHistoire;
            String titre1 = preferences.getString("TEXTFAV1", "NO");
            String titre2 = preferences.getString("TEXTFAV2", "NO");
            String titre3 = preferences.getString("TEXTFAV3", "NO");

            if((!(titre1.equals("NO"))) && (!(titre2.equals("NO"))) && (!(titre3.equals("NO")))){
                Toast.makeText(ChoixActivity.this, "Favoris remplis ! ", Toast.LENGTH_SHORT).show();
            }
            else{
                if((titre3.equals("NO"))){
                    editor.putString("TEXTFAV3", texte);
                    editor.putString("TITREFAV3", titre);
                    editor.apply();

                    Toast.makeText(ChoixActivity.this, "Favoris ajouté ! ", Toast.LENGTH_SHORT).show();
                }
                else{
                    if((titre2.equals("NO"))){
                        editor.putString("TEXTFAV2", texte);
                        editor.putString("TITREFAV2", titre);
                        editor.apply();

                        Toast.makeText(ChoixActivity.this, "Favoris ajouté ! ", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        editor.putString("TEXTFAV1", texte);
                        editor.putString("TITREFAV1", titre);
                        editor.apply();

                        Toast.makeText(ChoixActivity.this, "Favoris ajouté ! ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    public void ecouteurExport(){
        setContentView(R.layout.histoire);
        ImageButton boutonexport = (ImageButton)this.findViewById(R.id.Export);
        boutonexport.setOnClickListener(this);
        ImageButton boutonfav = (ImageButton)this.findViewById((R.id.boutonFavoris));
        boutonfav.setOnClickListener(this);
    }

}
