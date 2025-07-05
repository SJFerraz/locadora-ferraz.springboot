package br.com.locadoraferraz.model.entity;

import java.util.Set;

import br.com.locadoraferraz.model.Pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
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
public class Cliente extends Pessoa{
    
	private static final long serialVersionUID = 1L;

	@Column(length = 15)
	private String cnh;
	
	@Column(length = 500)
	private String endereço;
	
	@Column(length = 10)
	private String nrEndereco;
	
	@Column(length = 60)
	private String bairro;
	
	@Column(length = 8)
	private String cep;
	
	@Column(length = 12)
	private String telefone;
	
	@Email
	private String email;
	
	@OneToMany
 	@JoinColumn(name = "cliente_id")
    private Set<Locacao> locacoes;
}
