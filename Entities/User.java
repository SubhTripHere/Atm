package Entities;

import lombok.Data;

@Data
public class User {
    String name;
    int id;
    BankAccount bankAccount;

    public User(String name, int id, BankAccount bankAccount) {
        this.name = name;
        this.id = id;
        this.bankAccount = bankAccount;
    }
}
