package com.aiko.aiko.model;


import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@Entity
@Table(name = "paradas")
public class Parada {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "parada_id")
    private long paradaId;

    private String name;

    private double latitude;

    private double longitude;

    @ManyToOne
    @JoinColumn(name = "linha_id")
    private Linha linha;

    public Parada(String name, double latitude, double longitude, long linhaId) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.linha = Linha.builder().id(linhaId).build();
    }

    public long getParadaId() {
        return paradaId;
    }

    public void setParadaId(long paradaId) {
        this.paradaId = paradaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }
}
