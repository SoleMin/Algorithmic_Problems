import java.io.*;
import java.util.*;
class Main {
	static int n;
	static int[] ti=new int[1000];
	static int[] si=new int[1000];
	static int[] result=new int[1000];
	
	

	
	public static void main(String[] args) throws Exception {
		Scanner input=new Scanner(System.in);
		int i,j,t;
		t=input.nextInt();
		input.nextLine();
		input.nextLine();
		
		for(i=0;i<t;i++){
			
			n=input.nextInt();
			input.nextLine();
			for(int k=0;k<n;k++){
				ti[k]=input.nextInt();
				si[k]=input.nextInt();
				input.nextLine();
			}
				
				
			//버블 정렬
			
			for(int k=0;k<n;k++)
				result[k]=k;
			for(int k=1;k<n;k++){
				
				for(int p=0;p<n-k;p++){
					
					if(ti[result[p]]*si[result[p+1]]>ti[result[p+1]]*si[result[p]]){
						int temp=result[p];
						result[p]=result[p+1];
						result[p+1]=temp;				
					}
					
				}
			}
			
			
			
			if(i>0)
				System.out.println();
			for(j=0;j<n-1;j++)
				System.out.print(result[j]+1+" ");
			System.out.println(result[n-1]+1);
			
		}
		
		
	}
}