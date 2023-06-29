import java.io.*;
import java.util.*;
 

public class Main {
	
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader kek = new BufferedReader(new InputStreamReader(System.in));
		//Scanner skek = new Scanner(System.in);
		PrintWriter outkek = new PrintWriter(System.out);

		String[] input = kek.readLine().split(" ");
		double A = Integer.parseInt(input[0]), V = Integer.parseInt(input[1]);
		input = kek.readLine().split(" ");
		double L = Integer.parseInt(input[0]), D = Integer.parseInt(input[1]), W = Integer.parseInt(input[2]);
		
		double res = 0.0;
		double[] pair = new double[2];
		pair[0] = W / A;
		pair[1] = 0.5 * A * (pair[0] * pair[0]);
		
		if(V <= W || pair[1] >= D){
			res = compute(0, A, V, L);
		} else {
			res += pair[0];
			res += 2.0 * compute(W, A, V, (D - pair[1]) / 2.0);
			res += compute(W, A, V, L - D);	
		}
		
		outkek.println(res);
		
		kek.close();
		outkek.close();
	}	
	
	static double compute(double temp, double A, double V, double L){
		
		double[] pair = new double[2];
		pair[0] = (V - temp) / A;
		pair[1] = 0.5 * A * (pair[0] * pair[0]) + temp * pair[0];
		
		if(pair[1] >= L){
			  double t = Math.sqrt((temp * temp) + 2.0 * A * L);
			  if(t <= 0){
				  t *= -1.0;
			  }
			  return (t - temp) / A;
		} else {
			return pair[0] + (L - pair[1]) / V;
		}
	}
		
}
