package br.com.locadoraferraz.model.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import br.com.locadoraferraz.model.BaseEntity;
import lombok.Data;

@Entity
@Data
public class ModeloVeiculo extends BaseEntity {
     
	private String descricao;
	
	@NotEmpty
	private Integer ano;
    
	@ManyToOne
	private MarcaVeiculo marca;
	
	@OneToMany
	@JoinColumn(name = "modelo_veiculo_id")
	private Set<Veiculo> veiculos;
	
}
