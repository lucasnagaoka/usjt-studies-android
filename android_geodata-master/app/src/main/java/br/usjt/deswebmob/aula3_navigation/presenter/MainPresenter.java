package br.usjt.deswebmob.aula3_navigation.presenter;

import android.app.Activity;

import java.io.IOException;

import br.usjt.deswebmob.aula3_navigation.R;
import br.usjt.deswebmob.aula3_navigation.model.dao.PaisDAORest;
import br.usjt.deswebmob.aula3_navigation.model.entity.Pais;
import br.usjt.deswebmob.aula3_navigation.model.entity.Regiao;
import br.usjt.deswebmob.aula3_navigation.model.service.PaisService;
import br.usjt.deswebmob.aula3_navigation.view.MainView;

public class MainPresenter implements Presenter {
    private MainView view;
    private PaisService service;
    Pais[] paises;
    private Regiao regiao;
    private boolean online;

    public MainPresenter(MainView view) {
        this.view = view;
        regiao = Regiao.all;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public Pais[] buscarPaises(){
        Pais[] paises = null;
        service = new PaisService(online);
        try{
            paises = service.buscarPaises("https://restcountries.eu/rest/v2/", regiao.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paises;
    }

    public void selecionarRegiao(String continente) {
        String[] continentes = view.getRegioes();
        if (continente.equals(continentes[0])) {
            regiao = Regiao.all;
        } else if (continente.equals(continentes[1])) {
            regiao = Regiao.Africa;
        } else if (continente.equals(continentes[2])) {
            regiao = Regiao.Americas;
        } else if (continente.equals(continentes[3])) {
            regiao = Regiao.Asia;
        } else if (continente.equals(continentes[4])) {
            regiao = Regiao.Europe;
        } else if (continente.equals(continentes[5])) {
            regiao = Regiao.Oceania;
        } else if (continente.equals(continentes[6])) {
            regiao = Regiao.Polar;
        }
    }

    public boolean isOnline(){
        online = PaisDAORest.isConnected();
        return online;
    }
}
