package com.ifsp.trabalho_java_reflection.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.ifsp.trabalho_java_reflection.config.ObjectToJson;
import com.ifsp.trabalho_java_reflection.dto.FilmeDto;
import com.ifsp.trabalho_java_reflection.jpa.repositories.FilmeJpaRepository;
import com.ifsp.trabalho_java_reflection.models.Filme;
import com.ifsp.trabalho_java_reflection.config.Transformator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/filmes")
public class FilmeController {
    private final FilmeJpaRepository filmeJpaRepository;

    @Autowired
    public FilmeController(FilmeJpaRepository filmeJpaRepository) {
        this.filmeJpaRepository = filmeJpaRepository;
    }

    @GetMapping("/findAll")
    public List<JsonNode> findAll() throws Exception {
        List<Filme> filmes = filmeJpaRepository.findAll();
        List<JsonNode> filmesDto = new ArrayList<JsonNode>();

        for (Filme filme : filmes) {
            filmesDto.add(ObjectToJson.toJson(filme, FilmeDto.class));
        }

        return filmesDto;
    }

    @GetMapping("/findByName/{name}")
    public Filme findByName(@RequestParam String name) {
        return null;
    }
}
