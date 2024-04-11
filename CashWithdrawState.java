import Entities.Atmcard;
import Entities.Note;
import Entities.User;

import java.util.Map;

public class CashWithdrawState implements MachineState {
    AtmMachine machine;
    User user;
    public CashWithdrawState(AtmMachine atmMachine,User user) {
        this.machine=atmMachine;
        this.user=user;
    }

    @Override
    public void insertCard(Atmcard atmcard) {

    }

    @Override
    public boolean authenticate( Atmcard atmcard) {
        return false;
    }

    @Override
    public Integer enquireBalance(Atmcard atmcard, User user) {
        return null;
    }

    @Override
    public Integer withdrawAmount(Atmcard atmcard, int amount) {
        System.out.println("-----starting to withdraw from account------");
        int total=machine.totalMoney;
        Map<Note,Integer> map=machine.cashDenomAvailable;
        total-=amount;
        machine.totalMoney=total;
        System.out.println("-----------Completion of withdrawal succesfully--------");
        machine.setCurrentMachineState(new IdleState(machine,user));
        return null;
    }
}
