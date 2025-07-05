package br.com.locadoraferraz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locadoraferraz.model.entity.ModeloVeiculo;

public interface ModeloVeiculoRepository extends JpaRepository<ModeloVeiculo, Long> {

}
