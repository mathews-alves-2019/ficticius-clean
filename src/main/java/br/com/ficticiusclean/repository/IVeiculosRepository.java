package br.com.ficticiusclean.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ficticiusclean.entity.Veiculo;

public interface IVeiculosRepository extends JpaRepository<Veiculo, Integer> {

}
