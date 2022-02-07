package br.com.ficticiusclean.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.ficticiusclean.dto.VeiculoDTO;
import br.com.ficticiusclean.entity.Veiculo;

public class VeiculosConverter {

	public static Veiculo dtoToEntityMap(VeiculoDTO dto) {

		Veiculo model = new Veiculo();

		BeanUtils.copyProperties(dto, model);
		return model;
	}

	public static VeiculoDTO entityToDtoMap(Veiculo model) {
		VeiculoDTO dto = new VeiculoDTO();

		BeanUtils.copyProperties(model, dto);
		return dto;
	}

	public static List<VeiculoDTO> entityListToDtoList(List<Veiculo> modelList) {
		List<VeiculoDTO> dtoList = new ArrayList<>();

		for (Veiculo model : modelList) {
			dtoList.add(entityToDtoMap(model));
		}
		return dtoList;
	}
}
