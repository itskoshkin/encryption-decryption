public interface Crypt {
    char[] encrypt(char[] chars, int key);

    char[] decrypt(char[] chars, int key);
}

class Unicode implements Crypt {
    @Override
    public char[] encrypt(char[] chars, int key) {
        // FIXME: 25.01.2020
        for (int i = 0; i < chars.length; i++)
            chars[i] = (char) (chars[i] + key);
        return chars;
    }

    @Override
    public char[] decrypt(char[] chars, int key) {
        // FIXME: 25.01.2020
        for (int i = 0; i < chars.length; i++)
            chars[i] = (char) (chars[i] - key);
        return chars;
    }
}

class Shift implements Crypt {

    final String alphLowCase = "abcdefghijklmnopqrstuvwxyz";
    final String alphUppCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public char[] encrypt(char[] chars, int key) {
        // FIXME: 25.01.2020
        /*for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (chars[i] == alphabet.charAt(j)) {
                    chars[i] = alphabet.charAt((j + key) % alphabet.length());
                    break;
                }
            }
        }*/
        return chars;
    }

    @Override
    public char[] decrypt(char[] chars, int key) {
        // FIXME: 25.01.2020
        /*for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (chars[i] == alphabet.charAt(j)) {
                    chars[i] = alphabet.charAt((j - key) % alphabet.length());
                    break;
                }
            }
        }*/
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