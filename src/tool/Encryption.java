package tool;

import java.security.MessageDigest;

public class Encryption {
	static MessageDigest messageDigest = null;

	public static String hmacSign(String str) {
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (Exception e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();
		// StringBuffer md5StrBuff = new StringBuffer();
		String md5StrBuff = new String();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
				md5StrBuff += "0";
				md5StrBuff += Integer.toHexString(0xFF & byteArray[i]);
			} else
				md5StrBuff += Integer.toHexString(0xFF & byteArray[i]);
		}
		return md5StrBuff.toString();
	}
/*
	public static void main(String[] args) {
		Encryption md5 = new Encryption();
		System.out.println(md5.hmacSign("刘涵静"));
	}*/
}
