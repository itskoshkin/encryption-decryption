package input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileInput implements Input {

    private String pathIn;
    private String pathOut;

    public FileInput(String pathIn, String pathOut) {
        this.pathIn = pathIn;
        this.pathOut = pathOut;
    }



    @Override
    public char[] input() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.pathIn))) {
            return bufferedReader.readLine().toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void output(char[] character){
        try (FileWriter writer = new FileWriter(this.pathOut, false)) {
            writer.write(character);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
