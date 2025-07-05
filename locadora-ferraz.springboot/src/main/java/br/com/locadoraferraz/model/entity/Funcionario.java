package br.com.locadoraferraz.model.entity;

import java.util.Set;

import br.com.locadoraferraz.model.Pessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Funcionario extends Pessoa {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Cargo cargo;
	
	@OneToMany
 	@JoinColumn(name = "funcionario_id")
    private Set<Locacao> locacoes;
	
}
