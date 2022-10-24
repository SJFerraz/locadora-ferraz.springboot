package br.com.locadoraferraz.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.locadoraferraz.annotation.JsonBRDataFormat;
import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
	
	protected static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@JsonBRDataFormat
	private LocalDateTime dtCadastro;
	
	@JsonBRDataFormat
	private LocalDateTime dtUltimaAlteracao;

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	@PrePersist
	private void prePersist() {
		
		if (this.dtCadastro == null)
			this.dtCadastro = LocalDateTime.now();
		
		this.dtUltimaAlteracao = LocalDateTime.now();
	}
}
