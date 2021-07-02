package com.marco.provaMarco.controller;

import com.marco.provaMarco.repository.ICandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    @Autowired
    private ICandidatoRepository candidatoRepository;

    @GetMapping("/total")
    public Long getTotalVotos(){ return candidatoRepository.count();}

    @GetMapping("manoel")
    public ResponseEntity<Integer> getVotosManuel(){
        Integer total =  candidatoRepository.findByName("Manoel dos Campos")
                                            .getQuantidadeVotos();
        return ResponseEntity.status(HttpStatus.OK).body(total);
    }

    @GetMapping("jose")
    public int getVotosJose(){
        return candidatoRepository.findByName("Jose das Neves").getQuantidadeVotos();
    }


}
