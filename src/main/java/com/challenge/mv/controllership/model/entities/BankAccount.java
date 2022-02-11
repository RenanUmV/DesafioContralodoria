package com.challenge.mv.controllership.model.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("BankAccount")
@Table(name = "TB_BANK_ACCOUNT")
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BANK_ACCOUNT_ID")
	private long id;

	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Costumer costumer;
	
	@NotNull(message = "accountNumber is required")
	@Column(name = "ACCOUNT_NUMBER", nullable = false)
	private String accountNumber;

	@Column(name = "ACCOUNT_BALANCE")
	private double accountBalance;

	@CreatedDate
	@Column(name = "register_date", updatable = false)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate registerDate;

	@ManyToOne
	@JoinColumn(name = "ID_CUSTOMER_PP", nullable = false)
	private PhysicalPersonCostumer physicalPersonCostumer;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE_LP")
	private LegalPersonCostumer legalPersonCostumer;
	
	@OneToMany(mappedBy = "bankAccount")
	private Set<Movement> movements;

	
}
