package com.example.arqdsis.baixarimagemcomthreads.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.arqdsis.baixarimagemcomthreads.Previsao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Nagaoka on 04/04/2018.
 */

public class PrevisaoDAO {
    private Context context;

    public PrevisaoDAO(Context context) {
        this.context = context;
    }

    public long inserir(Previsao previsao) {
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("descricao", previsao.getDescricao());
        cv.put("dia_semana", previsao.getDiaDaSemana());
        cv.put("nome_cidade", previsao.getNomeCidade());
        cv.put("min", previsao.getMin());
        cv.put("max", previsao.getMax());
        cv.put("humidade", previsao.getHumidade());
        cv.put("icone", previsao.getIcone());

        long id = db.insert("previsao", null, cv);
        db.close();

        return id;
    }

    public List<Previsao> buscarTodos() {
        List <Previsao> previsoes = new ArrayList<>();
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.query("previsao", null, null, null, null, null, null);

        Previsao p = null;
        c.moveToFirst();

        while(c.moveToNext()) {
            p = new Previsao();
            p.setDescricao(c.getString(c.getColumnIndexOrThrow("descricao")));
            p.setDiaDaSemana(c.getString(c.getColumnIndexOrThrow("dia_semana")));
            p.setNomeCidade(c.getString(c.getColumnIndexOrThrow("nome_cidade")));
            p.setMin(c.getDouble(c.getColumnIndexOrThrow("min")));
            p.setMax(c.getDouble(c.getColumnIndexOrThrow("max")));
            p.setHumidade(c.getInt(c.getColumnIndexOrThrow("humidade")));
            p.setIcone(c.getString(c.getColumnIndexOrThrow("icone")));

            previsoes.add(p);
        }
        c.close();

        return previsoes;
    }
}
