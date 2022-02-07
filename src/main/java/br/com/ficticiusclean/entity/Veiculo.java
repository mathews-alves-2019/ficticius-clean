package br.com.ficticiusclean.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "veiculos")
public class Veiculo {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "dataFabricacao")
	private String dataFabricacao;
	
	@Column(name = "consumoMedio_cidade")
	@Digits(integer = 5,fraction = 3)
	private BigDecimal consumoMedio_cidade;
	
	@Column(name = "consumoMedio_rodovia")
	@Digits(integer = 5,fraction = 3)
	private BigDecimal consumoMedio_rodovia;
}
