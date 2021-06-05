package Instructions;

import java.util.*;

public class While extends Instruction {
    private Instruction warunek;
    private Instruction blok;

    @Override
    public double wykonaj(Map<String, Double> state) {
        while (warunek.wykonaj(state) > 0)
            blok.wykonaj(state);
        return 0.0;
    }

}
