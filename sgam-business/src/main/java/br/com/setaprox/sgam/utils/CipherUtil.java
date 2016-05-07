package br.com.setaprox.sgam.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.shiro.codec.Base64;

/**
 * Classe utilitária para métodos de encriptação/decodificação de
 * dados.
 */
public class CipherUtil {
	
	private static SecretKeyFactory factory = null;
	public static final String AGENDAWEB_DES_KEY="0K7GD5WLN86FSCO5xD6k3k8f";
	
	
	/**
	 * Codifica uma string utiliznado SHA-256 gerando um hash e o converte para Hexadecimal.
	 * 
	 * @param dados
	 * @return hash em hexadecimal.
	 * 
	 * @throws Exception
	 */
	public static String encodeSHA256(String dados) throws Exception {
		
		if (dados == null) {
			return "";
		}
		
		MessageDigest algorithm;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(dados.getBytes("UTF-8"));
			 
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			return hexString.toString();
			
		} catch (NoSuchAlgorithmException ex) {
			throw new Exception("Algoritmo de codificação não encontrado");
		} catch (UnsupportedEncodingException ex) {
			throw new Exception("Codificação não suportada: UTF-8");
		} finally {
			algorithm = null;
		}
	}
	
	/**
	 * Utiliza o algoritmo DES (Data Encryption Standard) para codificar um dado.
	 * 
	 * @param chave - A chave utilizada para codificar o dado.
	 * @param dado - O que será codificado. 
	 * @return
	 * @throws Exception
	 */
	public static String encodeDES(String chave, String dado) throws Exception {
		
        byte[] keyBytes = chave.getBytes();
        
        if (factory == null) {
        	factory  = SecretKeyFactory.getInstance("DES");
        }
        
        SecretKey key = factory.generateSecret(new DESKeySpec(keyBytes));
        
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
		
        // Codifica o dado em UTF-8
        byte[] dadoUTF8 = dado.getBytes("UTF8");
        
        // Codifica o dado usando o DES
        byte[] dadoEncriptado = cipher.doFinal(dadoUTF8);
        
        cipher = null;
        
        // Codifica em base 64 para obter a string final
        return Base64.encodeToString(dadoEncriptado);
	}
	
	/**
	 * Utiliza o algoritmo DES (Data Encryption Standard) para decodificar um dado.
	 * 
	 * @param chave
	 * @param dado
	 * @return
	 * @throws Exception
	 */
	public static String decodeDES(String chave, String dado) throws Exception {

        byte[] 	keyBytes = chave.getBytes();
        
        if (factory == null) {
        	factory  = SecretKeyFactory.getInstance("DES");
        }
        
        SecretKey key = factory.generateSecret(new DESKeySpec(keyBytes));
		
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        
        // Decodifica do base64 para obter os bytes
        byte[] dadoDecodificado = Base64.decode(dado);
        
        // Decodifica o dado.
        byte[] utf8 = cipher.doFinal(dadoDecodificado);
        
        cipher = null;
        
        return new String(utf8, "UTF8");
	}

}