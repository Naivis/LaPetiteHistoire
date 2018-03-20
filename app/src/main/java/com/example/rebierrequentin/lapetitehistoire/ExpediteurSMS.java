package com.example.rebierrequentin.lapetitehistoire;

import android.content.Context;
import android.telephony.SmsManager;

/**
 * Created by Rebierre Quentin on 20/03/2018.
 */

public class ExpediteurSMS {

    private void partagerTitre(String titre, String destinatiare, Context context){
        SmsManager.getDefault().sendTextMessage(destinatiare,null,titre,null,null);
    }

}
