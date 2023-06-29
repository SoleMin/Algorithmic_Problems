
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sun.imageio.plugins.common.InputStreamAdapter;

public class Main {

	public static void main(String[] args) throws IOException {
		int n,a,b;
		long counter;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String in = reader.readLine();
		n = Integer.parseInt(in);
		for(int i=0;i<n;i++){
			in = reader.readLine();
			String[] sp = in.split(" ");
			a = Integer.parseInt(sp[0]);
			b = Integer.parseInt(sp[1]);
			counter = 0;
			while(a!=0 && b!=0){
				if(Math.max(a, b)% Math.min(a, b) == 0){
					counter+= Math.max(a, b)/Math.min(a, b);
					break;
				}
				else{
					counter+= Math.max(a, b)/Math.min(a, b);
					if(a>=b){
						a = a-Math.max(a, b)/Math.min(a, b)*b;
					}
					else{
						b = b-Math.max(a, b)/Math.min(a, b)*a;
					}
				}
			}
			System.out.println(counter);
		}
	}

}
