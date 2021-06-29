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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeZona;

    @OneToMany(mappedBy = "zona")
    private List<Secao> secoes;

    @ManyToMany(mappedBy = "zona")
    private List<Urna> urnas;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "zona_has_candidato",
            joinColumns = { @JoinColumn(name = "zona_id") },
            inverseJoinColumns = { @JoinColumn(name = "candidato_id") }
    )
    private List<Candidato> candidatos;

    public Zona(String nomeZona, List<Secao> secoes, List<Urna> urnas) {
        this.nomeZona = nomeZona;
        this.secoes = secoes;
        this.urnas = urnas;
    }
}