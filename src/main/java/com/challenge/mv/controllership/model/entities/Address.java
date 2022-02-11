package com.challenge.mv.controllership.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_ADDRESS")
public class Address {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "CEP")
	@NotNull(message = "O atributo CEP é obrigatório")
	private String cep;

	@Column(name = "STREET_NAME")
	@NotNull(message = "Street name is required")
	private String streetName;

	@Column(name = "NUMBER")
	@NotNull(message = "number is required")
	private int number;

	@Column(name = "COMPLEMENT")
	private String complement;

	@Column(name = "DISTRICT")
	@NotNull(message = "district is required")
	private String district;

	@Column(name = "CITY")
	@NotNull(message = "City is required")
	private String city;

	@Column(name = "STATE_NAME")
	@NotNull(message = "State is required")
	private String state;
	
	@ManyToOne
	@JoinColumn(name = "COSTUMER_ID", nullable = false)
	//@JsonIgnoreProperties("clienteEndereco")
	private Costumer costumer;



}
