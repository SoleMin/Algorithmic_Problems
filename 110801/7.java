import java.util.Scanner;

public class Main {
	static int n = Integer.MAX_VALUE;
	static int k = Integer.MAX_VALUE;
	static int count;
	static int[] dx = {-1, -1, 1, 1};
	static int[] dy = {-1, 1, -1, 1};
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		while(n != 0 && k != 0) {
			input();
			if(n <= 0 || n > 8 || k <= 0 || k > n * n)
				break;
			count = 0;
			
			boolean[][] visited = new boolean[n + 1][n + 1];
			bishop(visited, 1, 1, 0);
			System.out.println(count);
		}
		input.close();
	}

	static void bishop(boolean[][] visited, int x, int y, int current) {
		if(current == k) {
			count++;
			return;
		}
		if(x > n) {
			y += 1;
			x = 1;
		}
		if(y > n)
			return;
	if(isCorrect(visited, x, y, current)) {
			visited[y][x] = true;
			bishop(visited, x + 1, y, current + 1);
			visited[y][x] = false;
		}
		bishop(visited, x + 1, y, current);
	}
	static boolean isCorrect(boolean[][] visited, int x, int y, int current) {
		for(int i = 0; i < 4; i++) {
			int yy = dy[i] + y;
			int xx = dx[i] + x;
			
			for(int j = 0; j < n; j++) {
				if(yy > 0 && xx > 0 && yy <= n && xx <= n) {
                    if(visited[yy][xx]) return false;
                    
                    yy += dy[i];
                    xx += dx[i];
                }
			}
		}
		return true;
	}

	static void input() {
		n = input.nextInt();
		k = input.nextInt();
	}

}