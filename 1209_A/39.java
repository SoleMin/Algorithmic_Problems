
import java.util.Arrays;
import java.util.Scanner;

public class first {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] a=new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i]=s.nextInt();
		}
		Arrays.sort(a);
		int count=0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]!=0) {
				int x=a[i];
				count++;
				for (int j = i; j < a.length; j++) {
					if(a[j]%x==0) {
						a[j]=0;
					}
				}
			}
		}
		System.out.println(count);
	}

}
