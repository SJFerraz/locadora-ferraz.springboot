package br.com.locadoraferraz.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.locadoraferraz.annotation.JsonBRDataFormat;
import br.com.locadoraferraz.util.DateUtils;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

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
