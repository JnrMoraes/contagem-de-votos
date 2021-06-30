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
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private Long quantidadeVotos = 0L;

    @OneToOne
    private Secao secao;

    @OneToOne
    private Zona zona;

    @OneToOne
    private Urna urna;

    public Candidato(String name) {
        this.name = name;
    }

    public void setQuantidadeVotos(Long quantidadeVotos) {
        this.quantidadeVotos = this.quantidadeVotos + quantidadeVotos;
    }
}