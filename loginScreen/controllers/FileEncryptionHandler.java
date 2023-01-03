package loginScreen.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class FileEncryptionHandler {
	
	private Key secretKey;
	private Cipher cipher;
	private final String cipherAlgo = "AES";
	private byte[] inputBytes;
	private byte[] outputBytes;
	private FileInputStream userInfo;
	private FileOutputStream cryptUserInfo;

    public void encryptFile(String key, File inputFile, File outputFile) {
        try {
			cryptFile(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
 
    public void decryptFile(String key, File inputFile, File outputFile) {
        try {
			cryptFile(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private void cryptFile(int cipherMode, String key, File inputFile, File outputFile)  {
    	try {
            secretKey = new SecretKeySpec(key.getBytes(), cipherAlgo);
            cipher = Cipher.getInstance(cipherAlgo);
            cipher.init(cipherMode, secretKey);
             
            userInfo = new FileInputStream(inputFile);
            
            inputBytes = new byte[(int) inputFile.length()];
            userInfo.read(inputBytes);
             
            outputBytes = cipher.doFinal(inputBytes);
             
            cryptUserInfo= new FileOutputStream(outputFile);
            cryptUserInfo.write(outputBytes);
             
            userInfo.close();
            cryptUserInfo.close();
             
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException e) {
            e.printStackTrace();
        }
    }
}
