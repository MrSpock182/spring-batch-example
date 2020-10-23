package br.com.alura.springbatch.repository;

import br.com.alura.springbatch.orm.AlunoSpringBatch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<AlunoSpringBatch, Integer> {
}