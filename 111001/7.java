import java.io.*;
import java.util.*;

class Main {
	
	public static double distance(int a, int b, double [][]freckles){
		double d ;
		//System.out.println(d);
		d=Math.pow(freckles[a][0]-freckles[b][0],2)+Math.pow(freckles[a][1]-freckles[b][1],2);
	//	System.out.println(d);
		d = Math.sqrt(d);
		//System.out.println(d);
		return d;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		
		int testcase = scanner.nextInt();
		scanner.nextLine();
		
		for(int test =0; test<testcase;test++){
			scanner.nextLine();
			int n = scanner.nextInt();
			scanner.nextLine();
			
			double result=0.0;
			double [][]freckles = new double[n][2];
			double min[] = new double[n];
			boolean inTree[]= new boolean[n];
			
			for(int i=0; i<n; i++){
				freckles[i][0] = scanner.nextDouble();
				freckles[i][1] = scanner.nextDouble();			
				//scanner.nextLine();
			}
			//System.out.println(Arrays.toString(freckles[0]));
			inTree[0] = true;
			for(int i=1; i<n;i++)
				min[i]=distance(0,i,freckles);
			
			
			for(int i=0; i<n-1;i++){
				int next = -1;
				for(int j=0; j<n; j++){
					
					if(inTree[j])
						continue;
					if(next==-1||min[next]>min[j])
						next=j;
				}
				result+= min[next];
				inTree[next] = true;
				
				for(int j=0; j<n; j++){
					if(inTree[j])
						continue;
					double dis = distance(next, j,freckles);
					if(min[j]>dis)
						min[j]=dis;
				}
			}
			
			
			System.out.println(String.format("%.2f",result));
			System.out.println("");
		}
	}
}