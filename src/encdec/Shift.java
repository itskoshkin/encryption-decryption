package encdec;

public class Shift implements EncryptDecrypt {

    private char[] chars;
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Shift(char[] chars) {
        this.chars = chars;
    }

    public char[] getChars() {
        return chars;
    }

    @Override
    public char[] decrypt(int key) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (chars[i] == alphabet.charAt(j)) {
                    chars[i] = alphabet.charAt((j - key) % alphabet.length());
                    break;
                }
            }
        }
        return chars;
    }

    @Override
    public char[] encrypt(int key) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (chars[i] == alphabet.charAt(j)) {
                    chars[i] = alphabet.charAt((j + key) % alphabet.length());
                    break;
                }
            }
        }
        return chars;
    }

}
