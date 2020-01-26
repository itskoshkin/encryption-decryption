public interface Crypt {
    char[] encrypt(char[] chars, int key);

    char[] decrypt(char[] chars, int key);
}

class Unicode implements Crypt {
    @Override
    public char[] encrypt(char[] chars, int key) {
        for (int i = 0; i < chars.length; i++)
            chars[i] = (char) ((chars[i] + key) % 65_536);
        return chars;
    }

    @Override
    public char[] decrypt(char[] chars, int key) {
        for (int i = 0; i < chars.length; i++)
            chars[i] = (char) ((chars[i] + 65_536 - key) % 65_536);
        return chars;
    }
}

class Shift implements Crypt {

    final String alphLowCase = "abcdefghijklmnopqrstuvwxyz";
    final String alphUppCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public char[] encrypt(char[] chars, int key) {
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i])) {
                chars[i] += key % alphLowCase.length();
                if (chars[i] > 'z')
                    chars[i] = (char) (chars[i] % 'z' + 'a' - 1);
                else if (chars[i] < 'a')
                    chars[i] = (char) (chars[i] + ('z' - 'a') + 1);
            } else if (Character.isUpperCase(chars[i])) {
                chars[i] += key % alphUppCase.length();
                if (chars[i] > 'Z')
                    chars[i] = (char) (chars[i] % 'Z' + 'A' - 1);
                else if (chars[i] < 'A')
                    chars[i] = (char) (chars[i] + ('Z' - 'A') + 1);
            }
        }
        return chars;
    }

    @Override
    public char[] decrypt(char[] chars, int key) {
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i])) {
                chars[i] -= key % alphLowCase.length();
                if (chars[i] > 'z')
                    chars[i] = (char) (chars[i] % 'z' + 'a' - 1);
                else if (chars[i] < 'a')
                    chars[i] = (char) (chars[i] + ('z' - 'a') + 1);
            } else if (Character.isUpperCase(chars[i])) {
                chars[i] -= key % alphUppCase.length();
                if (chars[i] > 'Z')
                    chars[i] = (char) (chars[i] % 'Z' + 'A' - 1);
                else if (chars[i] < 'A')
                    chars[i] = (char) (chars[i] + ('Z' - 'A') + 1);
            }
        }
        return chars;
    }
}

class DataCrypt {
    private Crypt crypt;

    public void setCrypt(Crypt crypt) {
        this.crypt = crypt;
    }

    public char[] encrypt(char[] chars, int key) {
        return this.crypt.encrypt(chars, key);
    }

    public char[] decrypt(char[] chars, int key) {
        return this.crypt.decrypt(chars, key);
    }
}