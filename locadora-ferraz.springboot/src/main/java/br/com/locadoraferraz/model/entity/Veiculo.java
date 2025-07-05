package br.com.locadoraferraz.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import br.com.locadoraferraz.model.BaseEntity;
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
public class Veiculo extends BaseEntity{
    
	
	private static final long serialVersionUID = 1L;

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
