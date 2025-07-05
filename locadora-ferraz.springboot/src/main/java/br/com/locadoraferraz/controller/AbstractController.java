package br.com.locadoraferraz.controller;

import org.springframework.data.repository.CrudRepository;

import br.com.locadoraferraz.error.ResourceNotFoundException;


public class AbstractController {     
     
     protected void verifyIfExists(Class<?> className, CrudRepository<?, Long> entityDAO, Long id) {
    	 if (!entityDAO.findById(id).isPresent()) {
    		 throw new ResourceNotFoundException(className.getSimpleName()+" não pode ser encontrado pelo id: "+id);
    	 }
     }
}
