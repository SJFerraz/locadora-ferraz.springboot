package br.com.locadoraferraz.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import br.com.locadoraferraz.model.BaseEntity;
import lombok.Data;

@Entity
@Data
public class Veiculo extends BaseEntity{
    
	private String placa;
	
    private String chassi;
    
    private BigDecimal valor;
    
    private LocalDateTime dtEntrada;
    
    @ManyToOne
    private ModeloVeiculo modelo;
    
    @OneToMany
 	@JoinColumn(name = "veiculo_id")
    private Set<Locacao> locacoes;
     
}
