package com.marco.provaMarco.controller;

import com.marco.provaMarco.domain.Secao;
import com.marco.provaMarco.repository.ISecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/secao")
public class SecaoController {
    @Autowired
    private ISecaoRepository secaoRepository;

    @PostMapping
    public ResponseEntity<Secao> cadastrarsecao(@RequestBody Secao secao){
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.secaoRepository.save(secao));
    }

//    private Secao consultar(Long id){
//
//        Optional<Secao> CompradorOptional = this.compradorRepository.findById(id);
//        if (CompradorOptional.isPresent()){
//            return CompradorOptional.get();
//        }
//        throw new RuntimeException("Secao não encontrado");
//
//    }
}
