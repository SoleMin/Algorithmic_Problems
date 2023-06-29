import java.util.*;


class Main {
	
	static int[][] forbidden;
	static int numForbidden;
	static int[] start;
	static int[] end;
	
	static class State {
		int s1, s2, s3, s4, numOp;
		public State(int s1, int s2, int s3, int s4, int numOp) {
			this.s1 = s1;
			this.s2 = s2;
			this.s3 = s3;
			this.s4 = s4;
			this.numOp = numOp;
		}
	}
	
	static int solution() {
		Queue<State> queue = new ArrayDeque<>();
		queue.add(new State(start[0],start[1],start[2],start[3],0));
		
		boolean[][][][] visited = new boolean[10][10][10][10];
		for (int i=0; i < numForbidden; i++) {
			visited[forbidden[i][0]][forbidden[i][1]][forbidden[i][2]][forbidden[i][3]] = true;
		}
		
		while(queue.size() > 0) {
			State curr = queue.poll();
			int s1 = curr.s1;
			int s2 = curr.s2;
			int s3 = curr.s3;
			int s4 = curr.s4;
			int numOp = curr.numOp;
			
			if (visited[s1][s2][s3][s4]) {
				continue;
			}
			visited[s1][s2][s3][s4] = true;
			
			if (s1 == end[0] && s2 == end[1] && s3 == end[2] && s4 == end[3]) {
				return numOp;
			}
			
			queue.add(new State((s1+1)%10, s2, s3, s4, numOp+1));
			queue.add(new State(s1, (s2+1)%10, s3, s4, numOp+1));
			queue.add(new State(s1, s2, (s3+1)%10, s4, numOp+1));
			queue.add(new State(s1, s2, s3, (s4+1)%10, numOp+1));
			queue.add(new State(((s1-1)+10)%10, s2, s3, s4, numOp+1));
			queue.add(new State(s1, ((s2-1)+10)%10, s3, s4, numOp+1));
			queue.add(new State(s1, s2, ((s3-1)+10)%10, s4, numOp+1));
			queue.add(new State(s1, s2, s3, ((s4-1)+10)%10, numOp+1));
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		int tc = scanner.nextInt();
		scanner.nextLine();
		
		for (int test = 0; test < tc; test++) {
			start = new int[4];
			end = new int[4];
			for (int i=0; i < 4; i++) start[i] = scanner.nextInt();
			for (int i=0; i < 4; i++) end[i] = scanner.nextInt();
			numForbidden = scanner.nextInt();
			forbidden = new int[numForbidden][4];
			for (int i=0; i < numForbidden; i++) {
				for (int j=0; j < 4; j++) {
					forbidden[i][j] = scanner.nextInt();
				}
			}
			System.out.println(solution());
		}
		scanner.close();
	}
}