package br.com.locadoraferraz.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import br.com.locadoraferraz.model.Pessoa;
import lombok.Data;

@Entity
@Data
public class Cliente extends Pessoa{
    
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
