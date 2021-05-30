package Instructions;
import java.util.*;
public class Zmienna extends Instruction {
    private String nazwa;

    @Override
    public double wykonaj(Map<String, Double> state) {
        return state.get(nazwa);
    }
}
