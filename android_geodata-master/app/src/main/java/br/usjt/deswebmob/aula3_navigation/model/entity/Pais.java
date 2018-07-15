package br.usjt.deswebmob.aula3_navigation.model.entity;

import android.provider.BaseColumns;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;

/**
 * @author Lucas Nagaoka | RA: 81513916
 * CCP3AN-MCA
 */

public class Pais implements Serializable, Comparable {
    @SerializedName("name")
    private String nome;
    @SerializedName("alpha3Code")
    private String codigo3;
    @SerializedName("capital")
    private String capital;
    @SerializedName("region")
    private String regiao;
    @SerializedName("subregion")
    private String subRegiao;
    @SerializedName("demonym")
    private String demonimo;
    @SerializedName("population")
    private int populacao;
    @SerializedName("area")
    private int area;
    @SerializedName("flag")
    private String bandeira;
    @SerializedName("gini")
    private double gini;
    @SerializedName("languages")
    private ArrayList<String> idiomas;
    @SerializedName("currencies")
    private ArrayList<String> moedas;
    @SerializedName("topLevelDomain")
    private ArrayList<String> dominios;
    @SerializedName("timezones")
    private ArrayList<String> fusos;
    @SerializedName("borders")
    private ArrayList<String> fronteiras;
    private double latitude;
    private double longitude;
//    @SerializedName("latlng")
//    private ArrayList<Double> latLng;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo3() {
        return codigo3;
    }

    public void setCodigo3(String codigo3) {
        this.codigo3 = codigo3;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getSubRegiao() {
        return subRegiao;
    }

    public void setSubRegiao(String subRegiao) {
        this.subRegiao = subRegiao;
    }

    public String getDemonimo() {
        return demonimo;
    }

    public void setDemonimo(String demonimo) {
        this.demonimo = demonimo;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public double getGini() {
        return gini;
    }

    public void setGini(double gini) {
        this.gini = gini;
    }

    public ArrayList<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(ArrayList<String> idiomas) { this.idiomas = idiomas; }

    public ArrayList<String> getMoedas() {
        return moedas;
    }

    public void setMoedas(ArrayList<String> moedas) {
        this.moedas = moedas;
    }

    public ArrayList<String> getDominios() {
        return dominios;
    }

    public void setDominios(ArrayList<String> dominios) {
        this.dominios = dominios;
    }

    public ArrayList<String> getFusos() {
        return fusos;
    }

    public void setFusos(ArrayList<String> fusos) {
        this.fusos = fusos;
    }

    public ArrayList<String> getFronteiras() {
        return fronteiras;
    }

    public void setFronteiras(ArrayList<String> fronteiras) {
        this.fronteiras = fronteiras;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

//    public ArrayList<Double> getLatLng() { return latLng; }
//
//    public void setLatLng(ArrayList<Double> latLng) { this.latLng = latLng; }

    @Override
    public String toString() {
        return "País{" +
                "\nNome = '" + nome + '\'' +
                "\nCódigo 3 = '" + codigo3 + '\'' +
                "\nCapital = '" + capital + '\'' +
                "\nRegião = '" + regiao + '\'' +
                "\nSub-região = '" + subRegiao + '\'' +
                "\nDemonimo = '" + demonimo + '\'' +
                "\nPopulação = " + populacao +
                "\nÁrea = " + area +
                "\nBandeira = '" + bandeira + '\'' +
                "\nGini = " + gini +
                "\nIdiomas = " + idiomas +
                "\nMoedas = " + moedas +
                "\nDomínios = " + dominios +
                "\nFusos = " + fusos +
                "\nFronteiras = " + fronteiras +
                "\nLatitude = " + latitude +
                "\nLongitude = " + longitude +
                "\n}";
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return 0;
        } else {
            /* java.text.Collator API 1.5
             * A classe Collator executa comparacao de sequencia de caracteres sensivel a localidade.
             * Você usa essa classe para criar rotinas de busca e classificação de texto em linguagem
             * natural.
             * Referências:
             * https://docs.oracle.com/javase/7/docs/api/java/text/Collator.html
             * http://stackoverflow.com/questions/12889760/sort-list-of-strings-with-localization
             * */
            Pais pais = (Pais) o;
            // Collator e uma classe abstrata. Utilize o seu factory para instanciar.
            Collator c = Collator.getInstance();
            // A atribuicao de pontos fortes aos recursos de linguagem depende da regiao.
            c.setStrength(Collator.PRIMARY);
            return c.compare(this.nome, pais.getNome());
            //usar o compareTo nao ordena corretamente caracteres acentuados
            //return getNome().compareTo(pais.getNome());
        }
    }

    public static abstract class PaisEntry implements BaseColumns {
        public static final String TABLE_NAME = "pais";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_REGIAO = "regiao";
        public static final String COLUMN_NAME_SUBREGIAO = "subregiao";
        public static final String COLUMN_NAME_CAPITAL = "capital";
        public static final String COLUMN_NAME_BANDEIRA = "bandeira";
        public static final String COLUMN_NAME_CODIGO3 = "codigo3";
        public static final String COLUMN_NAME_AREA = "area";
        public static final String COLUMN_NAME_DEMONIMO = "demonimo";
    }
}
