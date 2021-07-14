package com.aiko.aiko.repository;

import com.aiko.aiko.model.PosicaoVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosicaoRepository extends JpaRepository <PosicaoVeiculo, Long> {
}
