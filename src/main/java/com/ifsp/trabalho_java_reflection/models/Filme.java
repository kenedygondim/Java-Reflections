package com.ifsp.trabalho_java_reflection.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "filmes")
@Data
public class Filme {
    public Filme(String nome, String diretor, int anoLancamento, String genero) {
        this.nome = nome;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }

    public Filme() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String diretor;
    @Column
    private int anoLancamento;
    @Column
    private String genero;
}
