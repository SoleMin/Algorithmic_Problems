import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input =new Scanner (System.in);
		
		int[] a=new int[1000000];
		a[1]=1;
		a[2]=2;
		
		while(true){
			int n=input.nextInt();
			if(n==0)
				break;
			
			int j=1;
			int result=3;
			int x=0;
			while(a[j]<n){
				j++;
				for(int i=1; i<j; i++){
					if(a[i]>=j){
						x=i;
						break;
					}
				}
				result+=x;
				a[j]=result;
			}
			System.out.println(j);
		}

		input.close();
	}
}