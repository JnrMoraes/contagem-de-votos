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
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Urna {

//    private static final long serialVersionUID = 159382329774038265L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeUrna;

    @OneToOne
    private Secao secao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Zona zona;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "urna_has_candidato",
            joinColumns = { @JoinColumn(name = "urna_id") },
            inverseJoinColumns = { @JoinColumn(name = "candidato_id") }
    )
    private List<Candidato> candidatos;

    public Urna(String nomeUrna) {
        this.nomeUrna = nomeUrna;
    }
}
