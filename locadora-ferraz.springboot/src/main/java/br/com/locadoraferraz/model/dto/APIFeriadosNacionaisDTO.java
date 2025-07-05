package br.com.locadoraferraz.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIFeriadosNacionaisDTO {
    private LocalDate data;
    private String nome;
    private String tipo;
}
