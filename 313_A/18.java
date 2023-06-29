import java.util.Scanner;


public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account acnt = new Account();
		acnt.solve();
		acnt.print();
	}

}

class Account {
	
	Account() {
		Scanner scr = new Scanner(System.in);
		n = scr.nextInt();
	}
	
	void solve() {
		if (n > 0) {
			ans = n;
		}
		else {
			int nn = -n;
			int ans1 = nn/10;
			int ans2 = nn % 10 + (nn/100)*10;
			if (ans1 < ans2){
				ans = -ans1;
			}
			else {
				ans = -ans2;
			}
		}
		
	}
	
	void print(){
		System.out.println(ans);
	}
	
	int ans;
	int n;
}