package com.marco.provaMarco.controller;

import com.marco.provaMarco.domain.Secao;
import com.marco.provaMarco.domain.Urna;
import com.marco.provaMarco.domain.Zona;
import com.marco.provaMarco.repository.ISecaoRepository;
import com.marco.provaMarco.repository.IUrnaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/urna")
public class UrnaController {

    private IUrnaRepository urnaRepository;
    private ISecaoRepository secaoRepository;

//    private final ModelMapper mapper;

//    @Autowired
//    public UrnaController(IUrnaRepository urnaRepository, ModelMapper mapper) {
//        this.urnaRepository = urnaRepository;
//        this.mapper = new ModelMapper();
//    }

    @PostMapping
    public ResponseEntity<Urna> cadastrarUrna(@RequestBody Urna urna) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.urnaRepository.save(urna));
    }

//    @RequestMapping(value="/{codigo}", method= RequestMethod.POST)
//    public ResponseEntity<Urna> salvarSecaoUrna(@PathVariable ("codigo") Long codigo, Secao secao){
//       Optional<Urna> urnaOptional = urnaRepository.findById(codigo);
//        Urna urna = this.mapper.map(urnaOptional.get() , Urna.class);
//
//       secao.setUrnas(converterToUrna(urna.getId()));
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(this.urnaRepository.save(urna));
//    }
//
//    @GetMapping("/{id}")
//    public Secao consultarSecaoPeloId(Long id) {
//        Optional<Secao> secaoOptional = this.secaoRepository.findById(id);
//        return this.mapper.map(secaoOptional.get(), Secao.class);
//    }
//    private List<Urna> converterToUrna(long id){
//        Optional<Urna> urnaOptional = this.urnaRepository.findById(id);
//    return this.mapper.map(urnaOptional.get(), new TypeToken<List<Urna>>() {
//    }.getType());
//    }
}
