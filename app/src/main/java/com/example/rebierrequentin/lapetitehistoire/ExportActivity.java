package com.example.rebierrequentin.lapetitehistoire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ExportActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.export);
        this.ecouteur();
    }

    private void ecouteur(){
        Button envoyer = (Button)this.findViewById(R.id.Envoyer);
        envoyer.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent export = getIntent();
        String titre = export.getExtras().getString("titre", "").toString();
        EditText dest = (EditText)this.findViewById(R.id.NumDest);
        String destinatiare = dest.getText().toString();

        SmsManager.getDefault().sendTextMessage(destinatiare,null,titre,null,null);


    }
}
