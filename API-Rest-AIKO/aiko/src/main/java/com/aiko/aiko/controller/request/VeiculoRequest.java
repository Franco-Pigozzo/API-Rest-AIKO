package com.aiko.aiko.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VeiculoRequest {


    private String name;
    private String modelo;

    @JsonProperty("linha_id")
    private long linhaId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getLinhaId() {
        return linhaId;
    }

    public void setLinhaId(long linhaId) {
        this.linhaId = linhaId;
    }

    @Override
    public String toString() {
        return "VeiculoRequest{" +
                "name='" + name + '\'' +
                ", modelo='" + modelo + '\'' +
                ", linhaId=" + linhaId +
                '}';
    }
}
