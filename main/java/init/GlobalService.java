package init;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class GlobalService {
	//DB
	public static final String JNDI_DB_NAME = "java:comp/env/jdbc/Belle_ReverServer";
	
	public static String getJndiDbName() {
		return JNDI_DB_NAME;
	}

	// 判斷輸入只能是 大小寫數字
	public static boolean judgeInput(String str) {
			boolean b = false;
			if (str.length() != 0) {
				for (int i = 0; i < str.length(); i++) {
					Integer num = Integer.valueOf(str.charAt(i));
					if ((num >= 49 && num <= 57) || (num >= 91 && num <= 122) || (num >= 65 && num <= 90) || num == 95) {
						b = true;
					} else {
						b = false;
					}
				}
			} else {
				b = false;
			}
			return b;
		}
	static String KEY = "acegiklmprtvxzbd";
	public static String encryptString(String message) {
		// DES : Data Encryption Standard, 一種對稱式加密演算法。
		// 美國聯邦政府於1976年定為聯邦資料處理標準(FIPS)，它的
		// 金鑰則必須是7個位元組、加密區塊(Cipher Block)固定為8個位元組。
		// DES目前已被視為是一種不安全的演算法。
		// AES : Advanced Encryption Standard, 一種對稱式加密演算法。
		// (美國聯邦政府於2001年納入FIPS 140-2標準)，此種演算法
		// 的Cipher Block固定為16個位元組。金鑰則必須是16個位元組、
		// 24個位元組或32個位元組(即128個位元、192個位元或256個位元)。
		// ECB : Electronic CookBook, 一種資料的加密方式，這種加密方式採取
		// 每個區塊(如8個或16個位元組)獨立加密，即加密任ㄧ區塊時與其它區塊
		// 無關。獨立壓縮有優點也有缺點。
		// 優點為可以由多個處理器來平行處理ㄧ個很大的資料。缺點為如果資料
		// 的內容有重複出現的部分，而且重複資料的長度剛好與加密區塊等長，
		// 則這些重複出現的部分經過加密後會出現相同的結果。
		// PKCS5Padding: 如果要加密的資料不是8個(如DES加密演算法)或
		// 16個(如AES加密演算法)位元組的整數倍，則必須在欲加密資料的
		// 尾端加入若干個位元組來湊成整數倍。PKCS5Padding是一種
		// 補足不足位元組的方法。
		String encryptedString = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			encryptedString = DatatypeConverter.printBase64Binary(cipher.doFinal(message.getBytes()));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return encryptedString;
	}
	
	
	// 判斷特輸符號 有特殊符號傳回false
		public static boolean judgeInputSpecialSymbol(String str) {
			boolean b = false;
			if (str.length() != 0) {
				for (int i = 0; i < str.length(); i++) {
					Integer num = Integer.valueOf(str.charAt(i));
					if ((num >= 32 && num <= 47) || (num >= 58 && num <= 64) || (num >= 91 && num <= 94)
							|| (num >= 123 && num <= 126) || num == 96) {
						b = false;
					} else {
						b = true;
					}
				}
			} else {
				b = false;
			}
			return b;
		}
	
}