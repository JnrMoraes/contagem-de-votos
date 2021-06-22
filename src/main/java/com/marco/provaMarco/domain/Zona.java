package com.marco.provaMarco.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany
    private List<Secao> secoes;

    @OneToMany
    private List<Urna> urnas;

    @ManyToMany(mappedBy = "zonas")
    private List<Candidato> candidatos;

}