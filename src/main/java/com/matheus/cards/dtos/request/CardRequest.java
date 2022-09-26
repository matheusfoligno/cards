package com.matheus.cards.dtos.request;

import java.math.BigDecimal;

import com.matheus.cards.entities.Card;
import com.matheus.cards.enums.CardFlag;

import lombok.Data;

@Data
public class CardRequest {

	private String name;
	private CardFlag cardFlag;
	private BigDecimal income;
	private BigDecimal basicLimit;
	
	public Card toEntity() {
		return new Card(name, cardFlag, income, basicLimit);
	}
}
