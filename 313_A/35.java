import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

			int n = Integer.parseInt(str);
			int ans = 0;
			if(n>=0) {
				ans = n;
			} else {
				 if ( str.length()==2) {
					if(str.charAt(0)!='-') {
						int a  =Integer.parseInt(str.substring(0,1));
						int b = Integer.parseInt(str.substring(1,2));
						ans = Math.max(a, b);
					} else {
						ans = Integer.parseInt(str.substring(1,2));
					}
				} else {
					String s1 = str.substring(0,str.length()-2).concat(str.substring(str.length()-2,str.length()-1));
					String s2 = str.substring(0,str.length()-2).concat(str.substring(str.length()-1,str.length()));
					int a = Integer.parseInt(s1);
					int b = Integer.parseInt(s2);
					ans = Math.max(a, b);
				}
			}
			bos.write(new Integer(ans).toString().getBytes());
			bos.write(eolb);
			bos.flush();
		}  catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
