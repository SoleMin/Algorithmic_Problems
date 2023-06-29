import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int ts = scan.nextInt();
		
		for(int i=0; i<ts; i++)
		{
			int n = scan.nextInt();
			int[] dis = new int[n];
			for(int z=0; z<n; z++) dis[z] = scan.nextInt();
			Arrays.sort(dis);
			scan.nextLine();
			
			if(dis.length % 2 == 0)
			{
				float mid = dis.length/2;
				int mid1_idx = (int)Math.ceil(mid);
				int mid2_idx = (int)Math.floor(mid);
				int mid1 = dis[mid1_idx];
				int mid2 = dis[mid2_idx];
				int sum1 = 0; int sum2 = 0;
					
				for(Integer k : dis)
				{
					if(k == mid1) {
						sum2 += Math.abs(mid2 - k);
						continue;
					} 
					if(k == mid2) {
						sum1 += Math.abs(mid1 - k);
						continue;
					}
						
					sum1 += Math.abs(k-mid1);
					sum2 += Math.abs(k-mid2);
				}
					
				if(sum1 > sum2) System.out.println(sum2);
				else System.out.println(sum1);
			} else {
				int mid_idx = (int)(dis.length/2);
				int mid = dis[mid_idx];
				int sum = 0;
				for(Integer k : dis)
				{
					sum += Math.abs(mid-k);
				}
					
				System.out.println(sum);
			}
			
		}
	}
}