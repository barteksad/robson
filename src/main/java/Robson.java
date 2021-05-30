import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import Exceptions.*;
import Instructions.*;
import Instructions.Arithmetic.*;
import Instructions.Comparison.*;
import Instructions.Logical.*;

public class Robson {
    private Instruction program;
    private Gson gson;

    public Robson() {
        RuntimeTypeAdapterFactory<Instruction> InstructionAdapter = RuntimeTypeAdapterFactory.of(Instruction.class, "typ")
            .registerSubtype(Blok.class, "Blok")
            .registerSubtype(Liczba.class, "Liczba")
            .registerSubtype(Dzielenie.class, "Dzielenie")
            .registerSubtype(Plus.class, "Plus")
            .registerSubtype(Razy.class, "Razy")
            .registerSubtype(Equal.class, "==")
            .registerSubtype(Greater.class, ">")
            .registerSubtype(GreaterEqual.class, ">=")
            .registerSubtype(Less.class, "<")
            .registerSubtype(LessEqual.class, "<=")
            .registerSubtype(And.class, "And")
            .registerSubtype(False.class, "False")
            .registerSubtype(Or.class, "Or")
            .registerSubtype(True.class, "True")
            .registerSubtype(If.class, "If")
            .registerSubtype(Przypisanie.class, "Przypisanie")
            .registerSubtype(While.class, "While")
            .registerSubtype(Zmienna.class, "Zmienna")
            .registerSubtype(Minus.class, "Minus");
        gson = new GsonBuilder().registerTypeAdapterFactory(InstructionAdapter).disableHtmlEscaping().create();
    }

    public void fromJSON(String filename) throws NieprawidlowyProgram {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filename));
            program = gson.fromJson(reader, Instruction.class);
        } catch(Exception e) {
            throw new NieprawidlowyProgram();
        }
    }

    void toJSON(String filename) {
        try {
            Path file = Paths.get(filename);
            String lines = gson.toJson(program);
            Files.writeString(file, lines, StandardCharsets.UTF_8);
            System.out.println(gson.toJson(program));
        } catch (JsonIOException | IOException e) {
            e.printStackTrace();
        }
    }

    void toJava(String filename){

    }

    public double wykonaj() throws BladWykonania {
        Map<String, Double> state = new HashMap<String, Double>();
        return program.wykonaj(state);
    }
}
