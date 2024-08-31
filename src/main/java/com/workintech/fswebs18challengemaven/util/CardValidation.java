package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Color;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import com.workintech.fswebs18challengemaven.repository.CardRepositoryImpl;
import org.springframework.http.HttpStatus;

import java.util.List;


public class CardValidation {
    public static void checkCard(Card card){
        if(card==null){
            throw  new CardException("Card doesn't exist.", HttpStatus.NOT_FOUND);
        }
    }

    public static void checkType(String type){
        try{
            Type.valueOf(type.toUpperCase());
        }catch (CardException c){
            throw new CardException("Invalid Type",HttpStatus.NOT_FOUND);
        }
    }

    public static void checkColor(String color){
        try{
            Color.valueOf(color.toUpperCase());
        }catch (CardException c){
            throw new CardException("Invalid Color",HttpStatus.NOT_FOUND);
        }
    }

    public  static void checkId(long id){
        if(id<=0){
            throw new CardException("Id must be greater than 0",HttpStatus.BAD_REQUEST);
        }
    }
    public static void checkCardList(List<Card> cards) {
        if (cards == null || cards.isEmpty()) {
            throw new CardException("No cards found with the specified criteria.", HttpStatus.NOT_FOUND);
        }
    }

}
