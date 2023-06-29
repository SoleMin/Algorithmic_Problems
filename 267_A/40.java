import java.util.*;
public class substraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while (t>0) {
			long a=sc.nextLong();
			long b=sc.nextLong();
			int op=0;
			if (a>b) {
				while (a%b!=0) {
					op+=a/b;
					a=a%b;
					long c=b;
					b=a;
					a=c;					
				}
				op+=a/b;
			}
			else{
				while (b%a!=0) {
					op+=b/a;
					b=b%a;
					long c=a;
					a=b;
					b=c;					
				}
				op+=b/a;
			}
			
			
			System.out.println(op);
			t--;
		}

	}

}
