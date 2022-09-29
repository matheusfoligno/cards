package com.matheus.cards.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matheus.cards.dtos.request.CardRequestData;
import com.matheus.cards.entities.Card;
import com.matheus.cards.entities.CustomerCard;
import com.matheus.cards.repositories.CardRepository;
import com.matheus.cards.repositories.CustomerCardRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CardIssueSubscriber {

	private final CardRepository cardRepository;
	private final CustomerCardRepository customerCardRepository;

	@RabbitListener(queues = "${mq.queues.card-issue}")
	public void receiveIssuanceRequest(@Payload String payload) {
		try {
			var mapper = new ObjectMapper();
			CardRequestData data = mapper.readValue(payload, CardRequestData.class);
			Card card = cardRepository.findById(data.getId()).orElseThrow();

			customerCardRepository.save(
					CustomerCard.builder().card(card).cpf(data.getCpf()).cardLimit(data.getLimitReleased()).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
