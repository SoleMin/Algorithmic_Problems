import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while(true){
			int n = scanner.nextInt();
			scanner.nextLine();
			if(n==0){
				break;
			}
			
			int l = scanner.nextInt();
			scanner.nextLine();
			
			int edge[][] = new int[n][n];
			int node[] = new int[n];
			
			for(int i =0; i<l ;i++){
				int s = scanner.nextInt();
				int d = scanner.nextInt();
				scanner.nextLine();
				edge[s][d]=1;
				edge[d][s]=1;
			}
			boolean visit = true;
			
			ArrayList<Integer> queue = new ArrayList<>();
			queue.add(0);
			node[0]=1;
			while(!queue.isEmpty()){
				int tmp = queue.remove(0);
				for(int i=0;i<n;i++){
					if(edge[tmp][i]==1 && node[i]==0){
						if(node[tmp]==2)
							node[i] =1;
						else if(node[tmp]==1)
							node[i] = 2;
						queue.add(i);

					}
					if(edge[tmp][i]==1 &&node[i] > 0 &&node[i] == node[tmp])          
							visit = false;
					}  
			}
			
			if(visit)
				System.out.println("BICOLORABLE.");
			else
				System.out.println("NOT BICOLORABLE.");
		}
	}
}