package com.example.ejercicio24_firmas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.ejercicio24_firmas.transacciones.Transacciones;

import java.util.ArrayList;
import java.util.List;

public class ActivityGaleriaFirmas extends AppCompatActivity {

    RecyclerView estractor;
    ArrayList<firmas> galeria;
    List<firmas> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria_firmas);

        galeria = new ArrayList<>();

        // Inicializar Imagenes
        Obtener_galeria();

        // Obtener el Recycler
        estractor = (RecyclerView) findViewById(R.id.listado_firmas);

        // Usar un administrador para LinearLayout
        estractor.setLayoutManager(new LinearLayoutManager(this));

        // Crear un nuevo adaptador
        Adapter adapter = new Adapter(items);
        estractor.setAdapter(adapter);
    }

    //Arreglo de firmas en lienzo Tokens firmas
    private void Galeria_firmas() {

        items = new ArrayList<>();

        for (int i = 0;  i < galeria.size(); i++){

            items.add(new firmas(
                    galeria.get(i).getId(),
                    galeria.get(i).getImage(),
                    galeria.get(i).getDescripcion()));
        }
    }
    private void Obtener_galeria() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();
        firmas Items = null;
        galeria = new ArrayList<firmas>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Transacciones.tabla_firmas, null);

        while (cursor.moveToNext()) {
            Items = new firmas();
            Items.setId(cursor.getInt(0));
            Items.setImage(cursor.getBlob(1));
            Items.setDescripcion(cursor.getString(2));

            galeria.add(Items);
        }

        cursor.close();
        Galeria_firmas();
    }


}
