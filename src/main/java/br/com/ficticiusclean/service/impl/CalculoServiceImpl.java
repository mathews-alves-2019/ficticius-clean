package br.com.ficticiusclean.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ficticiusclean.dto.CalculoParamsDTO;
import br.com.ficticiusclean.dto.CalculoResponseDTO;
import br.com.ficticiusclean.dto.VeiculoDTO;
import br.com.ficticiusclean.service.ICalculoService;

@Service
public class CalculoServiceImpl implements ICalculoService{

	@Override
	public List<CalculoResponseDTO> calcularCustos(List<VeiculoDTO> veiculos, CalculoParamsDTO calculoParamsDto) {
		List<CalculoResponseDTO> dtoResponse = new ArrayList<>();
		for(VeiculoDTO veiculo : veiculos) {
			CalculoResponseDTO dto = this.montarCalculoResponseDTO(veiculo);
			var totalCombustivelGasto_cidade = this.calcularCombustivelGasto(calculoParamsDto.getTotalKm_cidade(), veiculo.getConsumoMedio_cidade());
			var totalCombustivelGasto_rodovia = this.calcularCombustivelGasto(calculoParamsDto.getTotalKm_rodovias(), veiculo.getConsumoMedio_rodovia());
			var totalCombustivelGasto = totalCombustivelGasto_cidade.add(totalCombustivelGasto_rodovia);
			dto.setQuantidadeCombustivelGasto(totalCombustivelGasto);
			dto.setValorTotal(totalCombustivelGasto.multiply(calculoParamsDto.getPrecoGasolina()).setScale(2, RoundingMode.HALF_UP));
			
			dtoResponse.add(dto);
		}
		dtoResponse.sort(Comparator.comparing(CalculoResponseDTO::getValorTotal));
		return dtoResponse;
	}
	
	private CalculoResponseDTO montarCalculoResponseDTO(VeiculoDTO veiculo) {
		CalculoResponseDTO dto = new CalculoResponseDTO();
		dto.setNome(veiculo.getNome());
		dto.setMarca(veiculo.getMarca());
		dto.setModelo(veiculo.getModelo());
		dto.setDataFabricacao(veiculo.getDataFabricacao());
		
		return dto;
	}
	
	private BigDecimal calcularCombustivelGasto(BigDecimal totalKm, BigDecimal consumoMedioKm) {
		return totalKm.divide(consumoMedioKm, 2, RoundingMode.HALF_UP);
	}
}
