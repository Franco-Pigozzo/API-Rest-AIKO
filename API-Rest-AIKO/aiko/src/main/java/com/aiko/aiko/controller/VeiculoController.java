package com.aiko.aiko.controller;

import com.aiko.aiko.controller.request.VeiculoRequest;
import com.aiko.aiko.model.Veiculo;
import com.aiko.aiko.repository.VeiculoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/veiculos")
@Slf4j
public class VeiculoController {

    private final VeiculoRepository repository;
    private Object ResponseEntity;


    public VeiculoController(VeiculoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Veiculo criarveiculo(@RequestBody VeiculoRequest request){

        log.info("passouaqui" + request);
        Veiculo veiculo = new Veiculo();
        veiculo.setName(request.getName());
        veiculo.setModelo(request.getModelo());
        veiculo.setLinhaId(request.getLinhaId());
        Veiculo veiculosalva = repository.save(veiculo);
        return veiculosalva;


    }
    @GetMapping
    public List<Veiculo> getveiculo (){


        List<Veiculo> veiculo = repository.findAll();
        return veiculo;
    }
    @GetMapping("/{id}")
    public Optional <Veiculo> getveiculo(@PathVariable ("id") long id){

        Optional<Veiculo> veiculo = repository.findById(id);
        return veiculo;
    }

    @PutMapping("/{id}")
    public ResponseEntity <Veiculo> updateveiculo (@PathVariable("id") long id, @RequestBody VeiculoRequest request) {
        log.info("Veiculos para alteração: {} ", request);
        Optional<Veiculo> veiculodata = repository.findById(id);


        if (veiculodata.isPresent()) {
            log.info("Veiculo encontrado: {}", veiculodata.get());
            Veiculo veiculo = veiculodata.get();
            veiculo.setName(request.getName());
            veiculo.setModelo(request.getModelo());
            veiculo.setLinhaId(request.getLinhaId());
            Veiculo save = repository.save(veiculo);
            log.info("Veiculo Salvo: {} ", save);

            return new ResponseEntity<>(save, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

            @DeleteMapping("/{id}")
            public ResponseEntity<HttpStatus> deleteveiculo (@PathVariable("id") long id){
            try {
                repository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }


            }

            }






    
    






