

public class RobsonToJava {
    
    public String toJava(String program, String class_name) {
        StringBuilder acc = new StringBuilder();

        String filename = class_name + "_json_progam.json";
        program = program.replace("\"", "\\\"").replace("\n", " ");

        acc.append("import java.io.IOException;\n");
        acc.append("import java.nio.charset.StandardCharsets;\n");
        acc.append("import java.nio.file.Files;\n");
        acc.append("import java.nio.file.Path;\n");
        acc.append("import java.nio.file.Paths;\n");
        acc.append("import com.google.gson.JsonIOException;\n\n\n");

        acc.append("public class "+ class_name +" {\n\n");
        acc.append("    public static void main(String[] args) {\n");
        acc.append("        try {\n");
        acc.append("            Path file = Paths.get(\""+filename+"\");\n");
        acc.append("            Files.writeString(file, \""+program+"\", StandardCharsets.UTF_8);\n");
        acc.append("        } catch (JsonIOException | IOException e) {\n");
        acc.append("            e.printStackTrace();\n};\n\n");
        acc.append("        Robson robson = new Robson();\n");
        acc.append("        robson.fromJSON(\""+filename+"\");\n");
        acc.append("        System.out.println(robson.wykonaj());\n");
        acc.append("\n  }");
        acc.append("\n}\n");

        return acc.toString();
    }
}
