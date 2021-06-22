package com.marco.provaMarco.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Data
public class Urna {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numeroUrna;

    @ManyToOne
    private Secao secao;

    @ManyToOne
    private Zona zona;

    @ManyToOne
    private Secao secoes;

    @ManyToMany(mappedBy = "urnas")
    private List<Candidato> candidatos;
}
