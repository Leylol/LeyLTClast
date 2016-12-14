package com.gmail.leylol.leyltc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by User on 14-Dec-16.
 */

public class MyAlert {


    //Explicit


    private Context context;
    private String TitleStrint, messageStrint;
    private int anInt;

    public MyAlert(Context context, String titleStrint, String messageStrint, int anInt) {
        this.context = context;
        TitleStrint = titleStrint;
        this.messageStrint = messageStrint;
        this.anInt = anInt;
    }


    public void MyDialog() {


        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(anInt);
        builder.setTitle(TitleStrint);
        builder.setMessage(messageStrint);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();


    }


}   //Main Class
