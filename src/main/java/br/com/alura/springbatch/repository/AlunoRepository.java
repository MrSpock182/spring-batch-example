package br.com.alura.springbatch.repository;

import br.com.alura.springbatch.dto.AlunoDb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends CrudRepository<AlunoDb, Integer> {
}