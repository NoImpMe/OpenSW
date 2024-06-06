package main;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class AESUtil {

    private static final String AES = "AES";
    private static final String CHARSET = "UTF-8";
    private static final int KEY_SIZE = 128;

    // 암호화
    public static String encrypt(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key));
        byte[] encrypted = cipher.doFinal(data.getBytes(CHARSET));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // 복호화
    public static String decrypt(String encryptedData, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decrypted, CHARSET);
    }

    // 비밀 키 생성
    private static SecretKeySpec getSecretKey(String key) throws Exception {
        byte[] keyBytes = key.getBytes(CHARSET);
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(KEY_SIZE, secureRandom);
        SecretKey secretKey = keyGenerator.generateKey();
        return new SecretKeySpec(keyBytes, 0, keyBytes.length, AES);
    }


}
