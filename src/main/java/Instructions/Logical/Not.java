package Instructions.Logical;

import Instructions.Instruction;
import java.util.*;

public class Not extends Instruction {
    private Instruction argument;

    @Override
    public double wykonaj(Map<String, Double> state) {
        if (argument.wykonaj(state) > 0)
            return 0.0;
        else
            return 1.0;
    }

}
