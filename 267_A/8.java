import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF267A {

	public static void main(String[] args) {
		int n=0, a, b;
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		try {
			n = Integer.parseInt(stdin.readLine());
		} catch (IOException e) {
		}
		while(n-->0){
			String[] row = null;
			try {
				row = stdin.readLine().split(" ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a = Integer.parseInt(row[0]);
			b = Integer.parseInt(row[1]);
			if(a<b) System.out.println(calc(a,b));
			else System.out.println(calc(b,a));
		}
	}
	
	static int calc(int a, int b){
		if(a==0) return 0;
		if(a==b) return 1;
		if(a==1) return b;
		else return b/a+calc(b%a, a);
	}

}
