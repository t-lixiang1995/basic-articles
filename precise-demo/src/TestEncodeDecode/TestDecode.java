package TestEncodeDecode;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class TestDecode {

	 public static void main(String[] args) throws UnsupportedEncodingException{	
		String code = "AGV5IULSB3ZLVSE=";
		
		 /*byte[] textByte= code.getBytes("UTF-8");;
		 final Base64.Encoder encoder = Base64.getEncoder();
		 String decode = encoder.encodeToString(textByte);*/
		
		 /*final Base64.Decoder decoder = Base64.getDecoder();
		 byte[] encode = decoder.decode(code);
		 String decode = new String(encode);*/
		
		String decode = decode(code);
		System.out.println(decode);
		
	 }
	
	static String decode(String code){
		
		final Base64.Decoder decoder = Base64.getDecoder();
		StringBuffer sendContent = new StringBuffer();
		for(int i=0;i<code.length();i++){
			String a = code.substring(i, i+1);
			System.out.println(a);
			byte[] encode = decoder.decode(a);
			String test =new String(encode);
			System.out.println("---------"+test);
			//char c = (char) (((encode[i] & 0xFF) << 8) | (encode[i+1] & 0xFF));
			char c = (char) (((encode[i] & 0xFF) << 8));
			String item;
			if(c>127){
				String lowStr = a.toLowerCase();
				System.out.println(lowStr);
				byte[] encodeLowStr = decoder.decode(lowStr);
				item = new String(encodeLowStr);
			}
			else{
				item = new String(encode);
			}
			sendContent.append(item);

		}
		return sendContent.toString();
	}
}
