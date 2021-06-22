package com.marco.provaMarco.controller;

import com.marco.provaMarco.repository.IUrnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carro")
public class UrnaController {

    @Autowired
    private final IUrnaRepository carroRepository;

    public UrnaController(IUrnaRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @GetMapping
    public List<com.marco.provaMarco.domain.Urna> getAll(){
        return this.carroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<com.marco.provaMarco.domain.Urna> getCarroById(@PathVariable Long id){
        return this.carroRepository.findById(id);
    }

    @PostMapping
    public Boolean cadastrarCarro(@RequestBody com.marco.provaMarco.domain.Urna urna){
        this.carroRepository.save(urna);
        return Boolean.TRUE;
    }

    @PutMapping("/{id}")
    public Boolean atualizatCarro(@RequestBody com.marco.provaMarco.domain.Urna urna){
        com.marco.provaMarco.domain.Urna urnaAtualizado = this.consultar(urna.getId());

        urnaAtualizado.setName(urna.getName());

        this.carroRepository.save(urnaAtualizado);

        return Boolean.TRUE;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCarro(@PathVariable Long id){
        this.carroRepository.deleteById(id);
        return Boolean.TRUE;
    }

    private com.marco.provaMarco.domain.Urna consultar(Long id) {

        Optional<com.marco.provaMarco.domain.Urna> CarroOptional = this.carroRepository.findById(id);
        if (CarroOptional.isPresent()) {
            return CarroOptional.get();
        }
        throw new RuntimeException("UrnaController não encontrado");

    }
}
