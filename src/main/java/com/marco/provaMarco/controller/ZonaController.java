package com.marco.provaMarco.controller;

import com.marco.provaMarco.domain.Zona;
import com.marco.provaMarco.repository.IZonaRepositoty;
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
@RequestMapping("/vendedor")
public class ZonaController {

    @Autowired
    private IZonaRepositoty vendedorRepositoty;

    @GetMapping
    public List<Zona> getAll(){
        return this.vendedorRepositoty.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Zona> getVendedorById(@PathVariable Long id){
        return this.vendedorRepositoty.findById(id);
    }

    @PostMapping
    public ResponseEntity<Zona> cadastrarVendedor(@RequestBody Zona zona){
        return ResponseEntity.status(HttpStatus.OK).body(this.vendedorRepositoty.save(zona));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Zona> atualizatVendedor(@RequestBody Zona zona){
        Zona zonaAtualizado = this.consultar(zona.getId());

        zonaAtualizado.setNomeZona(zona.getNomeZona());

        return ResponseEntity.status(HttpStatus.OK).body(this.vendedorRepositoty.save(zonaAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteVendedor(@PathVariable Long id){
        this.vendedorRepositoty.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE);
    }

    private Zona consultar(Long id){

        Optional<Zona> vendedorOptional = this.vendedorRepositoty.findById(id);
        if (vendedorOptional.isPresent()){
            return vendedorOptional.get();
        }
        throw new RuntimeException("Zona não encontrado");

    }

}
