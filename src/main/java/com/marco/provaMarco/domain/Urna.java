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
public class Urna {

//    private static final long serialVersionUID = 159382329774038265L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeUrna;

    @OneToOne
    private Secao secao;

    @OneToOne
    private Zona zona;

    @OneToOne
    private Candidato candidato;

    public Urna(String nomeUrna) {
        this.nomeUrna = nomeUrna;
    }
}
