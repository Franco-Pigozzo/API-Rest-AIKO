package com.aiko.aiko.controller;

import com.aiko.aiko.controller.request.ParadaRequest;
import com.aiko.aiko.model.Parada;
import com.aiko.aiko.repository.ParadaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paradas")
@Slf4j
public class ParadaController {


    private final ParadaRepository repository;

    public ParadaController(ParadaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Parada criarParadas(@RequestBody ParadaRequest request) {
        log.info("passouaqui" + request);
        Parada parada = new Parada();
        parada.setName(request.getNome());
        parada.setLatitude(request.getLatitude());
        parada.setLongitude(request.getLongitude());
        Parada paradasalva = repository.save(parada);
        return paradasalva;


    }

    @GetMapping
    public List<Parada> getparadas() {


        List<Parada> parada = repository.findAll();
        return parada;
    }

    @GetMapping("/{id}")
    public Optional<Parada> getparadasporid(@PathVariable("id") long id) {


        Optional<Parada> parada = repository.findById(id);
        return parada;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parada> updateparadas(@PathVariable("id") long id, @RequestBody ParadaRequest request) {
        log.info("Parada: {} ", request);
        Optional<Parada> paradadata = repository.findById(id);

        if (paradadata.isPresent()) {
            log.info("Parada: {}", paradadata.get());
            Parada parada = paradadata.get();
            parada.setName(request.getNome());
            parada.setLatitude(request.getLatitude());
            parada.setLongitude(request.getLongitude());
            Parada save = repository.save(parada);
            log.info("Parada Salvo: {} ", save);

            return new ResponseEntity<>(save, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteparada(@PathVariable("id") long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
