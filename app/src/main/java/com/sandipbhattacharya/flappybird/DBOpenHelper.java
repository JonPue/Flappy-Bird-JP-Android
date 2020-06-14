package com.sandipbhattacharya.flappybird;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {

    public static String tablePermisos = "create table Premios (ID integer, NombreMedalla text, Puntos integer)";
    public static String tableMiCuenta = "create table MiCuenta (ID integer, Puntos integer, RecordPersonal integer)";


    public DBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLite) {
        sqLite.execSQL(tablePermisos);
        sqLite.execSQL(tableMiCuenta);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDB, int i, int i1) {
        sqLiteDB.execSQL("drop table Premios");
        sqLiteDB.execSQL("drop table MiCuenta");

        sqLiteDB.execSQL(tablePermisos);
        sqLiteDB.execSQL(tableMiCuenta);

    }
    public static int getActualId(){
        SQLiteDatabase DB = MainActivity.DBOH.getReadableDatabase();
        Cursor c = DB.rawQuery("SELECT id from MiCuenta ORDER BY id DESC", null);
        if (c.moveToFirst()){
            return c.getInt(0) + 1;
        }
        else{
            return 1;
        }
    }
}
