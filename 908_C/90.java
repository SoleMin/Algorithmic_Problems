import java.util.Scanner;

public class C {
  public static void main (String args[]) {
    Scanner in = new Scanner(System.in);
    
    int n = in.nextInt();
    int r = in.nextInt();
    
    double pos[][] = new double[n][2];
    
    for(int i = 0; i < n; i++) {
    	
    	pos[i][0] = in.nextInt();
    	
    	double y = r;
    	
    	for(int j = 0; j < i; j++) {
    		if(Math.abs(pos[i][0] - pos[j][0]) <= 2*r) {
    			
    			double tempy = pos[j][1] + Math.sqrt(Math.pow(2*r, 2) - Math.pow(Math.abs(pos[i][0] - pos[j][0]), 2));
    			
    			if(tempy > y) y = tempy;
    		}
    	}
    	
    	pos[i][1] = y;
    	System.out.print(y + " ");
    }
  }
}