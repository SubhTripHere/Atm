import Entities.Atmcard;
import Entities.User;

public interface MachineState {
    void insertCard(Atmcard atmcard);

    boolean authenticate( Atmcard atmcard);


    Integer enquireBalance(Atmcard atmcard, User user);

    Integer withdrawAmount(Atmcard atmcard, int amount);

}
