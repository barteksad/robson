package Instructions.Logical;

import Instructions.TwoArgsOperation;

import java.util.*;

public class And extends TwoArgsOperation {


    @Override
    public double wykonaj(Map<String, Double> state) {
        if(argument1.wykonaj(state) * argument2.wykonaj(state) > 0)
            return 1.0;
        else
            return 0.0;
    }
}