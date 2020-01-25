import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

abstract class IO {
    abstract char[] input();

    abstract void output(char[] chars);
}

class FileIO extends IO {

    private String in;
    private String out;

    public FileIO(String in, String out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public char[] input() {
        // FIXME: 25.01.2020 TODO Reader
        try {
            final Scanner scanner = new Scanner(new File(this.in));
            String data = scanner.nextLine();
            scanner.close();
            return data.toCharArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "".toCharArray();
    }

    @Override
    public void output(char[] chars) {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.out));
            fileWriter.write(chars);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class StdIO extends IO {

    private String data;

    public StdIO(String data) {
        this.data = data;
    }

    @Override
    public char[] input() {
        return data.toCharArray();
    }

    @Override
    public void output(char[] chars) {
        System.out.println(chars);
    }
}

class IOStaticFactory {
    public static IO newInstance(String in, String out) {
        return new FileIO(in, out);
    }

    public static IO newInstance(String data) {
        return new StdIO(data);
    }
}
