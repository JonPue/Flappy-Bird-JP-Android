package com.sandipbhattacharya.flappybird;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity implements View.OnClickListener {

    TextView tvScore, tvPersonalBest;
    Button btnEstadistica;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        int score = getIntent().getExtras().getInt("score");
        SharedPreferences pref = getSharedPreferences("MyPref",0);
        int scoreSP = pref.getInt("scoreSP",0);
        SharedPreferences.Editor editor = pref.edit();
        if(score > scoreSP){
            scoreSP = score;
            editor.putInt("scoreSP", scoreSP);
            editor.commit();
        }
        tvScore = findViewById(R.id.tvScore);
        tvPersonalBest = findViewById(R.id.tvPersonalBest);
        tvScore.setText(""+score);
        tvPersonalBest.setText(""+scoreSP);

        btnEstadistica=findViewById(R.id.btnEstadistica);
        btnEstadistica.setOnClickListener(this);

        SQLiteDatabase DB = MainActivity.DBOH.getReadableDatabase();
        DB.execSQL("INSERT INTO MiCuenta (id,Puntos,RecordPersonal) values (?,?,?)", new String[]{String.valueOf(DBOpenHelper.getActualId()), tvScore.getText().toString(), "1"});
        DB.close();
    }

    public void restart(View view){
        Intent intent = new Intent(GameOver.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view){
        finish();
    }

    @Override
    public void onClick(View view) {
        if (view == btnEstadistica){
            Intent i = new Intent(this, EstadisticasActivity.class);
            startActivity(i);
        }
    }
}
