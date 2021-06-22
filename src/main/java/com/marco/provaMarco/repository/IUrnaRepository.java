package com.marco.provaMarco.repository;

import com.marco.provaMarco.domain.Urna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUrnaRepository extends JpaRepository<Urna, Long> {
}
