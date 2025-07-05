package br.com.locadoraferraz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locadoraferraz.model.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	List<Funcionario> findByNomeIgnoreCaseContaining(String name);
}
