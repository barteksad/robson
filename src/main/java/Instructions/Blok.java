package Instructions;
import java.util.*;
public class Blok extends Instruction {
    private Instruction[] instrukcje;

    @Override
    public double wykonaj(Map<String, Double> state) {
        if(instrukcje.length == 0)
            return 0;
        double wynik = 0;
        for(Instruction i : instrukcje)
            wynik = i.wykonaj(state);
        return wynik;
    }
}
