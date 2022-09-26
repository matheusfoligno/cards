package com.matheus.cards.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.cards.entities.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{

	List<Card> findByIncomeLessThanEqual(BigDecimal incomeBigDecimal);

}
