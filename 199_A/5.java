import java.util.Scanner;

public class A{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int prev2=0;
		int prev1=1;
		int prev=1;
		int curr = 2;
		if(n == 0) {System.out.println("0 0 0"); return;}
		else if(n == 1) {System.out.println("0 0 1");return;}
		while(true){
			if(curr == n) break;
			prev2 = prev1;
			prev1 = prev;
			int temp = prev + curr;
			prev = curr;
			curr = temp;
		}
		System.out.println(prev2 + " " + prev1 + " " + prev1);
	}
}
