import java.io.*;
import java.util.*;

class Main {
	static int w_cnt;
	static int b_cnt;
	static int w_size;
	static int b_size;
	static int size;
	static int[] diag_y = {-1,-1,1,1};
	static int[] diag_x = {-1,1,-1,1};
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		List<String> info = new ArrayList<>();
		
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			
			if(s.equals("0 0")) 
				break;
			
			info.add(s);
			
		}
		
		for(String s : info) {
			String[] str = s.split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			size = n-1;
			
			w_cnt = 0;
			b_cnt = 0;
			

			int count = 0;
			
			for(int i = 0; i <= k; i++) {
				boolean[][] visited = new boolean[n][n];
				
				b_size = i;
				w_size = k-i;
				
				black_search(visited,0,0,0);
				white_search(visited,0,1,0);
				count += (b_cnt * w_cnt);
				
				b_cnt = 0;
				w_cnt = 0;
			}
			
			System.out.println(count);
		}
	}
	
	public static void black_search(boolean[][] visited, int y, int x, int cnt) {
		
		
		if(cnt == b_size) {
			if(b_size == 0) {
				b_cnt = 1;
				return;
			}
			else {
				b_cnt++;
				return;
			}
		}
		
		if(x > size) {
			y += 1;
			x = (y%2 == 0)? 0:1;
		}
		
		if(y > size)
			return;
		
		if(isAble(visited,y,x)) {
			visited[y][x] = true;
			black_search(visited,y,x+2,cnt+1);
			visited[y][x] = false;
		}
		
		black_search(visited,y,x+2,cnt);
	}
	
	public static void white_search(boolean[][] visited, int y, int x, int cnt) {
		
		
		if(cnt == w_size) {
			if(w_size == 0) {
				w_cnt = 1;
				return;
			}
			else {
				w_cnt++;
				return;
			}
		}
		
		if(x > size) {
			y += 1;
			x = (y%2 == 0)? 1:0;
		}
		
		if(y > size) 
			return;
		
		if(isAble(visited,y,x)) {
			visited[y][x] = true;
			white_search(visited,y,x+2,cnt+1);
			visited[y][x] = false;
		}
		
		white_search(visited,y,x+2,cnt);
	}
	
	public static boolean isAble(boolean[][] visited, int y, int x) {
		
		for(int i = 0; i < 4; i++) {
			int t_y = diag_y[i] + y;
			int t_x = diag_x[i] + x;
			
			for(int j = 0; j <= size; j++) {
				if(t_y >= 0 && t_x >= 0 && t_y <= size && t_x <= size) {
					if(visited[t_y][t_x]) 
						return false;
					
					t_y += diag_y[i];
					t_x += diag_x[i];
				}
			}
		}
		return true;
	}
}