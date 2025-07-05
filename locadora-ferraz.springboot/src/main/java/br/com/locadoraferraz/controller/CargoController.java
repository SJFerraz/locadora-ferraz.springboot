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

import br.com.locadoraferraz.model.entity.Cargo;
import br.com.locadoraferraz.repository.CargoRepository;

@RestController
@RequestMapping("cargos")
public class CargoController extends AbstractController{
    private final CargoRepository cargoDAO;
	
	@Autowired
	public CargoController(CargoRepository cargoDAO) {
		this.cargoDAO = cargoDAO;
	}
	
	@GetMapping
	public ResponseEntity<?> buscaTudo(Pageable pageable){
		return new ResponseEntity<>(cargoDAO.findAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id){
		verificaSeCargoExiste(id);
		return new ResponseEntity<>(cargoDAO.findById(id).get(), HttpStatus.OK);
	}
	
	
	@PostMapping
	@Transactional(rollbackOn = Exception.class)
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> salva(@RequestBody @Valid Cargo cargo){
		return new ResponseEntity<>(cargoDAO.save(cargo), HttpStatus.CREATED);
	}
	

	@DeleteMapping(path = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleta(@PathVariable Long id){
		verificaSeCargoExiste(id);
		cargoDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}	

	
	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> atualiza(@RequestBody @Valid Cargo cargo){
		verificaSeCargoExiste(cargo.getId());
		cargoDAO.save(cargo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void verificaSeCargoExiste(Long id) {
		super.verifyIfExists(Cargo.class,cargoDAO, id);
	}
}
