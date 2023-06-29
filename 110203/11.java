import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		
		int t,n,p,i,j;
		int[] h = null;
		
		Scanner input= new Scanner(System.in);
		t =Integer.parseInt(input.nextLine());
		
		
		while(t!=0){
			int date=0;
			n = Integer.parseInt(input.nextLine());
			p = Integer.parseInt(input.nextLine());
			h= new int[p];
			for(i=0;i<p;i++){
				h[i]=Integer.parseInt(input.nextLine());
			}
			
			for(i=0;i<n+1;i++){
				if(i%7!=6 && i%7!=0){
					for(j=0;j<p;j++){
						if(i%h[j]==0){
							date++;
							break;
						}
					}
				}
			}
			System.out.println(date);
			
			t--;
		}
	}
}