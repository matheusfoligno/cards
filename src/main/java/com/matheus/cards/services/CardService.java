package com.matheus.cards.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.cards.entities.Card;
import com.matheus.cards.repositories.CardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardService {

	private final CardRepository cardRepository;

	@Transactional
	public Card save(Card card) {
		return cardRepository.save(card);
	}
	
	public List<Card> getCardsByIncome(Long income) {
		var incomeBigDecimal = BigDecimal.valueOf(income);
		
		return cardRepository.findByIncomeLessThanEqual(incomeBigDecimal);
	}
}
