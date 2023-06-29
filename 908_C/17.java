import java.util.*;
public class C {
	
	public static void main(String[] args) {
		Scanner qwe = new Scanner(System.in);
		int n = qwe.nextInt();
		double r = qwe.nextDouble();
		
		double[] fy = new double[n];
		Arrays.fill(fy, r);
		
		double[] xs = new double[n];
		for (int i = 0; i < xs.length; i++) {
			xs[i] = qwe.nextDouble();
		}
		
		for(int i =0; i < n; i++){
			
			for(int j = i+1; j < n; j++){
				double dx = xs[j]-xs[i];
				if(Math.abs(dx) > 2*r) continue;
				fy[j] = Math.max(fy[j], Math.sqrt(4*r*r-dx*dx)+fy[i]);
			}
			
		}
		
		StringBuilder stb = new StringBuilder();
		for (int i = 0; i < xs.length; i++) {
			stb.append(fy[i]+" ");
		}
		System.out.println(stb);
	}

}
