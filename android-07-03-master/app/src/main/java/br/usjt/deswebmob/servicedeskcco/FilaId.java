package br.usjt.deswebmob.servicedeskcco;

/**
 * Created by arqdsis on 21/03/2018.
 */

public enum FilaId {
    DESKTOP(1000, "Desktop", "desktops"),
    TELEFONIA(1001, "Telefonia", "telefonia");

    public int numero;
    public String nome, icone;

    FilaId(int numero, String nome, String icone) {
        this.numero = numero;
        this.nome = nome;
        this.icone = icone;
    }

}
