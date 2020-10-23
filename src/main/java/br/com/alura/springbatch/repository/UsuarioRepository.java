package br.com.alura.springbatch.repository;

import br.com.alura.springbatch.dto.UsuarioDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioDb, String> {
}
