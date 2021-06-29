package com.marco.provaMarco.service.impl;

import com.marco.provaMarco.domain.Zona;
import com.marco.provaMarco.repository.IZonaRepositoty;
import com.marco.provaMarco.service.IZonaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZonaServideImpl implements IZonaService {

    private IZonaRepositoty zonaRepositoty;
    private final ModelMapper mapper;

    @Autowired
    public ZonaServideImpl(IZonaRepositoty zonaRepositoty) {
        this.zonaRepositoty = zonaRepositoty;
        this.mapper = new ModelMapper();
    }

    @Override
    public Zona cadastrarZona(Zona zona) {
        return this.zonaRepositoty.save(zona);
    }

    @Override
    public List<Zona> consultarZonas() {
        List<Zona> zonas = this.zonaRepositoty.findAll();
         zonas.forEach(zona ->
                 zonas.add(consultarZonaPeloId(zona.getId())));

        return zonas;
    }

    public Zona consultarZonaPeloId(Long id) {
        Optional<Zona> zonaOptional = this.zonaRepositoty.findById(id);
        return this.mapper.map(zonaOptional.get(), Zona.class);
    }
}
