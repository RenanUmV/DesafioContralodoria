package com.challenge.mv.controllership.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_LEGAL_PERSON_COSTUMER")
public class LegalPersonCostumer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LEGAL_PERSON_COSTUMER_ID")
	private Long id;

	@NotNull(message = "O atributo cnpj é obrigatório")
	@Column(name = "CNPJ")
	@Size(min = 14, max = 14, message = "O atributo cnpj deve conter 14 caracteres")
	private String cnpj;

	@Column(name = "SOCIAL_REASON")
	@NotNull(message = "O atributo razaoSocial é obrigatório")
	private String socialReason;

	@Column(name = "FANTASY_NAME")
	@NotNull(message = "O atributo nomeFantasia é obrigatório")
	private String fantasyName;

	@OneToOne(mappedBy = "legalPersonCostumer")
	private Costumer costumer;

}
