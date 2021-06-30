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
public class Secao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Urna urna;

    @OneToOne
    private Zona zona;

    @OneToOne
    private Candidato candidato;

    public Secao(String name, Urna urna) {
        this.name = name;
        this.urna = urna;
    }
}
