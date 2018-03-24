package com.example.rebierrequentin.lapetitehistoire;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ajoutEcouteurSurBoutons();

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[],
                                           int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intentMenu1 = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(intentMenu1);
                            finish();
                        }
                    }, 3000);

                } else {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intentMenu2 = new Intent(MainActivity.this, ParametresActivity.class);
                            startActivity(intentMenu2);
                            finish();
                        }
                    }, 3000);
                }
                return;
            }
        }
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

            final Intent intentLecture = new Intent(MainActivity.this, ChoixActivity.class);
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
                .setMessage("Voulez-vous vraiment quitter?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();

                    }
                }).create().show();

    }
}
