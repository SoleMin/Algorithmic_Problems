import java.util.*;


public class Main {
	private static Scanner in = new Scanner(System.in);
	public static void main(String args[]){
		int n = in.nextInt();
		String s = in.next();
		if(n==1)
			System.out.println("1");
		else{
			int j=0,i=1,ans=s.length();
			int h[]=new int[128];
			h[(int)s.charAt(0)]=1;
			while(i<n){
				if(h[(int)s.charAt(i)]==0)
					ans = i-j+1;
				h[(int) s.charAt(i)]++;
				while(j<i && h[(int)s.charAt(j)]>1){
					h[(int)s.charAt(j)]--;
					j++;
					ans = Math.min(ans, i-j+1);
				}
				i++;
			}
			System.out.println(ans);
		}
	}
}
