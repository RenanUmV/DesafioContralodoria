package com.challenge.mv.controllership.model.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_MOVEMENT")
public class Movement {
	
	@Id
	@Column(name = "MOVEMENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "TYPE", nullable = false)
	@NotNull(message = "type is required")
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "BANK_ACCOUNT_ID", nullable = false)
	private BankAccount bankAccount;
	
	@Column(name = "DATE_ORDER")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate orderDate = LocalDate.now();

}
