package com.matheus.cards.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.cards.entities.CustomerCard;

@Repository
public interface CustomerCardRepository extends JpaRepository<CustomerCard, Long>{

	List<CustomerCard> findByCpf(String cpf);

}
