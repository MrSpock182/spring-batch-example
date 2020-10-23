package br.com.alura.springbatch.repository;

import br.com.alura.springbatch.dto.UsuarioDb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioDb, Integer> {
}
