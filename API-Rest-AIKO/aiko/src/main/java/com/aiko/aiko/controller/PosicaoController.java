package com.aiko.aiko.controller;


import com.aiko.aiko.controller.request.PosicaoRequest;
import com.aiko.aiko.model.PosicaoVeiculo;
import com.aiko.aiko.repository.PosicaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posicao")
@Slf4j

public class PosicaoController {

    private final PosicaoRepository repository;

    public PosicaoController(PosicaoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public PosicaoVeiculo criarVeiculo(@RequestBody PosicaoRequest request) {
        log.info("passou aqui" + request);
        PosicaoVeiculo posicao = new PosicaoVeiculo();
        posicao.setLongitude(posicao.getLongitude());
        posicao.setLatitude(posicao.getLatitude());
        posicao.setVeiculoid(posicao.getVeiculoid());
        PosicaoVeiculo posicaosalva = repository.save(posicao);
        return posicaosalva;


    }

    @GetMapping
    public List<PosicaoVeiculo> getposicao() {


        List<PosicaoVeiculo> posicao = repository.findAll();
        return posicao;
    }

    @GetMapping("/{id}")
    public Optional<PosicaoVeiculo> getposicaoporid(@PathVariable("id") long id) {

        Optional<PosicaoVeiculo> posicao = repository.findById(id);
        return posicao;

    }

    @PutMapping("/{id}")
    public ResponseEntity<PosicaoVeiculo> updateposicao(@PathVariable("id") long id, @RequestBody PosicaoRequest request) {
        log.info("posição: {} ", request);
        Optional<PosicaoVeiculo> posicaodata = repository.findById(id);


        if (posicaodata.isPresent()) {
            log.info("Posição: {}", posicaodata.get());
            PosicaoVeiculo posicao = posicaodata.get();
            posicao.setLatitude(request.getLongitude());
            posicao.setLatitude(request.getLatitude());
            posicao.setVeiculoid(posicao.getVeiculoid());
            PosicaoVeiculo save = repository.save(posicao);
            log.info("Posicaçãp Salva: {} ", save);

            return new ResponseEntity<>(save, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteposicao ( @PathVariable("id") long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}