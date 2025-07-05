package br.com.locadoraferraz.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import br.com.locadoraferraz.annotation.JsonBRDataTimeFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {
	
	protected static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@JsonBRDataTimeFormat
	private LocalDateTime dtCadastro;
	
	@JsonBRDataTimeFormat
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
	
	@PreUpdate
	private void preUpdate() {
		this.dtUltimaAlteracao = LocalDateTime.now();
	}
	
	@PrePersist
	private void prePersist() {
		LocalDateTime dataAtual = LocalDateTime.now();
		this.dtCadastro = dataAtual;		
		this.dtUltimaAlteracao = dataAtual;
	}
}
