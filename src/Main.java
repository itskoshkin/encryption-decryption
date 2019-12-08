import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            hashMap.put(args[i], args[i + 1]);
        }

        if (hashMap.containsKey("-data")) {
            System.out.print(new Main().encdec(
                    hashMap.get("-mode"),
                    hashMap.get("-data").replace("\"", ""),
                    Integer.parseInt(hashMap.get("-key"))));
        } else {
            new Main().encdec(
                    hashMap.get("-mode"),
                    hashMap.get("-in"),
                    hashMap.get("-out"),
                    Integer.parseInt(hashMap.get("-key")));
        }


    }


    private char[] encdec(String func, String string, int key) {
        char[] character = new char[string.length()];
        if ("enc".equals(func)) {
            for (int i = 0; i < string.length(); i++)
                character[i] = (char) (string.charAt(i) + key);
            return character;
        } else if ("dec".equals(func)) {
            for (int i = 0; i < string.length(); i++)
                character[i] = (char) (string.charAt(i) - key);
            return character;
        } else {
            throw new Error();
        }
    }


    private void encdec(String func, String in, String out, int key) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(in))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bufferedReader.readLine());
            char[] character = new char[stringBuilder.length()];
            if ("enc".equals(func)) {
                for (int i = 0; i < stringBuilder.length(); i++)
                    character[i] = (char) (stringBuilder.charAt(i) + key);
                try (FileWriter writer = new FileWriter(out, false)) {
                    writer.write(character);
                }
            } else if ("dec".equals(func)) {
                for (int i = 0; i < stringBuilder.length(); i++)
                    character[i] = (char) (stringBuilder.charAt(i) - key);
                try (FileWriter writer = new FileWriter(out, false)) {
                    writer.write(character);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}