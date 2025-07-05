package br.com.locadoraferraz.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

import br.com.locadoraferraz.model.BaseEntity;
import br.com.locadoraferraz.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
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
