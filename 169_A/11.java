import java.util.*;

// VK Cup 2012 Round2 Unofficial Div2 Edition
public class Main {
	
	void A(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int[] h = new int[n];
		for(int i=0; i<n; i++){
			h[i] = sc.nextInt();
		}
		Arrays.sort(h);
		System.out.println(h[b]-h[b-1]);
	}
	
	public static void main(String[] args) {
		new Main().A();
	}
}
