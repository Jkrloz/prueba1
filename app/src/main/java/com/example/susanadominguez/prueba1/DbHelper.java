package com.example.susanadominguez.prueba1;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import android.database.Cursor;

import android.widget.TextView;

import java.security.PublicKey;

/**
 * Created by susanadominguez on 14-11-14.
 */


public class DbHelper extends SQLiteOpenHelper{



    String sqlScore = "CREATE TABLE Scores (codigo INTEGER, nombreP1 TEXT, nombreP2 TEXT, fecha TIMESTAMP, " +
            "scoreP1 INTEGER, scoreP2 INTEGER, winp1 BOOLEAN, winp2 BOOLEAN, tie BOOLEAN  )";


    public DbHelper(Context context, String name,
                    CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlScore);


    }

    public void nuevoGanador(SQLiteDatabase sqLiteDatabase, int sp1, int sp2, boolean winp1, boolean winp2, boolean tie){
        String sql = "INSERT INTO Scores (nombreP1, nombreP2, scoreP1, scoreP2, winp1, winp2, tie) VALUES ('Susana','Juanki'" +
                sp1 + "," + sp2 + "," + winp1 + "," + winp2 + ","+ tie+"); ";


    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versionAntigua, int versionNueva) {


        //respaldar datos
        //modificar bd
        //guardar datos
        //ejecutar onCreate
    }
}
