
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class RationalResistance {
	public static void main(String args[]) throws IOException{
		BufferedReader f= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st=new StringTokenizer(f.readLine());
		long a=Long.parseLong(st.nextToken());
		long b=Long.parseLong(st.nextToken());
		long sum = 0;
		while(a!= 0 && b!= 0){
			if (a > b){
				long val = a / b;
				sum += val;
				a -= val * b;
			}
			else{
				long val = b / a;
				sum += val;
				b -= val * a;
			}
		}
		
		out.println(sum);
		out.close();
		System.exit(0);
	}
	
}
