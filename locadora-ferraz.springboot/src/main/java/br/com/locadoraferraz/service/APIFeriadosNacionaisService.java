package br.com.locadoraferraz.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.locadoraferraz.model.dto.APIFeriadosNacionaisDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class APIFeriadosNacionaisService {
	
	public List<APIFeriadosNacionaisDTO> retornarDatas (Long ano) {
		String uri = "https://brasilapi.com.br/api/feriados/v1/"+ano;
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		return Arrays.asList(restTemplate.getForEntity(uri, APIFeriadosNacionaisDTO[].class).getBody());
	}
	
}
