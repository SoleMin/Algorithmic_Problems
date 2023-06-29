import java.util.*;

class Main {
	
	static int[][] matrix;
	static boolean[][] flag;
	
	static String solution(List<Integer> list, int ferrylen) {
		int count = 0;
		
		int[] carlen = new int[list.size()];
		for(int i=0; i < list.size(); i++) {
			carlen[i] = list.get(i);
		}
		
		matrix = new int[carlen.length+1][ferrylen+1];
		for(int[] row : matrix) {
			Arrays.fill(row, -1);
		}
		flag = new boolean[carlen.length][ferrylen+1];
		
		search(carlen, 0, ferrylen);
		
		int current = ferrylen;
		int rightSum = 0;
		for(int i=0; i < carlen.length; i++) {
			if(flag[i][current]) {
				current -= carlen[i];
				count++;
			} else if (rightSum + carlen[i] <= ferrylen) {
				rightSum += carlen[i];
				count++;
			}
		}
		
		return String.valueOf(count);	
	}
	
	static int search(int[] carlen, int id, int remLeft) {
		if (matrix[id][remLeft] == -1) {
			if (id == carlen.length || remLeft == 0) {
				matrix[id][remLeft] = 0;
			} else if (carlen[id] <= remLeft) {
				int v1 = search(carlen, id+1, remLeft);
				int v2 = search(carlen, id+1, remLeft - carlen[id]) + carlen[id];
				matrix[id][remLeft] = (v1 <= v2) ? v2 : v1;
				flag[id][remLeft] = (v1 <= v2) ? true : false;
			} else if (remLeft < carlen[id]) {
				matrix[id][remLeft] = search(carlen, id+1, remLeft);
			}
		}
		return matrix[id][remLeft];
	}
	
	static void print(String result) {
		System.out.println(result);	
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		int numTestCase = scanner.nextInt();
		scanner.nextLine();
		
		for (int t = 0; t < numTestCase; t++) {
			scanner.nextLine();
			if (t > 0) {
				System.out.println();
			}
			
			int ferryLength = Integer.parseInt(scanner.nextLine()) * 100; // 미터단위
			
			List<Integer> list = new ArrayList<>();
			
			int sum = 0;
			while (scanner.hasNextLine()) {
				
				String line = scanner.nextLine();
				
				if (line == null || line.length() == 0) break;
				if ("0".equals(line)) break;
				
				int carLength = Integer.parseInt(line);
				sum += carLength;
				if (sum <= ferryLength * 2) {
					list.add(carLength);
				}
			}
			
			print(solution(list, ferryLength));
		}
		scanner.close();
	}
}