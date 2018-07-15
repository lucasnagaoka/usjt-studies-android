package br.usjt.deswebmob.aula3_navigation.model.dao;

import android.content.Context;
import android.net.ConnectivityManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.deswebmob.aula3_navigation.Contexto;
import br.usjt.deswebmob.aula3_navigation.model.entity.Pais;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Lucas Nagaoka | RA: 81513916
 * CCP3AN-MCA
 */
public class PaisDAORest implements PaisDAO {

    @Override
    public Pais[] buscarPaises(String url, String regiao) throws IOException {
        OkHttpClient client = new OkHttpClient();
        ArrayList<Pais> paises = new ArrayList<>();
        Request request = new Request.Builder().url(url + regiao.toLowerCase()).build();
        System.out.println(request);

        Response response = client.newCall(request).execute();

        String resultado = response.body().string();

//        Gson gson = new Gson();
//        Pais pais = gson.fromJson(resultado, Pais.class);
//        System.out.println(pais.toString());

        try {
            JSONArray vetor = new JSONArray(resultado);
            for (int i = 0; i < vetor.length(); i++) {
                JSONObject item = (JSONObject) vetor.get(i);
                Pais pais = new Pais();

                try {
                    pais.setArea(item.getInt("area"));
                } catch (Exception e) {
                    pais.setArea(0);
                }

                pais.setBandeira(item.getString("flag"));
                pais.setCapital(item.getString("capital"));
                pais.setNome(item.getString("name"));
                pais.setRegiao(item.getString("region"));
                pais.setCodigo3(item.getString("alpha3Code"));
                pais.setSubRegiao(item.getString("subregion"));
                pais.setDemonimo(item.getString("demonym"));

                try {
                    pais.setGini(item.getDouble("gini"));
                } catch (Exception e) {
                    pais.setGini(0.0);
                }

                try {
                    pais.setPopulacao(item.getInt("population"));
                } catch (Exception e) {
                    pais.setPopulacao(0);
                }

                try {
                    pais.setLatitude(item.getJSONArray("latlng").getDouble(0));
                } catch (Exception e) {
                    pais.setLatitude(0.0);
                }

                try {
                    pais.setLongitude(item.getJSONArray("latlng").getDouble(1));
                } catch (Exception e) {
                    pais.setLongitude(0.0);
                }

//                pais.setDominios(item.getJSONArray("topLevelDomain").getString(0));

//                ArrayList<String> idiomasArray = new ArrayList<>();
//                JSONArray idiomas = item.getJSONArray("languages");
//                System.out.println(idiomas);
//                JSONObject idiomaObject;
//                for (int k = 0; k < idiomas.length(); k++){
//                    idiomaObject = idiomas.getJSONObject(i);
//
//                    idiomasArray.add(idiomaObject.getString( "name"));
//                }
//                pais.setIdiomas(idiomasArray);

                paises.add(pais);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return paises.toArray(new Pais[0]);
    }

    public static boolean isConnected() {
        Context context = Contexto.getValue();
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }
}