package com.marco.provaMarco.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Secao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeSecao;

    @OneToMany(mappedBy = "secao")
    private List<Urna> urnas;

    @ManyToOne(fetch = FetchType.LAZY)
    private Zona zona;

    @ManyToMany
    @JoinTable(
            name = "secao_has_candidato",
            joinColumns = { @JoinColumn(name = "secao_id") },
            inverseJoinColumns = { @JoinColumn(name = "candidato_id") }
    )
    private List<Candidato> candidatos;

    public Secao(String nomeSecao, List<Urna> urnas) {
        this.nomeSecao = nomeSecao;
        this.urnas = urnas;
    }
}
