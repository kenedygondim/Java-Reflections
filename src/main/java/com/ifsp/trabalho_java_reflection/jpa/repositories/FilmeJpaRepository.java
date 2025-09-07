package com.ifsp.trabalho_java_reflection.jpa.repositories;

import com.ifsp.trabalho_java_reflection.models.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeJpaRepository extends JpaRepository<Filme, Long> { }
