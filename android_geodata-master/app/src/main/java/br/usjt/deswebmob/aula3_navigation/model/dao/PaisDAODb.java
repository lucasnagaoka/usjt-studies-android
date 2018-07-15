package br.usjt.deswebmob.aula3_navigation.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.usjt.deswebmob.aula3_navigation.model.entity.Pais;

/**
 * @author Lucas Nagaoka | RA: 81513916
 * CCP3AN-MCA
 */
public class PaisDAODb implements PaisDAO {
    private Context context;

    public PaisDAODb(Context context) {
        this.context = context;
    }

    public void inserir(Pais[] paises) {
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        db.delete("pais", null, null);

        for(Pais pais:paises){
            ContentValues cv = new ContentValues();
            cv.put(Pais.PaisEntry.COLUMN_NAME_NOME, pais.getNome());
            cv.put(Pais.PaisEntry.COLUMN_NAME_REGIAO, pais.getRegiao());
            cv.put(Pais.PaisEntry.COLUMN_NAME_CAPITAL, pais.getCapital());
            cv.put(Pais.PaisEntry.COLUMN_NAME_BANDEIRA, pais.getBandeira());
            cv.put(Pais.PaisEntry.COLUMN_NAME_CODIGO3, pais.getCodigo3());

            db.insert("pais", null, cv);
        }

        db.close();
    }

    @Override
    public Pais[] buscarPaises(String url, String regiao) {
        List<Pais> paises = new ArrayList<Pais>();
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.query("pais", null, null, null, null, null, null);

        Pais p = null;
        c.moveToFirst();

        while(c.moveToNext()) {
            p = new Pais();
            p.setNome(c.getString(c.getColumnIndexOrThrow(Pais.PaisEntry.COLUMN_NAME_NOME)));
            p.setRegiao(c.getString(c.getColumnIndexOrThrow(Pais.PaisEntry.COLUMN_NAME_REGIAO)));
            p.setCapital(c.getString(c.getColumnIndexOrThrow(Pais.PaisEntry.COLUMN_NAME_CAPITAL)));
            p.setBandeira(c.getString(c.getColumnIndexOrThrow(Pais.PaisEntry.COLUMN_NAME_BANDEIRA)));
            p.setCodigo3(c.getString(c.getColumnIndexOrThrow(Pais.PaisEntry.COLUMN_NAME_CODIGO3)));

            paises.add(p);
        }
        c.close();

        if(paises.size()> 0) {
            return paises.toArray(new Pais[0]);
        } else {
            return new Pais[0];
        }
    }
}
