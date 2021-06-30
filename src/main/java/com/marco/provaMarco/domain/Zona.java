package com.marco.provaMarco.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeZona;

    @OneToOne
    private Secao secao;

    @OneToOne
    private Urna urna;

    @OneToOne
    private Candidato candidato;

    public Zona(String nomeZona, Secao secao, Urna urna) {
        this.nomeZona = nomeZona;
        this.secao = secao;
        this.urna = urna;
    }
}