package com.marco.provaMarco.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private int quantidadeVotos;

    @OneToMany(mappedBy = "candidatos")
    private List<Secao> secoes;

    @ManyToMany(mappedBy = "candidatos")
    private List<Zona> zonas;

    @ManyToMany(mappedBy = "candidatos")
    private List<Urna> urnas;

    public Candidato(String name, List<Secao> secoes, List<Zona> zonas, List<Urna> urnas) {
        this.name = name;
        this.secoes = secoes;
        this.zonas = zonas;
        this.urnas = urnas;
    }
}