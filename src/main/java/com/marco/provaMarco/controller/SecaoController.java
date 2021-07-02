package com.marco.provaMarco.controller;

import com.marco.provaMarco.repository.ISecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secao")
public class SecaoController {
    @Autowired
    private ISecaoRepository secaoRepository;

    @GetMapping("/total")
    public Long getTotalVotos(){ return secaoRepository.count();}

}
