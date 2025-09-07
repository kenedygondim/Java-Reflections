package com.ifsp.trabalho_java_reflection.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmeDto {
        private String nome;
        private String diretor;
        private int anoLancamento;
        private String genero;
}
