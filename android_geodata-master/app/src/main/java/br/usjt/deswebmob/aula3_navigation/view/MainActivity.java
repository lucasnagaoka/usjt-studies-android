package br.usjt.deswebmob.aula3_navigation.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import br.usjt.deswebmob.aula3_navigation.Contexto;
import br.usjt.deswebmob.aula3_navigation.model.dao.PaisDAORest;
import br.usjt.deswebmob.aula3_navigation.R;
import br.usjt.deswebmob.aula3_navigation.model.entity.Pais;
import br.usjt.deswebmob.aula3_navigation.model.dao.PaisDAODb;
import br.usjt.deswebmob.aula3_navigation.presenter.MainPresenter;

/**
 * @author Lucas Nagaoka | RA: 81513916
 * CCP3AN-MCA
 */

public class MainActivity extends Activity implements MainView {
    public static final String CHAVE = "br.usjt.deswebmob.aula3_navigation.txtContinente";

    Spinner spinnerContinente;
    Intent intent;
    ProgressBar loader;
    Context contexto;
    MainPresenter presenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerContinente = (Spinner) findViewById(R.id.spinnerContinente);
        spinnerContinente.setOnItemSelectedListener(new RegiaoSelecionada());
        loader = (ProgressBar) findViewById(R.id.loader);
        loader.setVisibility(View.INVISIBLE);
        Contexto.setValue(this);
        presenter.onCreate();
    }

    /**
     * @author Lucas Nagaoka | RA: 81513916
     * CCP3AN-MCA
     */
    public void listarPaises(View view) {
        loader.setVisibility(View.VISIBLE);
        if (!presenter.isOnline()) {
            Toast.makeText(this,
                    getApplicationContext().getResources().
                            getString(R.string.msg_rede),
                    Toast.LENGTH_SHORT).show();
        }
        new CarregaPaises().execute("pais");
    }

    @Override
    public String[] getRegioes() {
        return getApplicationContext().getResources().
                getStringArray(R.array.continentes);
    }

    public void newActivity(Pais[] paises) {
        intent = new Intent(this, ListaPaisesActivity.class);
        intent.putExtra(CHAVE, paises);
        startActivity(intent);
        loader.setVisibility(View.INVISIBLE);
    }

    /**
     * @author Lucas Nagaoka | RA: 81513916
     * CCP3AN-MCA
     */
    private class RegiaoSelecionada implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String continente = (String) parent.getItemAtPosition(position);
            presenter.selecionarRegiao(continente);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    /**
     * @author Lucas Nagaoka | RA: 81513916
     * CCP3AN-MCA
     */
    private class CarregaPaisesDoBanco extends AsyncTask<String, Void, Pais[]> {

        @Override
        protected Pais[] doInBackground(String... params) {
            PaisDAODb db = new PaisDAODb(contexto);
            Pais[] paises = db.buscarPaises("", "");
            return paises;
        }

        public void onPostExecute(Pais[] paises) {
            intent.putExtra(CHAVE, paises);
            startActivity(intent);
        }
    }

    private class CarregaPaises extends AsyncTask<String, Void, Pais[]> {

        @Override
        protected Pais[] doInBackground(String... params) {
            return presenter.buscarPaises();
        }

        public void onPostExecute(Pais[] paises) {
            newActivity(paises);
        }
    }

//    private class BuscaJSONTodos extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected String doInBackground(String... url) {
//            OkHttpClient client = new OkHttpClient();
//            final Request request = new Request.Builder().url(url[0]).build();
//
//            try {
//                return client.newCall(request).execute().body().string();
//            } catch (IOException e) {
//                e.printStackTrace();
//                String erro = String.format("{%s : %s}", "erro", e.getMessage());
//                return erro;
//            }
//        }
//
//        @Override
//        protected void onPostExecute(String json) {
//            Toast.makeText(MainActivity.this, json, Toast.LENGTH_SHORT).show();
//
//            try {
//                JSONObject previsao = new JSONObject(json);
//                JSONArray list = previsao.getJSONArray("list");
//                JSONObject dia = list.getJSONObject(0);
//                long dt = dia.getLong("dt");
//                double min = dia.getJSONObject("temp").getDouble("min");
//                double max = dia.getJSONObject("temp").getDouble("max");
//                int humidade = dia.getInt("humidity");
//                String descricao = dia.getJSONArray("weather").getJSONObject(0).getString("description");
//                Date date = new Date();
//                date.setTime(dt * 1000);
//                descricaoTextView.setText(String.format("%s : %s", sdf.format(date), descricao));
//                minTextView.setText("Min: " + Double.toString(min));
//                maxTextView.setText("Max: " + Double.toString(max));
//                humidityTextView.setText("Hum: " + Double.toString(humidade));
//
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
}
