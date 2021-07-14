package com.aiko.aiko.controller;


import com.aiko.aiko.controller.request.LinhaRequest;
import com.aiko.aiko.model.Linha;
import com.aiko.aiko.model.Parada;
import com.aiko.aiko.repository.LinhaRepository;
import com.aiko.aiko.repository.ParadaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/linhas")
@Slf4j
public class LinhaController {

    private final LinhaRepository repository;
    private final ParadaRepository paradaRepository;


    @PostMapping
    public Linha criarLinha(@RequestBody LinhaRequest request) {
        log.info("passou aqui" + request);
        Linha linha = new Linha();
        linha.setName(request.getNome());

        Linha linhasalva = repository.save(linha);
        request.getParadas().forEach(paradaRequest -> {
            Parada parada = new Parada(paradaRequest.getNome(), paradaRequest.getLatitude(), paradaRequest.getLongitude(), linhasalva.getId());
            paradaRepository.save(parada);
        });
        return linhasalva;
    }

    @GetMapping
    public List<Linha> getlinhas() {


        List<Linha> linhas = repository.findAll();
        return linhas;
    }

    @GetMapping("/{id}")
    public Optional<Linha> getlinhasporid(@PathVariable("id") long id) {


        Optional<Linha> linhas = repository.findById(id);
        return linhas;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Linha> updatelinhas(@PathVariable("id") long id, @RequestBody LinhaRequest request) {
        log.info("Linhas: {} ", request);
        Optional<Linha> linhadata = repository.findById(id);

        if (linhadata.isPresent()) {
            log.info("Linha: {}", linhadata.get());
            Linha linha = linhadata.get();
            linha.setName(request.getNome());
            //linha.setParadas(request.getParadas());
            Linha save = repository.save(linha);
            log.info("Parada Salvo: {} ", save);
            return new ResponseEntity<>(save, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletelinha(@PathVariable("id") long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
