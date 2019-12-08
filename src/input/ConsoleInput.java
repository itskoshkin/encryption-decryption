package input;

public class ConsoleInput implements Input {

    private String string;

    public ConsoleInput(String string) {
        this.string = string;
    }

    @Override
    public char[] input() {
        return this.string.toCharArray();
    }
}
