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
import Utils.RuntimeTypeAdapterFactory;

public class Robson {
    private Instruction program;
    private Gson gson;
    private String json_program;

    public Robson() {
        RuntimeTypeAdapterFactory<Instruction> InstructionAdapter = RuntimeTypeAdapterFactory
                .of(Instruction.class, "typ").registerSubtype(Blok.class, "Blok")
                .registerSubtype(Liczba.class, "Liczba").registerSubtype(Dzielenie.class, "Dzielenie")
                .registerSubtype(Plus.class, "Plus").registerSubtype(Razy.class, "Razy")
                .registerSubtype(Equal.class, "==").registerSubtype(Greater.class, ">")
                .registerSubtype(GreaterEqual.class, ">=").registerSubtype(Less.class, "<")
                .registerSubtype(LessEqual.class, "<=").registerSubtype(And.class, "And")
                .registerSubtype(False.class, "False").registerSubtype(Or.class, "Or")
                .registerSubtype(True.class, "True").registerSubtype(If.class, "If")
                .registerSubtype(Przypisanie.class, "Przypisanie").registerSubtype(While.class, "While")
                .registerSubtype(Modulo.class, "%").registerSubtype(Zmienna.class, "Zmienna")
                .registerSubtype(Minus.class, "Minus");
        gson = new GsonBuilder().registerTypeAdapterFactory(InstructionAdapter).disableHtmlEscaping().create();
    }

    public void fromJSON(String filename) throws NieprawidlowyProgram {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filename));
            program = gson.fromJson(reader, Instruction.class);
            json_program = Files.readString(Paths.get(filename), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new NieprawidlowyProgram();
        }
    }

    void toJSON(String filename) {
        try {
            Path file = Paths.get(filename);
            String lines = gson.toJson(program, Instruction.class);
            Files.writeString(file, lines, StandardCharsets.UTF_8);
        } catch (JsonIOException | IOException e) {
            e.printStackTrace();
        }
    }

    void toJava(String filename) {
        try {

            String actual_filename = filename;
            String class_name = filename;
            RobsonToJava parser = new RobsonToJava();

            // zapewnia działanie z każdą ścierzką
            if(!actual_filename.endsWith(".java"))
                actual_filename += ".java";
            else
                class_name = class_name.replace(".java", "");
            
            if(filename.contains("/")) {
                int last_slash_pos = filename.lastIndexOf("/");
                class_name = class_name.substring(last_slash_pos + 1);
            }
                
            Path file = Paths.get(actual_filename);
            String lines = parser.toJava(json_program, class_name);
            Files.writeString(file, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double wykonaj() throws BladWykonania {
        Map<String, Double> state = new HashMap<String, Double>();
        return program.wykonaj(state);
    }
}
