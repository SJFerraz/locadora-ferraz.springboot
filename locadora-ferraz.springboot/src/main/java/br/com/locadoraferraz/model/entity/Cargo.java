package br.com.locadoraferraz.model.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

import br.com.locadoraferraz.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Cargo extends BaseEntity{
	@NotEmpty
    private String descricao;
	
	@OneToMany
 	@JoinColumn(name = "cargo_id")
    private Set<Funcionario> funcionarios;
}
