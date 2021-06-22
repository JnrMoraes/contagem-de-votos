package com.marco.provaMarco.repository;


import com.marco.provaMarco.domain.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IZonaRepositoty extends JpaRepository<Zona, Long> {
}
