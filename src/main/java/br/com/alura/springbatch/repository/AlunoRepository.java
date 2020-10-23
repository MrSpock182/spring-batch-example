package br.com.alura.springbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.springbatch.dto.AlunoDb;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoDb, String> {
}