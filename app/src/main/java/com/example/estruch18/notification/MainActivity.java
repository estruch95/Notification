package com.example.estruch18.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.media.audiofx.BassBoost;
import android.media.audiofx.EnvironmentalReverb;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    private Button btnNotificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotificacion = (Button)findViewById(R.id.btn_notificacion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void accionBtnNotificacion(View v){
        btnNotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creación de la notificación
                Notification.Builder notificacion = new Notification.Builder(getApplicationContext());
                //Inserción de un título, una pequeña imagen y un texto en ella
                notificacion.setContentTitle("Notificación de prueba!");
                //Large Icon
                notificacion.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.advertencia));
                //Small Icon
                notificacion.setSmallIcon(R.drawable.advertencia);
                notificacion.setContentText("Esta notificación es empleada para modo pruebas");
                //Sonido  de la notificación
                notificacion.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
                //Vibración de la notificación
                notificacion.setVibrate(new long[]{1000,1000});

                //Creamos un objeto NotificationManager (llama al servicio de notificaciones)
                NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                //Notificamos
                nm.notify(1, notificacion.build());
            }
        });
    }
}
