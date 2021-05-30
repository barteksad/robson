package Instructions;

import java.util.*;

public class Liczba extends Instruction {
    private double wartosc;

    @Override
    public double wykonaj(Map<String, Double> state) {
        return wartosc;
    }
}
