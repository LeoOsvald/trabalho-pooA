package br.edu.atitus.pooavancado.TrabalhoFinal.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.TrabalhoFinal.Entidades.GenericEntity;
import br.edu.atitus.pooavancado.TrabalhoFinal.Service.IGenericService;

@RestController
public abstract class GenericController<TEntidade extends GenericEntity> {
	
	abstract IGenericService<TEntidade> getService();
	
	@PostMapping
	public ResponseEntity<Object> postRegistro(@RequestBody TEntidade objeto){
		try {
			getService().save(objeto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(objeto);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getRegistroById(@PathVariable long id){
		TEntidade objeto;
		try {
			objeto = this.getService().findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(objeto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> putRegistro(@PathVariable long id, @RequestBody TEntidade objeto){
		objeto.setId(id);
		try {
			getService().save(objeto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(objeto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteRegistro(@PathVariable long id) {
		try {
			getService().deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
	}

}
