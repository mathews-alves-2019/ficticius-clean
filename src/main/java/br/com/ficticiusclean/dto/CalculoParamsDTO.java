package br.com.ficticiusclean.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculoParamsDTO {

	@DecimalMin(value = "0.1", message = "Informe o valor da gasolina.")
	@NotNull(message = "Informe o valor da gasolina.")
	private BigDecimal precoGasolina;
	
	@DecimalMin(value = "0.1", message = "Informe quantos kilometros serão percorridos na rodovia")
	@NotNull(message = "Informe quantos kilometros serão percorridos na rodovia")
	private BigDecimal totalKm_cidade;
	
	@DecimalMin(value = "0.1", message = "Informe quantos kilometros serão percorridos na cidade")
	@NotNull(message = "Informe quantos kilometros serão percorridos na rodovia")
	private BigDecimal totalKm_rodovias;
}
