package br.com.locadoraferraz.model.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import br.com.locadoraferraz.model.BaseEntity;
import lombok.Data;

@Entity
@Data
public class Cargo extends BaseEntity{
	@NotEmpty
    private String descricao;
	
	@OneToMany
 	@JoinColumn(name = "cargo_id")
    private Set<Funcionario> funcionarios;
}
