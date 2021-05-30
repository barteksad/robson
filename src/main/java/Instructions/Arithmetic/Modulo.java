package Instructions.Arithmetic;

import Instructions.TwoArgsOperation;
import java.util.*;

public class Modulo extends TwoArgsOperation {

    @Override
    public double wykonaj(Map<String, Double> state) {
        return (double) (int) argument1.wykonaj(state) % (int) argument2.wykonaj(state);
    }

}