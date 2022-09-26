package com.matheus.cards.resourcers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.cards.dtos.request.CardRequest;
import com.matheus.cards.dtos.response.CustomerCardResponse;
import com.matheus.cards.entities.Card;
import com.matheus.cards.entities.CustomerCard;
import com.matheus.cards.services.CardService;
import com.matheus.cards.services.CustomerCardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
public class CardResource {
	
	private final CardService cardService; 
	
	private final CustomerCardService customerCardService; 

	@PostMapping
	public ResponseEntity save(@RequestBody CardRequest request) {
		Card card = request.toEntity();
		cardService.save(card);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping(params = "income")
	public ResponseEntity<List<Card>> getCardsByIncome(@RequestParam("income") Long income) {
		List<Card> cards = cardService.getCardsByIncome(income);
		return ResponseEntity.ok(cards);
	}
	
	@GetMapping(params = "cpf")
	public ResponseEntity<List<CustomerCardResponse>> getCardsByCustomer(@RequestParam("cpf") String cpf) {
		List<CustomerCard> customerCardList = customerCardService.listCardsByCpf(cpf);
		return ResponseEntity.ok(customerCardList
				.stream()
				.map(CustomerCardResponse::fromModel)
				.collect(Collectors.toList())
		);
	}
}
