package br.com.locadoraferraz.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.locadoraferraz.model.entity.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{
	
}
