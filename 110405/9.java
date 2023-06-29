import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int i,j;
		int temp;
		int caseNum= input.nextInt();
		//1System.out.println(caseNum);
		while(caseNum!=0) {
			String s= input.nextLine();
			
			int n= input.nextInt();
			int[] ti =new int[n];
			int[] si= new int[n];
			int[] result = new int[n];
			
			for(i=0;i<n;i++) {
				ti[i]= input.nextInt();
				si[i]=input.nextInt();
				result[i]=i;
			}
			//for(i=0;i<n;i++)
				//System.out.println(ti[i]+" "+si[i]);
			
			for(i=1;i<n;i++) {
				for(j=0;j<n-i;j++) {
					if(ti[result[j]]*si[result[j+1]] >  ti[result[j+1]]*si[result[j]]) {
						temp=result[j];
						result[j]=result[j+1];
						result[j+1]=temp;
					}
				}
			}
			
			for(i=0;i<n;i++) 
				System.out.print((result[i]+1)+" ");
			System.out.println();
			if(caseNum>1)
				System.out.println();
			caseNum--;
		}
	}
}