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
                for (int j = 0; j < alphLowCase.length(); j++) {
                    if (chars[i] == alphLowCase.charAt(j)) {
                        // FIXME: 25.01.2020
                        chars[i] = (char) ('a' + (chars[i] + key % alphLowCase.length()) % alphLowCase.length());
                        break;
                    }
                }
            } else if (Character.isUpperCase(chars[i])) {
                for (int j = 0; j < alphUppCase.length(); j++) {
                    if (chars[i] == alphUppCase.charAt(j)) {
                        // FIXME: 25.01.2020
                        chars[i] = (char) ('a' + (chars[i] + key % alphUppCase.length()) % alphUppCase.length());
                        break;
                    }
                }
            }

        }
        return chars;
    }

    @Override
    public char[] decrypt(char[] chars, int key) {
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i])) {
                for (int j = 0; j < alphLowCase.length(); j++) {
                    if (chars[i] == alphLowCase.charAt(j)) {
                        // FIXME: 25.01.2020
                        chars[i] = (char) ('a' + (chars[i] - key % alphLowCase.length()) % alphLowCase.length());
                        break;
                    }
                }
            } else if (Character.isUpperCase(chars[i])) {
                for (int j = 0; j < alphUppCase.length(); j++) {
                    if (chars[i] == alphUppCase.charAt(j)) {
                        // FIXME: 25.01.2020
                        chars[i] = (char) ('a' + (chars[i] - key % alphUppCase.length()) % alphUppCase.length());
                        break;
                    }
                }
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