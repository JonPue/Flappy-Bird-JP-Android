package com.sandipbhattacharya.flappybird;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class EstadisticasActivity extends AppCompatActivity implements View.OnClickListener {
    DBOpenHelper Conexion;
    ArrayList<MiCuenta> ListCuenta;

    RecyclerView rvEstadisticas;

    Button Salir;
    Button Reiniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        RefrescarLista();

        Reiniciar = findViewById(R.id.btnReiniciar);
        Salir = findViewById(R.id.btnSalir);

        Reiniciar.setOnClickListener(this);
        Salir.setOnClickListener(this);

    }

    private void RefrescarLista() {
        Conexion = new DBOpenHelper(this, "FlappyBirdDB", null, 1);
        ListCuenta = new ArrayList<>();

        rvEstadisticas = findViewById(R.id.rvEstadisticas);
        rvEstadisticas.setLayoutManager(new LinearLayoutManager(this));

        QueryListMiCuenta();

        EstadisticasAdapter adapter=new EstadisticasAdapter(this, ListCuenta);
        rvEstadisticas.setAdapter(adapter);
    }

    private void QueryListMiCuenta() {
        SQLiteDatabase DB = Conexion.getReadableDatabase();

        MiCuenta Micuenta = null;

        Cursor cursor = DB.rawQuery("Select * from MiCuenta ORDER BY Puntos DESC", null);

        while (cursor.moveToNext()){
            Micuenta = new MiCuenta();
            Micuenta.setId(cursor.getInt(0));
            Micuenta.setPuntos(cursor.getInt(1));
            Micuenta.setRecordPersonal(cursor.getInt(2));
            ListCuenta.add(Micuenta);
        }
        DB.close();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnReiniciar:
                Intent i = new Intent (this,MainActivity.class);
                startActivity(i);
            case R.id.btnSalir:
                finish();
        }
    }
}
