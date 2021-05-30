package Instructions.Logical;

import Instructions.Instruction;
import java.util.*;

public class If extends Instruction {
    private Instruction warunek;
    private Instruction blok_prawda;
    private Instruction blok_falsz;

    @Override
    public double wykonaj(Map<String, Double> state) {
        if (warunek.wykonaj(state) > 0)
            return blok_prawda.wykonaj(state);
        else
            return blok_falsz.wykonaj(state);
    }
}
