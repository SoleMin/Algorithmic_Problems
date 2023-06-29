import java.util.*;

class Main {
	
	public static boolean[][] matrix;
	public static int[] color;
	
	public static boolean solution (int id, int toFill) {
		if (color[id] == Integer.MAX_VALUE) {
			boolean flag = true;
			color[id] = toFill;
			for(int i=0; i < matrix.length && flag; i++) {
				if (matrix[id][i]) {
					flag = solution (i, 1-toFill);
				}
			}
			return flag;
		} else if (color[id] != toFill) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextLine()) {

			String line = scanner.nextLine();
			
			if (line == null || line.length() == 0) break;
			if ("0".equals(line)) break;
			
			int N = Integer.parseInt(line);
			matrix = new boolean[N][N];
			color = new int[N];
			Arrays.fill(color, Integer.MAX_VALUE);
			
			int R = Integer.parseInt(scanner.nextLine());
			for(int i=0; i < R; i++) {
				String[] result = scanner.nextLine().split(" ");
				int src = Integer.parseInt(result[0]);
				int dst = Integer.parseInt(result[1]);
				if (src != dst) {
					matrix[src][dst] = true;
					matrix[dst][src] = true;
				}
			}
			
			System.out.println(solution(0,0) ? "BICOLORABLE." : "NOT BICOLORABLE.");
		}
		scanner.close();
	}
}