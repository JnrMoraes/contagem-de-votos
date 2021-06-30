package com.marco.provaMarco.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voto {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private Long zona;
   private Long secao;
   private Long urna;
   private Long candidato;
   private Long votar;

   public Voto(Long zona, Long secao, Long urna, Long candidato, Long votar) {
      this.zona = zona;
      this.secao = secao;
      this.urna = urna;
      this.candidato = candidato;
      this.votar = votar;
   }
}
