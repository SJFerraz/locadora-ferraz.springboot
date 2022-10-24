package br.com.locadoraferraz.model.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.com.locadoraferraz.model.BaseEntity;
import lombok.Data;

@Entity
@Data
public class MarcaVeiculo extends BaseEntity {
     private String nome;
     
    @OneToMany
 	@JoinColumn(name = "marca_veiculo_id")
    private Set<ModeloVeiculo> modelosVeiculo;
}
