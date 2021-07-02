package com.marco.provaMarco.controller;

import com.marco.provaMarco.domain.Candidato;
import com.marco.provaMarco.repository.ISecaoRepository;
import com.marco.provaMarco.repository.IZonaRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zona")
public class ZonaController {

    @Autowired
    private IZonaRepositoty zonaRepositoty;
    @Autowired
    private ISecaoRepository secaoRepository;

    @GetMapping("/total")
    public Long getTotalVotos(){ return zonaRepositoty.count();}

    @GetMapping("/leste")
    public Integer getTotalVotosZonaLeste(){
        return QuantidadeVotosPorSecaoLest("Secao Leste 1");
    }

    private Integer QuantidadeVotosPorSecaoLest(String candidato) {

        List<Candidato> candidatosList = this.secaoRepository.findByName(candidato).getCandidatos();
        Integer candidatoVotos = candidatosList.stream()
                .map(Candidato::getQuantidadeVotos)
                .reduce(0, Integer::sum);
        return  candidatoVotos;
    }
}
