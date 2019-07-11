package com.example_utils.encryption;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

/**
 * RAS���ܹ�����
 * 
 * @author 962
 *
 */
public final class RSAEncryption {

	/**
	 * ��ȡ��Կ��
	 * 
	 * @return 0Ϊ��Կ��1Ϊ˽Կ
	 * @throws NoSuchAlgorithmException
	 */
	public static String[] getKeyPair() throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(1024, new SecureRandom());
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
		String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
		return new String[] { publicKeyString, privateKeyString };
	}

	/**
	 * RSA��Կ����
	 * @param str ����
	 * @param publicKey ��Կ
	 * @return ��������
	 * @throws Exception
	 */
	public static String encrypt(String str, String publicKey) throws Exception {
		// base64����Ĺ�Կ
		byte[] decoded = Base64.decodeBase64(publicKey);
		RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA")
				.generatePublic(new X509EncodedKeySpec(decoded));
		// RSA����
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
		return outStr;
	}
	
	/**
	 * RAS˽Կ����
	 * @param str ����
	 * @param privateKey ˽Կ
	 * @return ��������
	 * @throws Exception
	 */
	public static String decrypt(String str, String privateKey) throws Exception {
		byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
		byte[] decoded = Base64.decodeBase64(privateKey);
		RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA")
				.generatePrivate(new PKCS8EncodedKeySpec(decoded));
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		String outStr = new String(cipher.doFinal(inputByte));
		return outStr;
	}
}