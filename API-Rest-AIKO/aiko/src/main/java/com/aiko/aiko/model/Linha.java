package com.aiko.aiko.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="linhas")
public class Linha {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "linha_id")
    private long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parada_id", nullable = false, insertable=false, updatable=false)
    private List<Parada> paradas;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Parada> getParadas() {
        return paradas;
    }

    public void setParadas(List<Parada> paradas) {
        this.paradas = paradas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}



