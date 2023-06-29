import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int x,n,p,l,k;
		int h[] = new int [100];
		x = input.nextInt();
		while(x-->0)
		{
			l = 0;
			n = input.nextInt();
			p = input.nextInt();
			for(int i=0; i<p; i++)
				h[i] = input.nextInt();
			l=0;
			
				for(int j=1; j<=n; j++)
					if((j-1) % 7 <5)
						for(k=0; k<p; k++)
							if(j%h[k]==0){
								l++;
								break;
							}
				System.out.print(l+"\n");
			
			
		}
	}
}