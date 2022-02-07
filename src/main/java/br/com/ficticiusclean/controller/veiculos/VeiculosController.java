package br.com.ficticiusclean.controller.veiculos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ficticiusclean.dto.VeiculoDTO;
import br.com.ficticiusclean.model.Response;
import br.com.ficticiusclean.service.impl.VeiculosServiceImpl;


@RestController
@RequestMapping(value = "/veiculos")
public class VeiculosController {
	
	@Autowired
	private VeiculosServiceImpl service;

	@PostMapping
	public ResponseEntity<Response> create(@Valid @RequestBody VeiculoDTO dto, BindingResult result){
		if (result.hasErrors())	{
			List<String> errors = new ArrayList<>();
			result.getAllErrors().forEach(e -> errors.add(e.getDefaultMessage()));
			return ResponseEntity.ok(Response.builder()
									.status(HttpStatus.BAD_REQUEST.value())
									.dateTime(LocalDateTime.now())
									.errors(errors)
									.build());
		}
		return ResponseEntity.ok(Response.builder()
				.status(HttpStatus.OK.value())
				.dateTime(LocalDateTime.now())
				.data(service.save(dto))
				.build());
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<Response> getAll(){
		return ResponseEntity.ok(Response.builder()
				.status(HttpStatus.OK.value())
				.dateTime(LocalDateTime.now())
				.data(service.findAll())
				.build());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response> getById(@PathVariable Integer id){
		return ResponseEntity.ok(Response.builder()
				.status(HttpStatus.OK.value())
				.dateTime(LocalDateTime.now())
				.data(service.findById(id))
				.build());
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response> deleteById(@PathVariable Integer id){
		service.delete(id);

		var response = Response.builder()
				.status(HttpStatus.OK.value())
				.dateTime(LocalDateTime.now())
				.build();
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response> update(@PathVariable("id") Integer id, @Valid @RequestBody VeiculoDTO dto, BindingResult result){
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<>();
			result.getAllErrors().forEach(e -> errors.add(e.getDefaultMessage()));
			return ResponseEntity.ok(Response.builder()
									.status(HttpStatus.BAD_REQUEST.value())
									.dateTime(LocalDateTime.now())
									.errors(errors)
									.build());
		}

		var response = Response.builder()
				.status(HttpStatus.OK.value())
				.dateTime(LocalDateTime.now())
				.data(service.update(dto, id))
				.build();
		
		return ResponseEntity.ok(response);
	}
	
}
