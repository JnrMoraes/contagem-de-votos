package com.marco.provaMarco.controller;

import com.marco.provaMarco.domain.Secao;
import com.marco.provaMarco.repository.ISecaoRepository;
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
@RequestMapping("/comprador")
public class SecaoController {
    private final ISecaoRepository ISecaoRepository;
    @Autowired
    private ISecaoRepository compradorRepository;

    public SecaoController(ISecaoRepository compradorRepository) {
        this.ISecaoRepository = compradorRepository;
    }

    @GetMapping
    public List<Secao> getAll(){
        return this.compradorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Secao> getCompradorById(@PathVariable Long id){
        return this.compradorRepository.findById(id);
    }

    @PostMapping
    public Boolean cadastrarComprador(@RequestBody Secao secao){
        this.compradorRepository.save(secao);
        return Boolean.TRUE;
    }

    @PutMapping("/{id}")
    public Boolean atualizatComprador(@RequestBody Secao secao){
        Secao secaoAtualizado = this.consultar(secao.getId());

        secaoAtualizado.setNumeroSecao(secao.getNumeroSecao());

        this.compradorRepository.save(secaoAtualizado);

        return Boolean.TRUE;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteComprador(@PathVariable Long id){
        this.compradorRepository.deleteById(id);
        return Boolean.TRUE;
    }

    private Secao consultar(Long id){

        Optional<Secao> CompradorOptional = this.compradorRepository.findById(id);
        if (CompradorOptional.isPresent()){
            return CompradorOptional.get();
        }
        throw new RuntimeException("Secao não encontrado");

    }
}
