package Entities;

import lombok.Data;

import java.util.Date;

@Data
public class Atmcard {
    int cardId;
    int pin;
    Date expiryDate;
    CardType cardType;

    public Atmcard(int cardId, int pin, Date expiryDate,CardType cardType) {
        this.cardId = cardId;
        this.pin = pin;
        this.expiryDate = expiryDate;
        this.cardType=cardType;
    }
}
