package com.challenge.mv.controllership.model.entities;

import com.challenge.mv.controllership.model.entities.Costumer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_PHYSICAL_PERSON_COSTUMER")
public class PhysicalPersonCostumer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PHYSICAL_PERSON_COSTUMER_ID")
	private Long id;

	@NotNull(message = "name is required")
	private String nome;
	
	@NotNull(message = "cpf is required")
	@Size(min = 11, max = 11, message = "O atributo cpf deve ter 11 caracteres")
	private String cpf;

	@OneToOne(mappedBy = "physicalPersonCostumer")
	private Costumer costumer;
	
}
