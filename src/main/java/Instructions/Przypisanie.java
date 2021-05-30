package Instructions;

import java.util.*;

public class Przypisanie extends Instruction {
    private String nazwa;
    private Instruction wartosc;

    @Override
    public double wykonaj(Map<String, Double> state) {
        double w = wartosc.wykonaj(state);
        state.put(nazwa, w);
        return w;
    }
}
