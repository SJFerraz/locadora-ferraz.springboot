package br.com.locadoraferraz.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.locadoraferraz.annotation.JsonBRDataFormat;
import br.com.locadoraferraz.util.DateUtils;
import lombok.Data;

@MappedSuperclass
@Data
public class Pessoa extends BaseEntity {
    
	@Column(length = 200)
	@NotEmpty
	private String nome;
	
	@JsonBRDataFormat
	private LocalDate dataNascimento;
	
	@CPF
	private String cpf;
	
	@CNPJ
	private String cnpj;
	
	
	public Integer getIdade() {
		return this.dataNascimento != null ? DateUtils.calculaIdade(this.dataNascimento) : null;
	}
}
