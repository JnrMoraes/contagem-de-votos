package com.marco.provaMarco.service;

import com.marco.provaMarco.domain.Candidato;

public interface IVotoService {

    Boolean votar(Candidato candidato, Long voto);
}
