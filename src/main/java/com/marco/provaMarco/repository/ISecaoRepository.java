package com.marco.provaMarco.repository;

import com.marco.provaMarco.domain.Secao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISecaoRepository extends JpaRepository<Secao, Long> {

}
