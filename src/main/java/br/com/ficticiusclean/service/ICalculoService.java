package br.com.ficticiusclean.service;

import java.util.List;

import br.com.ficticiusclean.dto.CalculoParamsDTO;
import br.com.ficticiusclean.dto.CalculoResponseDTO;
import br.com.ficticiusclean.dto.VeiculoDTO;

public interface ICalculoService {
	List<CalculoResponseDTO> calcularCustos(List<VeiculoDTO> veiculo, CalculoParamsDTO calculoParamsDto);
}
