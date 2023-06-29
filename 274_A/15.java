import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

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
			int n = Integer.parseInt(str.substring(0,blank));
			int m = Integer.parseInt(str.substring(blank+1));
			long [] num = new long[n];
			int j=0;
			int s=0;
			int k =0;
			str = br.readLine();
			int length = str.length();
			while(j<length) {
				while(j<length) {
					if(str.charAt(j) == ' ') {
						break;
					}else {
						j++;
					}
				}
				num[k] = Long.parseLong(str.substring(s,j)) ;
				k++;
				j++;
				s=j;			
			}
			Arrays.sort(num);
			int count = 0;
			if(m==1) {
				count = 1;
				for(int i = 1 ; i < n ; i++) {
					if(num[i]!=num[i-1]) {
						count++;
					} 
				}
			} else {
				TreeSet<Long> take = new TreeSet<Long>();
				TreeSet<Long> notTake = new TreeSet<Long>();
				for(int i = 0 ; i < n ; i++) {
					long temp = num[i];
					if(!notTake.contains(temp)){
						take.add(temp);
						temp *= ((long)m);
						notTake.add(temp);
					}
					
				}
				count = take.size();
			}
			bos.write(new Integer(count).toString().getBytes());
			bos.write(eolb);
			bos.flush();
		}  catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
