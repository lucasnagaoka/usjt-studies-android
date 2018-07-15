package br.usjt.deswebmob.aula3_navigation.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.usjt.deswebmob.aula3_navigation.model.entity.Pais;

/**
 * Created by Lucas Nagaoka on 04/04/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "pais.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + Pais.PaisEntry.TABLE_NAME + "(" +
                Pais.PaisEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Pais.PaisEntry.COLUMN_NAME_NOME + " TEXT," +
                Pais.PaisEntry.COLUMN_NAME_REGIAO + " TEXT," +
                Pais.PaisEntry.COLUMN_NAME_CAPITAL + " TEXT," +
                Pais.PaisEntry.COLUMN_NAME_BANDEIRA + " TEXT," +
                Pais.PaisEntry.COLUMN_NAME_CODIGO3 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }
}
