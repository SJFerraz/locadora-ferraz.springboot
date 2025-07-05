package br.com.locadoraferraz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locadoraferraz.model.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
