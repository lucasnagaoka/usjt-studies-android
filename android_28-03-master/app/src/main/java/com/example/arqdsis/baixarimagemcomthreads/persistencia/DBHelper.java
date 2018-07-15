package com.example.arqdsis.baixarimagemcomthreads.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lucas Nagaoka on 04/04/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "previsao.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE previsao (id INTEGER PRIMARY KEY AUTOINCREMENT, descricao VARCHAR(200), dia_semana VARCHAR(200), nome_cidade VARCHAR(200), min REAL, max REAL, humidade INTEGER, icone VARCHAR(20))";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
