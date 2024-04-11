package Entities;

import lombok.Data;

import java.util.List;

@Data
public class BankAccount {
    int accId;
    List<Atmcard> atmcard;
    int balance;

    public BankAccount(int accId, List<Atmcard> atmcard, int balance) {
        this.accId = accId;
        this.atmcard = atmcard;
        this.balance = balance;
    }
}
