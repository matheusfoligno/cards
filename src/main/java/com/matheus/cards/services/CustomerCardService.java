package com.matheus.cards.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matheus.cards.entities.CustomerCard;
import com.matheus.cards.repositories.CustomerCardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerCardService {

	private final CustomerCardRepository customerCardRepository;

	public List<CustomerCard> listCardsByCpf(String cpf) {
		return customerCardRepository.findByCpf(cpf);
	}
}
