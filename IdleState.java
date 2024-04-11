import Entities.Atmcard;
import Entities.User;

public class IdleState implements MachineState{
    AtmMachine atmMachine;
    User user;
    IdleState(AtmMachine atmMachine,User user){
        this.atmMachine=atmMachine;
        this.user=user;
    }
    @Override
    public void insertCard(Atmcard atmcard) {
        System.out.println("-----going to insert card------");
        atmMachine.atmcard=atmcard;
        System.out.println("-----card inserted-------------");
        atmMachine.setCurrentMachineState(new CardInsertedState(atmMachine,user));
    }

    @Override
    public boolean authenticate(Atmcard atmcard) {
        return false;
    }

    @Override
    public Integer enquireBalance(Atmcard atmcard, User user) {
        return null;
    }

    @Override
    public Integer withdrawAmount(Atmcard atmcard, int amount) {
        return null;
    }
}
