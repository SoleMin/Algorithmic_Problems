import java.util.Scanner;

public class R495A {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt(), k=scan.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) a[i]=scan.nextInt();
		int res=2;
		for(int i=0;i<n-1;i++) {
			if(a[i+1]-a[i]>2*k) res+=2;
			else if(a[i+1]-a[i]==2*k) res++;
		}
		System.out.println(res);
	}
}