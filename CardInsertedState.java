import Entities.Atmcard;
import Entities.User;

public class CardInsertedState implements MachineState {
    AtmMachine machine;
    User user;
    public CardInsertedState(AtmMachine atmMachine,User user) {
        this.machine=atmMachine;
        this.user=user;
    }

    @Override
    public void insertCard(Atmcard atmcard) {
       // machine.setAtmcard(atmcard);
    }

    @Override
    public boolean authenticate(Atmcard atmcard) {
        System.out.println("-------Authentication is starting-------");
        System.out.println("-------Authenticated User---------------");
        machine.setCurrentMachineState(new AuthenticatedState(machine,user));
        return true;
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
