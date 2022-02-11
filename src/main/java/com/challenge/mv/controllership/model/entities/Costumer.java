package com.challenge.mv.controllership.model.entities;

import com.challenge.mv.controllership.model.audit.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "TB_COSTUMER")
@Inheritance(strategy=InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Costumer extends DateAudit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_id", nullable = false)
	private Long clientId;
	
	@NotNull(message = "phoneNumber is required")
	private String phoneNumber;
	
	@NotNull(message = "type must been chosen between legalPerson or physicalPerson")
	private String type;
	
	@NotNull
	@Email(message = "e-mail is required")
	private String email;
	
	@OneToMany(mappedBy = "costumer")
	@JsonIgnoreProperties("addresses")
	private List<Address> addresses;
	
	@OneToOne()
	@JoinColumn(name = "LP_COSTUMER_ID", referencedColumnName = "LEGAL_PERSON_COSTUMER_ID")
	private LegalPersonCostumer legalPersonCostumer;

	@OneToOne()
	@JoinColumn(name = "PP_COSTUMER_ID", referencedColumnName = "PHYSICAL_PERSON_COSTUMER_ID")
	private PhysicalPersonCostumer physicalPersonCostumer;


}
