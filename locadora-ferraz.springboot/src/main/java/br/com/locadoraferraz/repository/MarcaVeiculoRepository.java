package br.com.locadoraferraz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.locadoraferraz.model.entity.MarcaVeiculo;

public interface MarcaVeiculoRepository extends JpaRepository<MarcaVeiculo, Long> {

}
