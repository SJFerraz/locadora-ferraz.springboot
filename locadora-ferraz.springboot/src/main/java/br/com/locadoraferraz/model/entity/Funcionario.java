package br.com.locadoraferraz.model.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.locadoraferraz.model.Pessoa;
import lombok.Data;
import net.bytebuddy.asm.Advice.This;

@Entity
@Data
public class Funcionario extends Pessoa {
    
	@ManyToOne
	private Cargo cargo;
	
	@OneToMany
 	@JoinColumn(name = "funcionario_id")
    private Set<Locacao> locacoes;
	
}
