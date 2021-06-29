package com.marco.provaMarco.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Secao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "secao")
    private List<Urna> urnas;

    @ManyToOne(fetch = FetchType.LAZY)
    private Zona zona;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "secao_has_candidato",
            joinColumns = { @JoinColumn(name = "secao_id") },
            inverseJoinColumns = { @JoinColumn(name = "candidato_id") }
    )
    private List<Candidato> candidatos;

    public Secao(String name, List<Urna> urnas) {
        this.name = name;
        this.urnas = urnas;
    }
}
