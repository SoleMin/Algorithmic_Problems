import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GB17C {
	public static void main(String[] args) throws NumberFormatException, IOException {
			
			BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
			
			String[] dir = sc.readLine().split(" ");
			int n = Integer.parseInt(dir[0]);
			int r = Integer.parseInt(dir[1]);
			
			String[] t = sc.readLine().split(" ");
			int[] list = new int[n];
			for(int x=0; x<n; x++){
				list[x] = Integer.parseInt(t[x]);
			}
			
			double[] yCoords = new double[n];
			
			for(int x=0; x<n; x++){
				double stop = (double)r;
				int dist = 2*r;
				int xCoordNew = list[x];
				
				
				for(int y=0; y<x; y++){
					
					int xCoordOld = list[y];
					if(Math.abs(xCoordNew - xCoordOld) == dist){
						stop = Math.max(stop, yCoords[y]);
					}
					else if(Math.abs(xCoordNew - xCoordOld) < dist){
						double extra = Math.pow((double)(dist*dist) - (double)((xCoordNew - xCoordOld)*(xCoordNew - xCoordOld)), 0.5);  
						
						stop = Math.max(stop, yCoords[y] + extra);
					}
				}
				
				yCoords[x] = stop;
				System.out.print(stop+" ");
			}
			
			
	}
}


/* 

BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

int n = Integer.parseInt(sc.readLine());
String[] t = sc.readLine().split(" ");
int[] list = new int[n];
for(int x=0; x<n; x++){
	list[x] = Integer.parseInt(t[x]);
}
		
String[] dir = sc.readLine().split(" ");
int a = Integer.parseInt(dir[0]);
int b = Integer.parseInt(dir[1]);
int c = Integer.parseInt(dir[2]);
int d = Integer.parseInt(dir[3]);
int e = Integer.parseInt(dir[4]);

int n = Integer.parseInt(sc.readLine());

*/