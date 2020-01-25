import java.util.Arrays;

abstract class IO {
    abstract char[] input();

    abstract void output(char[] chars);
}

class FileIO extends IO {

    String in;
    String out;

    public FileIO(String in, String out) {
        this.in = in;
        this.out = out;
    }

    @Override
    char[] input() {
        String data = "";
        //TODO
        return data.toCharArray();
    }

    @Override
    void output(char[] chars) {

    }
}

class StdIO extends IO {

    String data;

    StdIO(String data) {
        this.data = data;
    }

    @Override
    char[] input() {
        return data.toCharArray();
    }

    @Override
    void output(char[] chars) {
        System.out.println(Arrays.toString(chars));
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
