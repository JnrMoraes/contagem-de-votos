package com.marco.provaMarco.controller;

import com.marco.provaMarco.domain.Zona;
import com.marco.provaMarco.repository.ISecaoRepository;
import com.marco.provaMarco.repository.IZonaRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zona")
public class ZonaController {

    @Autowired
    private IZonaRepositoty zonaRepositoty;

    private ISecaoRepository secaoRepository;


    @PostMapping
    public ResponseEntity<Zona> cadastrarZona(@RequestBody Zona zona) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.zonaRepositoty.save(zona));
    }

//    @RequestMapping(value="/{nomeZona}/{nomeSecao}", method= RequestMethod.GET)
//    public ResponseEntity<Secao> salvarSecaoUrna(@PathVariable ("nomeZona") String nomeZona,@PathVariable String nomeSecao){
//       Zona zona = zonaRepositoty.findByNomeZona(nomeZona);
////       Secao secao = secaoRepository.findByNomeSecao(nomeSecao);
//
////        secao.setZona(zona);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(secao);
//    }

//    @GetMapping
    public ResponseEntity<List<Zona>> listarZonas(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(zonaRepositoty.findAll());
    }
}
