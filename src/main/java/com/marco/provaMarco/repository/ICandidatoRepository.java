package com.marco.provaMarco.repository;


import com.marco.provaMarco.domain.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICandidatoRepository extends JpaRepository<Candidato, Long> {

    Candidato findByName(String name);
}
