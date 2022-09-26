package com.matheus.cards.dtos.response;

import java.math.BigDecimal;

import com.matheus.cards.entities.CustomerCard;
import com.matheus.cards.enums.CardFlag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCardResponse {

	private String name;
	private CardFlag cardFlag;
	private BigDecimal limitReleased;
	
	public static CustomerCardResponse fromModel(CustomerCard customerCard) {
		return new CustomerCardResponse(
				customerCard.getCard().getName(),
				customerCard.getCard().getCardFlag(),
				customerCard.getCardLimit()
		);
	}
}
