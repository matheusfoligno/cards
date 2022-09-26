package com.matheus.cards.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.matheus.cards.enums.CardFlag;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private CardFlag cardFlag;
	private BigDecimal income;
	private BigDecimal basicLimit;
	
	public Card(String name, CardFlag cardFlag, BigDecimal income, BigDecimal basicLimit) {
		this.name = name;
		this.cardFlag = cardFlag;
		this.income = income;
		this.basicLimit = basicLimit;
	}
	
	
}
