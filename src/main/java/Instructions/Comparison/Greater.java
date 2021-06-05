package Instructions.Comparison;

import Instructions.TwoArgsOperation;
import java.util.*;

import java.util.*;

public class Greater extends TwoArgsOperation {

    @Override
    public double wykonaj(Map<String, Double> state) {
        if (argument1.wykonaj(state) > argument2.wykonaj(state))
            return 1.0;
        else
            return 0.0;
    }

}