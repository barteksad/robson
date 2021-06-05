package Instructions;

import java.util.Map;

public abstract class Instruction {
    public abstract double wykonaj(Map<String, Double> state);
}
