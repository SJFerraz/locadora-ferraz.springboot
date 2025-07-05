package br.com.locadoraferraz.model.entity;

import java.util.Set;

import br.com.locadoraferraz.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
public class MarcaVeiculo extends BaseEntity {
  
	private static final long serialVersionUID = 1L;

	private String nome;
     
    @OneToMany
 	@JoinColumn(name = "marca_veiculo_id")
    private Set<ModeloVeiculo> modelosVeiculo;
}
