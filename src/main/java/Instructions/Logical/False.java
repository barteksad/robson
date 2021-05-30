package Instructions.Logical;

import Instructions.Instruction;
import java.util.*;

public class False extends Instruction {

    @Override
    public double wykonaj(Map<String, Double> state) {
        return 0.0;
    }
}
