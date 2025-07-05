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

import br.com.locadoraferraz.model.entity.Cliente;
import br.com.locadoraferraz.repository.ClienteRepository;

@RestController
@RequestMapping("clientes")
public class ClienteController extends AbstractController{
    private final ClienteRepository clienteDAO;
	
	@Autowired
	public ClienteController(ClienteRepository clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	@GetMapping
	public ResponseEntity<?> buscaTudo(Pageable pageable){
		return new ResponseEntity<>(clienteDAO.findAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id){
		verificaSeClienteExiste(id);
		return new ResponseEntity<>(clienteDAO.findById(id).get(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/busca-por-nome/{name}")
    public ResponseEntity<?> buscaPorNome(@PathVariable String name){		
		return new ResponseEntity<>(clienteDAO.findByNomeIgnoreCaseContaining(name), HttpStatus.OK);
    }
	
	@PostMapping
	@Transactional(rollbackOn = Exception.class)
    public ResponseEntity<?> salva(@RequestBody @Valid Cliente cliente){
		return new ResponseEntity<>(clienteDAO.save(cliente), HttpStatus.CREATED);
	}
	

	@DeleteMapping(path = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleta(@PathVariable Long id){
		verificaSeClienteExiste(id);
		clienteDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}	

	
	@PutMapping
    public ResponseEntity<?> atualiza(@RequestBody @Valid Cliente cliente){
		verificaSeClienteExiste(cliente.getId());
		clienteDAO.save(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void verificaSeClienteExiste(Long id) {
		super.verifyIfExists(Cliente.class,clienteDAO, id);
	}
}
