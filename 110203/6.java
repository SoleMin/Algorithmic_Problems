import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc= new Scanner(System.in);
		
		int caseNumber = sc.nextInt();
		
		for(int i=0;i<caseNumber;i++){
			int n=sc.nextInt();
			int p=sc.nextInt();
			int count =0;
			int[] pArray = new int[p];
			for(int j=0;j<p;j++){
				pArray[j]=sc.nextInt();
			}
			for(int j=1; j<=n;j++){
				if(j%7==6||j%7==0);
				else
					for(int k=0; k<p;k++)
						if(j%pArray[k]==0){
							count++;
							break;
						}
			}
			System.out.println(count);
		}
	}
}