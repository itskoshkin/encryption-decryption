import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.in))) {
            return bufferedReader.readLine().toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "".toCharArray();
    }

    @Override
    public void output(char[] chars) {
        try (FileWriter writer = new FileWriter(this.out, false)) {
            writer.write(chars);
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
