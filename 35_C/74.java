import java.io.*;
import java.util.List;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem {
	
	public static Pair solve(Forest f, List<Pair> queue){
		Pair current = null, next = null;
		int index = 0;
		while(queue.size() > 0){
			current = queue.remove(0);
			index = f.desk[current.x][current.y];
				if(current.x>0){
					next = new Pair(current.x-1,current.y);
					if(f.desk[next.x][next.y]==0){
						f.desk[next.x][next.y] = index+1;
						queue.add(next);
					}
				}
				if(current.x<f.N-1){
					next = new Pair(current.x+1,current.y);
					if(f.desk[next.x][next.y]==0){
						f.desk[next.x][next.y] = index+1;
						queue.add(next);
					}
				}
				if(current.y>0){
					next = new Pair(current.x,current.y-1);
					if(f.desk[next.x][next.y]==0){
						f.desk[next.x][next.y] = index+1;
						queue.add(next);
					}
				}
				if(current.y<f.M-1){
					next = new Pair(current.x,current.y+1);
					if(f.desk[next.x][next.y]==0){
						f.desk[next.x][next.y] = index+1;
						queue.add(next);
					}
				}
		}
		return f.findMax();
	}

	public static void main(String[] args){
		String buffer = null;
		StringTokenizer st = null;
		Forest f = null;
		List<Pair> pairs = new LinkedList<Pair>();
		Integer N,M,K,x,y;
		try {
			BufferedReader in = new BufferedReader(
							new FileReader("input.txt")
							);
			FileWriter out = new FileWriter("output.txt");
			buffer = in.readLine();
			st = new StringTokenizer(buffer);
			N = new Integer(st.nextToken());
			M = new Integer(st.nextToken());
			f = new Forest(N,M);
			buffer = in.readLine();
			st = new StringTokenizer(buffer);
			K = new Integer(st.nextToken());
			buffer = in.readLine();
			st = new StringTokenizer(buffer);
			for(int i = 0; i<K; i++){
				x = new Integer(st.nextToken());
				y = new Integer(st.nextToken());
				f.desk[x-1][y-1] = 1;
				pairs.add(new Pair(x-1,y-1));
			}
			Pair res = solve(f,pairs);
			
			out.write(res.toString());
			out.flush();
		} catch (Exception e) {
		}
	}
}

class Pair {
	public Pair(int i, int j){
		x = i;
		y = j;
	}
	public String toString(){
		return (x+1) + " " + (y+1);
	}
	public int x;
	public int y;
}

class Forest {
	public Forest(int n, int m){
		N = n;
		M = m;
		desk = new int[N][M];
	}

	public Pair findMax(){
		Pair max = new Pair(0,0);
		for(int i = 0; i<N; i++){
			for(int j = 0; j<M; j++){
				if(desk[i][j]>desk[max.x][max.y]){
					max.x = i;
					max.y = j;
				}
			}
		}
		return max;
	}	

	public int N;
	public int M;
	public int[][] desk;
}
