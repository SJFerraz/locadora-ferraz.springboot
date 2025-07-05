package br.com.locadoraferraz.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.locadoraferraz.model.entity.Funcionario;
import br.com.locadoraferraz.repository.FuncionarioRepository;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController extends AbstractController{
    private final FuncionarioRepository funcionarioDAO;
	
	@Autowired
	public FuncionarioController(FuncionarioRepository funcionarioDAO) {
		this.funcionarioDAO = funcionarioDAO;
	}
	
	@GetMapping
	public ResponseEntity<?> buscaTudo(Pageable pageable){
		return new ResponseEntity<>(funcionarioDAO.findAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id){
		verificaSeFuncionarioExiste(id);
		return new ResponseEntity<>(funcionarioDAO.findById(id).get(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/busca-por-nome/{name}")
    public ResponseEntity<?> buscaPorNome(@PathVariable String name){		
		return new ResponseEntity<>(funcionarioDAO.findByNomeIgnoreCaseContaining(name), HttpStatus.OK);
    }
	
	@PostMapping
	@Transactional(rollbackOn = Exception.class)
    public ResponseEntity<?> salva(@RequestBody @Valid Funcionario funcionario){
		return new ResponseEntity<>(funcionarioDAO.save(funcionario), HttpStatus.CREATED);
	}
	

	@DeleteMapping(path = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleta(@PathVariable Long id){
		verificaSeFuncionarioExiste(id);
		funcionarioDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}	

	
	@PutMapping
    public ResponseEntity<?> atualiza(@RequestBody @Valid Funcionario funcionario){
		verificaSeFuncionarioExiste(funcionario.getId());
		funcionarioDAO.save(funcionario);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void verificaSeFuncionarioExiste(Long id) {
		super.verifyIfExists(Funcionario.class,funcionarioDAO, id);
	}
}
