import java.util.*;

public class code_1 {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		int n=in.nextInt();
		
		int a[]=new int[n];
		
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		
		Arrays.sort(a);
		
		for(int i=0;i<n-1;i++) {
			
			if(a[i]!=-1) {
				for(int j=i+1;j<n;j++) {
					
					if(a[j]%a[i]==0)
						a[j]=-1;
				}
			}	
		}
		
		int count=0;
		
		for(int i=0;i<n;i++) {
			
			if(a[i]!=-1)
				count++;
		}
		
		System.out.println(count);

	}

}
