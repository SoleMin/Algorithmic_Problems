import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(System.out);
			
			String[] param = br.readLine().split(" ");
			long n = Long.parseLong(param[0])-1;
			long k = Long.parseLong(param[1])-1;
			long max = k*(k+1)/2;
			long answer;
			if (n > max) answer = -1;
			else {
				long margin = max - n;
				long m = Math.max(0,(long)Math.floor((1.0+Math.sqrt(1+8*margin))/2.0)-1);
				long min = m*(m+1)/2;
				while (min <= margin) { m++; min = m*(m+1)/2; }
				answer = k - m + 1;
			}
			pw.println(answer);
			
			pw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
}