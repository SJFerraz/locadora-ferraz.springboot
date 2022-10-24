package br.com.locadoraferraz.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import br.com.locadoraferraz.model.BaseEntity;
import lombok.Data;

@Entity
@Data
public class Locacao extends BaseEntity {
	
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
