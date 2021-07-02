package com.marco.provaMarco.controller;

import com.marco.provaMarco.repository.IUrnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urna")
public class UrnaController {

    @Autowired
    private IUrnaRepository urnaRepository;

    @GetMapping("/total")
    public Long getTotalVotos(){ return urnaRepository.count();}
}
