package com.marco.provaMarco.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Voto {

   private Long id;
   private Long zona;
   private Long secao;
   private Long urna;
   private Long candidato;
   private Long votar;

}
