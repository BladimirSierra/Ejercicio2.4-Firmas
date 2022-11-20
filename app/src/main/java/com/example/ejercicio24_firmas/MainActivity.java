package com.example.ejercicio24_firmas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicio24_firmas.transacciones.Transacciones;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText descripcion;
    Button btn_guardar, btn_galeria;
    View Lienzo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        descripcion = (EditText) findViewById(R.id.txt_ingreso_descripcion);
        Lienzo = (View) findViewById(R.id.lienzo_firma);

        btn_guardar = (Button)findViewById(R.id.btn_guardar);
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar_firma();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

        });

        btn_galeria = (Button)findViewById(R.id.btn_galeria);
        btn_galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityGaleriaFirmas.class);
                startActivity(intent);
            }
        });
    }

    public void guardar_firma(){

        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        try{

            ContentValues valores = new ContentValues();

            valores.put(Transacciones.image, Ver_firma(Lienzo));
            valores.put(Transacciones.descripcion, descripcion.getText().toString());

            Long resultado = db.insert(Transacciones.tabla_firmas, Transacciones.id, valores);

            Toast.makeText(getApplicationContext(), "FIRMA INGRESADA: " + resultado.toString(), Toast.LENGTH_LONG).show();


        }
        catch (Exception e){
            e.printStackTrace();
        }
        Limpiar_pantalla();

    }
    public static byte[]  Ver_firma(View Lienzo) {
        Lienzo.setDrawingCacheEnabled(true);
        Bitmap bitmap = Lienzo.getDrawingCache();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

        byte[] byteArray = stream.toByteArray();
        return byteArray;

    }

    private void Limpiar_pantalla() {
        descripcion.setText("");
        //Lienzo.setText("");
    }
}