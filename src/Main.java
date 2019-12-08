import encdec.Shift;
import encdec.Unicode;
import input.ConsoleInput;
import input.FileInput;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < args.length; i += 2)
            hashMap.put(args[i], args[i + 1]);
        new Main().run(hashMap);
    }

    private void run(HashMap<String, String> hashMap) {
        if (hashMap.containsKey("-data")) {
            runWithData(hashMap);
        } else {
            runWithFile(hashMap);
        }
    }

    private void runWithFile(HashMap<String, String> hashMap) {
        FileInput fileInput = new FileInput(hashMap.get("-in"), hashMap.get("-out"));
        char[] chars = fileInput.input();
        if ("unicode".equals(hashMap.get("-alg"))) {
            if ("enc".equals(hashMap.get("-mode"))) {
                Unicode unicode = new Unicode(chars);
                unicode.encrypt(Integer.parseInt(hashMap.get("-key")));
                fileInput.output(unicode.getChars());
            } else {
                Unicode unicode = new Unicode(chars);
                unicode.decrypt(Integer.parseInt(hashMap.get("-key")));
                fileInput.output(unicode.getChars());
            }
        } else {
            if ("enc".equals(hashMap.get("-mode"))) {
                Shift shift = new Shift(chars);
                shift.encrypt(Integer.parseInt(hashMap.get("-key")));
                fileInput.output(shift.getChars());
            } else {
                Shift shift = new Shift(chars);
                shift.decrypt(Integer.parseInt(hashMap.get("-key")));
                fileInput.output(shift.getChars());
            }
        }
    }

    private void runWithData(HashMap<String, String> hashMap) {
        ConsoleInput consoleInput = new ConsoleInput(hashMap.get("-data"));
        char[] chars = consoleInput.input();
        if ("unicode".equals(hashMap.get("-alg"))) {
            if ("enc".equals(hashMap.get("-mode"))) {
                Unicode unicode = new Unicode(chars);
                unicode.encrypt(Integer.parseInt(hashMap.get("-key")));
                System.err.print(unicode.getChars());
            } else {
                Unicode unicode = new Unicode(chars);
                unicode.decrypt(Integer.parseInt(hashMap.get("-key")));
                System.out.print(unicode.getChars());
            }
        } else {
            if ("enc".equals(hashMap.get("-mode"))) {
                Shift shift = new Shift(chars);
                shift.encrypt(Integer.parseInt(hashMap.get("-key")));
                System.out.print(shift.getChars());
            } else {
                Shift shift = new Shift(chars);
                shift.decrypt(Integer.parseInt(hashMap.get("-key")));
                System.out.print(shift.getChars());
            }
        }
    }


}
