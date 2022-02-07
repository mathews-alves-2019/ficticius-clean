package br.com.ficticiusclean.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDTO {

	private Integer id;
	
	@NotEmpty(message = "Informe o nome do veículo.")
	private String nome;
	
	@NotEmpty(message = "Informe a marca do veículo.")
	private String marca;
	
	@NotEmpty(message = "Informe o modelo do veículo.")
	private String modelo;
	
	@NotEmpty(message = "Informe a data de fabricação do veículo.")
	private String dataFabricacao;
	
	@DecimalMin(value = "0.1", message = "Informe o valor do consumo médio na cidade")
	@NotNull(message = "Informe o valor do consumo médio na rodovia")
	private BigDecimal consumoMedio_cidade;
	
	@DecimalMin(value = "0.1", message = "Informe o valor do consumo médio na rodovia")
	@NotNull(message = "Informe o valor do consumo médio na rodovia")
	private BigDecimal consumoMedio_rodovia;
}
