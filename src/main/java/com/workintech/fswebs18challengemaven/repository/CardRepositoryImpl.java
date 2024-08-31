package com.workintech.fswebs18challengemaven.repository;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.util.CardValidation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository
public class CardRepositoryImpl implements CardRepository{
    private EntityManager entityManager;

    @Autowired
    public CardRepositoryImpl(EntityManager entityManager) {
        this.entityManager=entityManager;

    }

    @Transactional
    @Override
    public Card save(Card card) {
        entityManager.persist(card);
        return card;
    }

    @Override
    public List<Card> findByColor(String color) {
        TypedQuery<Card> query = entityManager.createQuery("SELECT c FROM Card c WHERE c.color= :color", Card.class);
        query.setParameter("color",color);
        List<Card> cards = query.getResultList();
        CardValidation.checkCardList(cards);
        return cards;

    }

    @Override
    public List<Card> findAll() {
    TypedQuery<Card> query = entityManager.createQuery("SELECT c FROM Card c", Card.class);
        List<Card> cards= query.getResultList();
        CardValidation.checkCardList(cards);
        return cards;

    }

    @Override
    public List<Card> findByValue(Integer value) {
        TypedQuery<Card> query = entityManager.createQuery("SELECT c FROM Card c WHERE c.value= :value", Card.class);
        query.setParameter("value",value);
        return query.getResultList();

    }

    @Override
    public List<Card> findByType(String type) {
        TypedQuery<Card> query = entityManager.createQuery("SELECT c FROM Card c WHERE c.type = :type", Card.class);
        query.setParameter("type",type);
        List<Card> cards = query.getResultList();
        CardValidation.checkCardList(cards);
        return cards;
    }

    @Transactional
    @Override
    public Card update(Card card) {
        return entityManager.merge(card);
    }

    @Transactional
    @Override
    public Card remove(long id) {
        Card card=entityManager.find(Card.class,id);
        entityManager.remove(card);
        return card;
    }
}
