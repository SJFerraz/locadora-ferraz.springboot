package br.com.locadoraferraz.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.locadoraferraz.annotation.JsonBRDataFormat;
import br.com.locadoraferraz.model.entity.Funcionario;
import br.com.locadoraferraz.util.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
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
