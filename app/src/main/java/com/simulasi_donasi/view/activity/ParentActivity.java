package com.simulasi_donasi.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Macdoze on 4/25/2017.
 */

public class ParentActivity extends AppCompatActivity {

    /*
    * TO-DO
    * move one Activity to another Activity inside the Application
    */
    public static void doChangeActivity (Context context, Class destination) {
        Intent _intent = new Intent(context, destination);
        _intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(_intent);
    }
}
