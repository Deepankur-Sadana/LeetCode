import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AdvancedEncryptionStandard
{
    private byte[] key;

    private static final String ALGORITHM = "AES";

    public AdvancedEncryptionStandard(byte[] key)
    {
        this.key = key;
    }

    /**
     * Encrypts the given plain text
     *
     * @param plainText The plain text to encrypt
     */
    public byte[] encrypt(byte[] plainText) throws Exception
    {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return cipher.doFinal(plainText);
    }

    /**
     * Decrypts the given byte array
     *
     * @param cipherText The data to decrypt
     */
    public byte[] decrypt(byte[] cipherText) throws Exception
    {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        return cipher.doFinal(cipherText);
    }
    
    public static void main(String args[]) {
    	byte[] encryptionKey = "qwerasdfzxcvzxcv".getBytes(StandardCharsets.UTF_8);
    	byte[] plainText = "Hello world!".getBytes(StandardCharsets.UTF_8);
    	AdvancedEncryptionStandard advancedEncryptionStandard = new AdvancedEncryptionStandard(
    	        encryptionKey);
    	byte[] cipherText = null;
		try {
			cipherText = advancedEncryptionStandard.encrypt(plainText);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	byte[] decryptedCipherText = null;
		try {
			decryptedCipherText = advancedEncryptionStandard.decrypt(cipherText);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	System.out.println(new String(plainText));
    	System.out.println(new String(cipherText));
    	System.out.println(new String(decryptedCipherText));
    }
    
    
    
    
    
}