import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String [] args ) {
		try{
			String str;			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedOutputStream bos = new BufferedOutputStream(System.out);
			String eol = System.getProperty("line.separator");
			byte [] eolb = eol.getBytes();
			byte[] spaceb= " ".getBytes();
		
			str  = br.readLine();
			int blank = str.indexOf( " ");
			long l = Long.parseLong(str.substring(0,blank));
			long r = Long.parseLong(str.substring(blank+1));
			String one = "";
			String two = "";
			while(l>0) {
				if((l%2)==0) {
					one = "0".concat(one);
				} else {
					one = "1".concat(one);
				}
				l/=2;
			}
			while(r>0) {
				if((r%2)==0) {
					two = "0".concat(two);
				} else {
					two = "1".concat(two);
				}
				r/=2;
			}
			while(one.length()<60) {
				one = "0".concat(one);
			}
			while(two.length()<60) {
				two = "0".concat(two);
			}
			int iter = 0;
			String xor = "";
			boolean big = false;
			boolean small = false;
			while(one.charAt(iter) == two.charAt(iter)) {
				xor = xor.concat("0");
				iter++;
				if(iter==60) {
					break;
				}
			}
			for(int i = iter ; i < 60 ; i++) {
				xor = xor.concat("1");
			}
			bos.write(new BigInteger(xor,2).toString().getBytes());
			bos.write(eolb);
			bos.flush();
		}  catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
