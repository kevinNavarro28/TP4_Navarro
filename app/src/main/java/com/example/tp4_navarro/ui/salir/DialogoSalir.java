package com.example.tp4_navarro.ui.salir;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class DialogoSalir {
    public static void Salir(Activity activity) {
        new AlertDialog.Builder(activity)
                .setTitle("Menu Navegable")
                .setMessage("cerrar Aplicacion ?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(activity, "continuamos trabajando", Toast.LENGTH_LONG).show();
                    }
                }).show();
    }
}
