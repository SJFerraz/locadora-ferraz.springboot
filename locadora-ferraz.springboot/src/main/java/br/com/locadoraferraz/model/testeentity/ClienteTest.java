package br.com.locadoraferraz.model.testeentity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteTest {
	private String nome;
    
    private String cpf;
    
    private String endereco;
}
