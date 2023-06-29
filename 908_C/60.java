import java.io.*;
import java.util.*;

public class ProblemA {
	public static void main(String[] args) throws Exception{
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(bf.readLine());
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int[] xcoords = new int[n];
			for(int i = 0;i<n;i++){
				xcoords[i] = Integer.parseInt(st1.nextToken());
			}
			double[] ycoords = new double[n];
			
			for(int i = 0;i<n;i++){
				ArrayList<Integer> nodes = new ArrayList<Integer>();
				for(int j = 0;j<i;j++){
					if (Math.abs(xcoords[j] - xcoords[i]+0.0) <= 2*r)
						nodes.add(j);
				}
				if (nodes.isEmpty()){
					ycoords[i] = r;
					continue;
				}
				else{
					double min = -1;
					for(int k = 0;k<nodes.size();k++){
						double tmp = ycoords[nodes.get(k)] + Math.sqrt(4*r*r - (xcoords[i] - xcoords[nodes.get(k)])*(xcoords[i] - xcoords[nodes.get(k)]));
						if (tmp > min){
							min = tmp;
						}
					}
					ycoords[i] = min;
				}
			}
			for(int i = 0;i<ycoords.length;i++){
				System.out.print(ycoords[i] + " ");
			}
			
	}
}