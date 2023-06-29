import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int t=input.nextInt();
		for (int i=0; i<t; i++){
			int n=input.nextInt();
			int p=input.nextInt();
			int[] day=new int[n+1];
			int cnt=0;
			for(int j=0; j<p; j++){
				int h=input.nextInt();
				int x=h;
				while(x<=n){
					if(!(x%7==6 || x%7==0 || day[x]==1)) {
						day[x]=1;
						cnt++;
					}
					x+=h;
				}
			}
			System.out.println(cnt);
		}
		input.close();
	}
}