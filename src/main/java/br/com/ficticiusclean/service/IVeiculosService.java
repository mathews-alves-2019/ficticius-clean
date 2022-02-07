package br.com.ficticiusclean.service;

import java.util.List;

import br.com.ficticiusclean.dto.VeiculoDTO;

public interface IVeiculosService {
	VeiculoDTO save(VeiculoDTO u);
	void delete(Integer id);
	VeiculoDTO update(VeiculoDTO dto, Integer id);
	VeiculoDTO findById(Integer id);
	List<VeiculoDTO> findAll();
}
