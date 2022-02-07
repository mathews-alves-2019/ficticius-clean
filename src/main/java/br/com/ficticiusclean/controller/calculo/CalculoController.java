package br.com.ficticiusclean.controller.calculo;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ficticiusclean.dto.CalculoParamsDTO;
import br.com.ficticiusclean.dto.VeiculoDTO;
import br.com.ficticiusclean.model.Response;
import br.com.ficticiusclean.service.impl.CalculoServiceImpl;
import br.com.ficticiusclean.service.impl.VeiculosServiceImpl;

@RestController
@RequestMapping(value = "/calculo")
public class CalculoController {
	
	@Autowired
	private VeiculosServiceImpl veiculosService;

	@Autowired
	private CalculoServiceImpl service;
	
	@GetMapping(path = "/gastos")
	public ResponseEntity<Response> getAll(@Valid @RequestBody CalculoParamsDTO dto){
		List<VeiculoDTO> veiculos = veiculosService.findAll();
		
		return ResponseEntity.ok(Response.builder()
				.status(HttpStatus.OK.value())
				.dateTime(LocalDateTime.now())
				.data(service.calcularCustos(veiculos, dto))
				.build());
	}
}
