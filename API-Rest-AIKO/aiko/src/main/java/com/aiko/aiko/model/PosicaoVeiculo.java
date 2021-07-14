package com.aiko.aiko.model;

import javax.persistence.*;

@Entity
@Table(name = "posicao")

public class PosicaoVeiculo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private double latitude;
    private double longitude;
    private long veiculo_id;


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

    public long getVeiculoid() {
        return veiculo_id;
    }

    public void setVeiculoid(long veiculoid) {
        this.veiculo_id = veiculoid;
    }

    @Override
    public String toString() {
        return "PosicaoVeiculo{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", veiculo_id=" + veiculo_id +
                '}';
    }
}
