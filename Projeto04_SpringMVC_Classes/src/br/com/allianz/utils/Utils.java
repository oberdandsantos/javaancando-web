package br.com.allianz.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Utils {

	public static String verificarMD5(String texto) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(texto.getBytes(),0,texto.length());
			return new BigInteger(1,m.digest()).toString(16);
		} catch (Exception e) {
	    return null;
		}

	}

}
