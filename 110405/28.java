import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan= new Scanner(System.in);

			int N=scan.nextInt();
		
			
			for(int i=0;i<N;i++){
				scan.nextLine();
				
				int num=scan.nextInt();
				scan.nextLine();
				
				int[] T=new int[num];
				int[] S=new int[num];
				int[] temp=new int[num];
				
				for(int j=0;j<num;j++){
					T[j]=scan.nextInt();
					S[j]=scan.nextInt();
					temp[j]=j;
				}
				
				for(int a=1;a<num;a++){
					for(int b=0;b<num-a;b++){
						if(T[temp[b]]*S[temp[b+1]]>T[temp[b+1]]*S[temp[b]]){
							int temp1=temp[b];
							temp[b]=temp[b+1];
							temp[b+1]=temp1;
						}
					}
				}
				for(int y=0;y<num;y++){
					System.out.print((temp[y]+1)+" ");
				}
				System.out.println("");
				if(i<N){
					System.out.println("");
				}
			}	
		}
	
}