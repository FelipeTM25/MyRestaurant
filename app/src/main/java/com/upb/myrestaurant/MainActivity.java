package com.upb.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirMenu(View v){
        Intent i = new Intent(this , MenuActivity.class);
        startActivity(i);
    }
    public void abrirSedes(View v){
        Intent i = new Intent(this , MapsActivity.class);
        startActivity(i);
    }
    public void abrirCalificion(View v){
        Intent i = new Intent(this , CalificacionActivity.class);
        startActivity(i);
    }
    public void abrirPedido(View v) {
        String url = "https://api.whatsapp.com/send?phone="
                + getString(R.string.numero_whatsapp)
                + "&text="
                + Uri.encode(getString(R.string.mensaje_pedido));

        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } catch (PackageManager.NameNotFoundException e) {
            // WhatsApp no está instalado
            e.getMessage();
        }
    }

    public void abrirReserva(View v) {
        String url = "https://api.whatsapp.com/send?phone="
                + getString(R.string.numero_whatsapp)
                + "&text="
                + Uri.encode(getString(R.string.mensaje_reserva));

        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } catch (PackageManager.NameNotFoundException e) {
            // WhatsApp no está instalado
            e.getMessage();
        }
    }
}
