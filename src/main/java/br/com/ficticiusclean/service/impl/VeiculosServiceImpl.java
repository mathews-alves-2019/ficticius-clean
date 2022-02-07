package br.com.ficticiusclean.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.ficticiusclean.dto.VeiculoDTO;
import br.com.ficticiusclean.entity.Veiculo;
import br.com.ficticiusclean.exception.BusinessException;
import br.com.ficticiusclean.repository.IVeiculosRepository;
import br.com.ficticiusclean.service.IVeiculosService;
import br.com.ficticiusclean.util.MessageEnum;
import br.com.ficticiusclean.util.VeiculosConverter;

@Service
public class VeiculosServiceImpl implements IVeiculosService {
	
	@Autowired
	private IVeiculosRepository repository;

	@Override
	public VeiculoDTO save(VeiculoDTO veiculoDTO) {
		return VeiculosConverter.entityToDtoMap(repository.save(VeiculosConverter.dtoToEntityMap(veiculoDTO)));
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public VeiculoDTO update(VeiculoDTO dto, Integer id) {
		Optional<Veiculo> data = repository.findById(id);
		
		if (data.isEmpty()) {
			throw new BusinessException(MessageEnum.ENTITY_NOT_FOUND.getValue(), HttpStatus.NOT_FOUND.value());
		}

		dto.setId(data.get().getId());

		return VeiculosConverter.entityToDtoMap(repository.save(VeiculosConverter.dtoToEntityMap(dto)));
	}

	@Override
	public VeiculoDTO findById(Integer id) {
		Optional<Veiculo> veiculo = repository.findById(id);
		
		if(veiculo.isEmpty()) {
			throw new BusinessException(MessageEnum.ENTITY_NOT_FOUND.getValue(), HttpStatus.NOT_FOUND.value());
		}
		
		return VeiculosConverter.entityToDtoMap(veiculo.get());
	}

	@Override
	public List<VeiculoDTO> findAll() {
		return VeiculosConverter.entityListToDtoList(repository.findAll());
	}

}
