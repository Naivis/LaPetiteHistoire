package com.example.rebierrequentin.lapetitehistoire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * Created by Rebierre Quentin on 20/03/2018.
 */

public class ParametresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parametres);

        this.ajouterSwitch();
    }
//Switchs qui ne restent pas cochés, peut être un bouton valider ou variables dans la BD
    public void ajouterSwitch(){
        final Switch switchSynch = (Switch)this.findViewById(R.id.switchSynch);
        switchSynch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switchSynch.isChecked()){
                    //Traitement -> variable set TRUE
                }
                else{
                    //Traitement -> variable set FALSE
                }
            }
        });

        final Switch switchHasard = (Switch)this.findViewById(R.id.switchHasard);
        switchHasard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switchHasard.isChecked()){
                    //Traitement -> variable set TRUE
                }
                else{
                    //Traitement -> variable set FALSE
                }
            }
        });

        final Switch switchPartage = (Switch)this.findViewById(R.id.switchPartage);
        switchPartage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switchPartage.isChecked()){
                    //Traitement -> variable set TRUE
                }
                else{
                    //Traitement -> variable set FALSE
                }
            }
        });
    }


}
