package Instructions.Logical;

import Instructions.Instruction;
import java.util.*;

public class True extends Instruction {

    @Override
    public double wykonaj(Map<String, Double> state) {
        return 1.0;
    }

}
