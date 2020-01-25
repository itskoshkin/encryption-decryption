public interface Crypt {
    char[] encrypt(char[] chars, int key);

    char[] decrypt(char[] chars, int key);
}

class Unicode implements Crypt {
    @Override
    public char[] encrypt(char[] chars, int key) {
        return new char[0];
    }

    @Override
    public char[] decrypt(char[] chars, int key) {
        return new char[0];
    }
}

class Shift implements Crypt {
    @Override
    public char[] encrypt(char[] chars, int key) {
        return new char[0];
    }

    @Override
    public char[] decrypt(char[] chars, int key) {
        return new char[0];
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