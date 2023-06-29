import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scanner= new Scanner(System.in);
		int test = scanner.nextInt();
		scanner.nextLine();
		
		for(int t=0;t<test;t++){
			int n = scanner.nextInt();
			int[] speed = new int[n];
			int result = 0;
			
			for(int i=0;i<speed.length;i++){
				speed[i]=scanner.nextInt();
			}
			
			Arrays.sort(speed);
			
			if(n==0){
				result+=speed[0];
			}	else if(n==1){
				result+=speed[1];
			}	else if(n==2){
				result+=speed[0]+speed[1]+speed[2];
			} else if(n>2){
				int m;
				for(m=n-1;m>=3;m=m-2){
					
					int a = speed[1]*2+speed[0]+speed[m];
					int b = speed[0]*2+speed[m]+speed[m-1];
					
					if(a<b){
						result+=a;
					}else{
						result+=b;
					}
				}
					if(m==2){
						result+=speed[0]+speed[1]+speed[2];
					}else{
						result+=speed[1];
					}
				}
				
				System.out.println(result);
				System.out.println();
			}
			
		}
	
	
}