import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input=new Scanner(System.in);
		
		while(input.hasNext()){
			int n=input.nextInt();
			int[] a=new int[n];
			int[] present=new int[n];
			boolean jolly=true;
			
			for(int i=0; i<n; i++){
				a[i]=input.nextInt();
			}
			for(int j=0; j<n-1; j++){
				int diff=Math.abs(a[j]-a[j+1]);
				if(diff<1 || diff>n-1 || present[diff]>0) {
					jolly=false;
					break;
				}
				present[diff]=1;
			}
			
			if (jolly)
				System.out.println("Jolly");
			else
			System.out.println("Not jolly");
		}
		input.close();
	}
}