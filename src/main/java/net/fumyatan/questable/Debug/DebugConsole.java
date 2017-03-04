package net.fumyatan.questable.Debug;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import net.fumyatan.questable.Questable;

public class DebugConsole {

	private static boolean debug = Questable.debug;

	// デバッグ用のソースを配置
	private static String PASSWORD = "E3D1663327A68DC5E215DAF38CEAFB1AAE5118AB76D82EFA167CF2C95313F6B3";

	private static boolean authePassword(String password){
		byte[] input_byte;

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			input_byte = md.digest();
			StringBuilder sb = new StringBuilder(2 * input_byte.length);
			for(byte b: input_byte) {
				sb.append(String.format("%02x", b&0xff) );
			}

			if (sb.equals(PASSWORD.toLowerCase())){
				return true;
			}
			return false;
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			if (debug)
				e.printStackTrace();
		}
		return false;
	}
}
