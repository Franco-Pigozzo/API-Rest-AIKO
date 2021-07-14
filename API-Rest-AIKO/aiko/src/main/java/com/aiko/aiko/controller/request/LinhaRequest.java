package com.aiko.aiko.controller.request;

import java.util.List;

public class LinhaRequest {

    private String nome;
    private List<ParadaRequest> paradas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ParadaRequest> getParadas() {
        return paradas;
    }

    public void setParadas(List<ParadaRequest> paradas) {
        this.paradas = paradas;
    }

    @Override
    public String toString() {
        return "LinhaRequest{" +
                "name='" + nome + '\'' +
                ", paradas=" + paradas +
                '}';
    }
}
