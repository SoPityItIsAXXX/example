package com.example.service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example_utils.encryption.RSAEncryption;

/**
 * 处理 注册/登录 时需要加密的service层
 * @author 962
 *
 */
@Service
public class CheckInEncryptionService {
	
	/**
	 * 向浏览器发送公钥并将私钥存入session，key分别为username和password
	 * @param session 当前用户的session
	 * @return 返回公钥，0为username的公钥 1为password的公钥
	 */
	public String[] sendPublicKey(HttpSession session) {
		String[] usernamePair = new String[2];
		String[] passwordPair = new String[2];
		String[] publicKeys = null;
		
		try {
			usernamePair = RSAEncryption.getKeyPair();
			passwordPair = RSAEncryption.getKeyPair();
			publicKeys = new String[] { usernamePair[0], passwordPair[0] };
			session.setAttribute("username", usernamePair[1]);
			session.setAttribute("password", passwordPair[1]);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return publicKeys;
	}
}
