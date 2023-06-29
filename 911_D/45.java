
import java.util.Scanner;

public class inversion__count {

	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		
		int n=s.nextInt();
		
		int[] a = new int[n+1];
		
		for(int i=1;i<=n;i++){
			a[i]=s.nextInt();
		}
		
		int m=s.nextInt();
		int count=0;
		
		for(int i=1;i<=n;i++){
			for(int j=i+1;j<=n;j++){
				if(a[i]>a[j]){
					count++;
				}
			}
		}
		
		if(count%2==0){
			count=0;
		}else{
			count=1;
		}
		
		//System.out.println(count);
		for(int i=0;i<m;i++){
			int l=s.nextInt();
			int r=s.nextInt();
			
			if(l==r){
				if((count&1)==1){
					System.out.println("odd");
				}else{
					System.out.println("even");
				}
				continue;
			}
			
			 int d=r-l+1;
			 int segcount = 0;
			 
			
			 
			int  temp =   (d*(d-1))/2; 
			 
			 if((temp&1)==1 && (count&1)==1){
				 count=0;
				 System.out.println("even");
			 }else if((temp&1)==1 && (count&1)==0){
				 count=1;
				 System.out.println("odd");
			 }else{
				 if((count&1)==1){
					 System.out.println("odd");
				}else{
					System.out.println("even");
				}
			 }
		}
	}
}
