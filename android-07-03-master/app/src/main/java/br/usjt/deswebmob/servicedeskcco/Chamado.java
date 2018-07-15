package br.usjt.deswebmob.servicedeskcco;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Lucas Nagaoka on 21/03/2018.
 */

public class Chamado implements Serializable {
    private int numero;
    private Date dataAbertura, dataFechamento;
    private String status, descricao;
    private Fila fila;

    public Chamado(int numero, Date dataAbertura, Date dataFechamento, String status, String descricao, Fila fila) {
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.status = status;
        this.descricao = descricao;
        this.fila = fila;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Fila getFila() {
        return this.fila;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }
}
