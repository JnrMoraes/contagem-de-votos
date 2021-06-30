package com.marco.provaMarco.repository;

import com.marco.provaMarco.domain.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVotoRepository extends JpaRepository<Voto, Long> {
}
