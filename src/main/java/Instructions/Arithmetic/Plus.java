package Instructions.Arithmetic;

import Instructions.TwoArgsOperation;
import java.util.*;
import java.util.*;public class Plus extends TwoArgsOperation {
 

    @Override
    public double wykonaj(Map<String, Double> state) {
        return argument1.wykonaj(state) + argument2.wykonaj(state);
    }
    
}