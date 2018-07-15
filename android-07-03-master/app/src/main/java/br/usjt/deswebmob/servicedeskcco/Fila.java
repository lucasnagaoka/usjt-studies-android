package br.usjt.deswebmob.servicedeskcco;

import java.io.Serializable;

/**
 * Created by arqdsis on 21/03/2018.
 */

public class Fila implements Serializable {
    private int id;
    private String icone, nome;

    public Fila(int id, String icone, String nome) {
        this.id = id;
        this.icone = icone;
        this.nome = nome;
    }

    public String getIcone() {
        return this.icone;
    }
}
