import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < args.length; i += 2)
            hashMap.put(args[i], args[i + 1]);
        new Main().run(hashMap);
    }

    private void run(HashMap<String, String> hashMap) {
        IO io;

        if (hashMap.containsKey("-data"))
            io = IOStaticFactory.newInstance(hashMap.get("-data"));
        else
            io = IOStaticFactory.newInstance(hashMap.get("-in"), hashMap.get("-out"));

        char[] chars = io.input();

        DataCrypt dataCrypt = new DataCrypt();

        if (hashMap.containsKey("-alg") && "unicode".equals(hashMap.get("-alg")))
            dataCrypt.setCrypt(new Unicode());
        else
            dataCrypt.setCrypt(new Shift());

        if ("enc".equals(hashMap.get("-mode")))
            chars = dataCrypt.encrypt(chars, Integer.parseInt(hashMap.get("-key")));
        else
            chars = dataCrypt.decrypt(chars, Integer.parseInt(hashMap.get("-key")));

        io.output(chars);
    }

}
