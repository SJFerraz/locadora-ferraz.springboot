package br.com.locadoraferraz.model.entity;

import java.util.Set;

import br.com.locadoraferraz.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class Cargo extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	@NotEmpty
    private String descricao;
	
	@OneToMany
 	@JoinColumn(name = "cargo_id")
    private Set<Funcionario> funcionarios;
}
