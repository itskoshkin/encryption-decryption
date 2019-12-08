package encdec;

public class Unicode implements EncryptDecrypt {

    private char[] chars;

    public char[] getChars() {
        return chars;
    }

    public Unicode(char[] chars) {
        this.chars = chars;
    }

    @Override
    public char[] decrypt(int key) {
        for (int i = 0; i < chars.length; i++)
            chars[i] = (char) (chars[i] - key);
        return chars;
    }

    @Override
    public char[] encrypt(int key) {
        for (int i = 0; i < chars.length; i++)
            chars[i] = (char) (chars[i] + key);
        return chars;
    }
}
