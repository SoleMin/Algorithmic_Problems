import java.util.*;
public class Main{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int a[]={4,7,44,47,74,77,444,447,474,477,744,747,774,777};
		int n=in.nextInt();
		int i=0;
		boolean yes=false;
		while((i<14)&&(a[i]<=n)){
			if(n%a[i]==0){
				System.out.print("YES");
				yes=true;
				break;
			} i++;
		}
		if(!yes)
		System.out.print("NO");
	}
}