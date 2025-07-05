package br.com.locadoraferraz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.locadoraferraz.util.JXLSCustom;

@RestController
@RequestMapping("teste")
public class TesterController {
	
	@Autowired
	public JXLSCustom jxls;

	
	@GetMapping("/1")	
	public ResponseEntity<?> testeJXLS(){
		return new ResponseEntity<>(jxls.testeDocExcel()?"Teste Feito com sucesso.":"Teste deu ruim.", HttpStatus.OK);
	}
	
	@GetMapping("/2")	
	public String testePropperties(){
		return "-";//+jxls.appName;
	}
}
