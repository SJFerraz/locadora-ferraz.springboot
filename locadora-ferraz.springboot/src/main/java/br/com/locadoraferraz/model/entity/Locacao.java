package br.com.locadoraferraz.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.locadoraferraz.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
public class Locacao extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@NotEmpty
    private LocalDate dataInicio;
    
    private LocalDate dataFim;
    
    private String descricao;
    
    private String observacao;
    
    private BigDecimal valor;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Funcionario funcionario;
    
    @ManyToOne
    private Veiculo veiculo;
    
}
