package encdec;

public interface EncryptDecrypt {
    char[] decrypt(int key);

    char[] encrypt(int key);

    char[] getChars();
}
