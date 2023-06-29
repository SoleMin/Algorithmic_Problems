import java.math.BigInteger;
import java.util.Scanner;

public class c {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		int rad = in.nextInt();
		
		int[] start = new int[num];
		for(int i=0; i<num; i++)
			start[i] = in.nextInt();
		
		// If you can hack doubles that's dumb
		double[] finalY = new double[num];
		double hyp = rad*2;
		
		for(int cur=0; cur<num; cur++){
			
			double stopAt = rad;
			for(int comp=0; comp<cur; comp++){
				if(Math.abs(start[comp]-start[cur]) > rad*2) continue;
				
				double base = Math.abs(start[comp]-start[cur]);
				double ny = Math.sqrt(hyp*hyp - base*base) + finalY[comp];
				
				stopAt = Math.max(ny, stopAt);
			}
			
			finalY[cur] = stopAt;
		}
		
		for(int i=0; i<num; i++)
			System.out.print(finalY[i]+" ");
		System.out.println();
	}

}
