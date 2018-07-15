package com.example.arqdsis.baixarimagemcomthreads;

/**
 * Created by Lucas Nagaoka on 04/04/2018.
 */

public class Previsao {
    private String descricao;
    private String nomeCidade;
    private String diaDaSemana;
    private String icone;
    private double min, max;
    private int humidade;

    public Previsao() {
    }

    public Previsao(String descricao, String diaDaSemana, double min, double max, int humidade, String nomeCidade, String icone) {
        this.descricao = descricao;
        this.diaDaSemana = diaDaSemana;
        this.min = min;
        this.max = max;
        this.humidade = humidade;
        this.nomeCidade = nomeCidade;
        this.icone = icone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public int getHumidade() {
        return humidade;
    }

    public void setHumidade(int humidade) {
        this.humidade = humidade;
    }

    public String getDiaDaSemana() { return diaDaSemana; }

    public void setDiaDaSemana(String diaDaSemana) { this.diaDaSemana = diaDaSemana; }

    public String getNomeCidade() { return nomeCidade; }

    public void setNomeCidade(String nomeCidade) { this.nomeCidade = nomeCidade; }

    public String getIcone() { return icone; }

    public void setIcone(String icone) { this.icone = icone; }
}
