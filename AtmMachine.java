import Entities.Atmcard;
import Entities.Note;
import Entities.User;
import lombok.Data;
import lombok.Setter;

import java.util.Map;

@Data
@Setter
public class AtmMachine {
    int machineId;
    String bankName;

    int totalMoney;
    Map<Note,Integer> cashDenomAvailable;
    User user;

    Atmcard atmcard;
    MachineState currState=new IdleState(this,user) ;
    public AtmMachine(int machineId, String bankName,int totalMoney, Map<Note, Integer> cashDenomAvailable) {
        this.machineId = machineId;
        this.bankName = bankName;
        this.totalMoney=totalMoney;
        this.cashDenomAvailable = cashDenomAvailable;
        this.atmcard=null;
    }

    public void setCurrentMachineState(MachineState machineState){
        this.currState=machineState;
    }

    public boolean authenticateUser(User user){
       return currState.authenticate(atmcard);
    }
    public void addCashToMachine(Note note,int val){
        cashDenomAvailable.put(note,cashDenomAvailable.getOrDefault(note,val)+val);
        this.totalMoney+=val*(note.getNoteVal()*val);
    }

    public Integer getBalance(User user){
       return currState.enquireBalance(atmcard,user);
    }
    public Integer withdrawCash(int requestAmount){
       return currState.withdrawAmount(atmcard,requestAmount);
    }

    void insertCard(Atmcard atmcard){
        currState.insertCard(atmcard);
    }
}
