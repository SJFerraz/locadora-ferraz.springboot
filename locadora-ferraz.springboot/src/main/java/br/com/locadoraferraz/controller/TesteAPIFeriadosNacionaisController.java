package br.com.locadoraferraz.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.locadoraferraz.model.dto.APIFeriadosNacionaisDTO;
import br.com.locadoraferraz.service.APIFeriadosNacionaisService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/apiFeriadosNacionais")
public class TesteAPIFeriadosNacionaisController {
	
	@Getter
	private APIFeriadosNacionaisService service;

	@Operation(summary="VERIFICA SE HÁ [REGISTRO] CADASTRADO PARA RETORNO DE MENSAGEM DE SUCESSO OU DE ERRO.")
	@ResponseBody
	@GetMapping(path = "/{ano}")
	public ResponseEntity<List<APIFeriadosNacionaisDTO>> findAll(@PathVariable Long ano){
		return ResponseEntity.ok(this.service.retornarDatas(ano));
	}
}
