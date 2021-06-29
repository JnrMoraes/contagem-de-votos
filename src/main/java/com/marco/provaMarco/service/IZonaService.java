package com.marco.provaMarco.service;

import com.marco.provaMarco.domain.Zona;

import java.util.List;

public interface IZonaService {

    Zona cadastrarZona(Zona zona);

    List<Zona> consultarZonas();
}
