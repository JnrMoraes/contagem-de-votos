package com.marco.provaMarco.service.impl;

import com.marco.provaMarco.domain.Candidato;
import com.marco.provaMarco.repository.ICandidatoRepository;
import com.marco.provaMarco.repository.IVotoRepository;
import com.marco.provaMarco.service.IVotoService;
import com.sun.istack.NotNull;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotoServiceImpl implements IVotoService {

    @Autowired
    private IVotoRepository votoRepository;
    @Autowired
    private ICandidatoRepository candidatoRepository;

    private ModelMapper mapper;

    public VotoServiceImpl(IVotoRepository votoRepository,
                           ICandidatoRepository candidatoRepository) {
        this.votoRepository = votoRepository;
        this.candidatoRepository = candidatoRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public Boolean votar(@NotNull Candidato candidato, Long voto){
        try {
            Hibernate.initialize(candidato);

            Optional<Candidato> cand = candidatoRepository.findById(candidato.getId());
            Candidato candi = this.mapper.map(cand.get(), Candidato.class);

            candi.setQuantidadeVotos(voto);
            candidatoRepository.save(candi);

            return Boolean.TRUE;

        } catch (Exception e){
            throw new RuntimeException();
        }
    }
}























