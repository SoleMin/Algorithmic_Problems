import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){	
			long i = input.nextInt();
			long j = input.nextInt();
			long maxlength=0,x,y;
			x=i;y=j;
			if(i>j){
				x=j;y=i;
			}
			for(long m =x;m<=y;m++){
				long n = m,length=1;
				while(n!=1){
					if((n&1)==1){
						n=3*n+1;
						length++;
					} while((n&1)!=1){
						n>>=1;
						length++;
					}
				}
				if(maxlength<length){
					maxlength=length;
				}
				
			}
			System.out.printf("%d %d %d\n",i,j,maxlength);		
		}
		
	}
}