import Entities.Atmcard;
import Entities.User;

public class AuthenticatedState implements MachineState {
    AtmMachine machine;
    User user;
    public AuthenticatedState(AtmMachine atmMachine,User user) {
        this.machine=atmMachine;
        this.user=user;
    }

    @Override
    public void insertCard( Atmcard atmcard) {

    }

    @Override
    public boolean authenticate(Atmcard atmcard) {
//        System.out.println("------Authentication started--------");
//        System.out.println("------Authentication successful-----");
//        machine.setCurrentMachineState(new CardInsertedState(machine,user));
        return false;
    }

    @Override
    public Integer enquireBalance(Atmcard atmcard, User user) {
        if(user==null)
            return null;
        machine.setCurrentMachineState(new CashWithdrawState(machine,user));
        return user.getBankAccount().getBalance();
    }

    @Override
    public Integer withdrawAmount(Atmcard atmcard, int amount) {
        return null;
    }
}
