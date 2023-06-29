import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
			
		while(input.hasNext()) {
			int i=input.nextInt();
			int j=input.nextInt();
			int l=i;
			int u=j;
			
			if (i>j){
				int temp=i;
				i=j;
				j=temp;
			}
			
			int max=0;
			for (int k=i; k<=j; k++){
				int cnt=1;
				long x=k;
				while(x!=1){
					if (x%2!=0){
						x=x*3+1;
						cnt++;
					}
					while(x%2==0){
						x/=2;
						cnt++;
					}
				}		
				if (max<cnt){
					max=cnt;
				}
			}
			System.out.println(l+" "+u+" "+max);
		}
		input.close();
	}

}