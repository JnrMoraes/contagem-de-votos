package com.marco.provaMarco.controller;

import com.marco.provaMarco.repository.IZonaRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zona")
public class ZonaController {

    @Autowired
    private IZonaRepositoty zonaRepositoty;

    @GetMapping("/total")
    public Long getTotalVotos(){ return zonaRepositoty.count();}
}
