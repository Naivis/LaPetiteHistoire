package com.example.rebierrequentin.lapetitehistoire;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ajoutEcouteurSurBoutons();
    }

    private void ajoutEcouteurSurBoutons(){
        Button boutonlire = (Button)this.findViewById(R.id.Lire);
        boutonlire.setOnClickListener(this);

        Button boutonfav = (Button)this.findViewById(R.id.Favoris);
        boutonfav.setOnClickListener(this);

        Button boutonparam = (Button)this.findViewById(R.id.Parametres);
        boutonparam.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.Lire){

            final Intent intentLecture = new Intent(MainActivity.this, LectureActivity.class);
            this.startActivity(intentLecture);
        }

        if(v.getId() == R.id.Favoris){

            final Intent intentFav = new Intent(MainActivity.this, FavorisActivity.class);
            this.startActivity(intentFav);
        }

        if(v.getId() == R.id.Parametres){

            final Intent intentParam = new Intent(MainActivity.this, ParametresActivity.class);
            this.startActivity(intentParam);
        }


    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Quitter")
                .setMessage("Voulez vous vraiment quitter?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();

                    }
                }).create().show();

    }
}
