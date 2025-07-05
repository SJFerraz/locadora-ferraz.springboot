package br.com.locadoraferraz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locadoraferraz.model.entity.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
