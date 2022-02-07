package br.com.ficticiusclean.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculoResponseDTO {
	
	private String nome;
	
	private String marca;
	
	private String modelo;
	
	private String dataFabricacao;
	
	private BigDecimal quantidadeCombustivelGasto;
	
	private BigDecimal valorTotal;
}
