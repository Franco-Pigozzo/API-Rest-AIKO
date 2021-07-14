package com.aiko.aiko.model;


import javax.persistence.*;


@Entity
@Table(name = "veiculos")
public class Veiculo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String name;
    private String modelo;
    private long linhaId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
        return "Veiculo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", modelo='" + modelo + '\'' +
                ", linhaid=" + linhaId +
                '}';
    }
}
