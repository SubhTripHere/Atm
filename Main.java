import Entities.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Atmcard atmcard=new Atmcard(1,1234,new Date(20241222), CardType.DEBIT);
        Map<Note,Integer> map=new HashMap<>();
        Note tenner=new Note(10, NoteType.Tens);
        Note hundred=new Note(100,NoteType.Hundreds);
        Note thousand=new Note(1000,NoteType.Thousands);
        map.put(tenner,10);
        map.put(hundred,1);
        map.put(thousand,1);

        AtmMachine atmMachine=new AtmMachine(1,"GS",1200,map);
        List<Atmcard> cardList=new ArrayList<>();
        cardList.add(atmcard);
        BankAccount account=new BankAccount(111,cardList,1000);

        //user creation
        User user=new User("Subham",1,account);

        // performing operations
        atmMachine.insertCard(atmcard);
        System.out.println(atmMachine.authenticateUser(user));

        //enquire balance
        System.out.println(atmMachine.getBalance(user));


    }
}
