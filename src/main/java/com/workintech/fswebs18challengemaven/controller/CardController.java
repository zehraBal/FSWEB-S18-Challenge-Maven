package com.workintech.fswebs18challengemaven.controller;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.repository.CardRepository;
import com.workintech.fswebs18challengemaven.util.CardValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/cards")
public class CardController {
    private final CardRepository cardRepository;

    @Autowired
    public CardController(CardRepository cardRepository){
        this.cardRepository=cardRepository;
    }


    @GetMapping
    public List<Card> getAllCards(){
       return cardRepository.findAll();

    }

    @GetMapping("/byColor/{color}")
    public List<Card> getCardsByColor(@PathVariable String color){
       // CardValidation.checkColor(color);
        return cardRepository.findByColor(color);


    }

    @GetMapping("/byValue/{value}")
    public List<Card> getCardsByValue(@PathVariable int value){
       return cardRepository.findByValue(value);

    }

    @GetMapping("/byType/{type}")
    public List<Card> getCardsByType(@PathVariable String type){
       // CardValidation.checkType(type);
        return cardRepository.findByType(type);

    }

    @PostMapping
    public Card saveCard(@RequestBody Card card){
        CardValidation.checkCard(card);
        return cardRepository.save(card);
    }

    @PutMapping("/")
    public Card updateCard(@RequestBody Card card){
//        CardValidation.checkCard(card);
//        CardValidation.checkId(id);
//        card.setId(id);
        return cardRepository.update(card);
    }

    @DeleteMapping("/{id}")
    public Card deleteCard(@PathVariable long id){
        CardValidation.checkId(id);
        return cardRepository.remove(id);
    }
}
