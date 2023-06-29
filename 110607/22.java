import java.util.*;

class Main {
	
	public static int abs(int x) {
		return x < 0 ? -x : x;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		List<Integer> list = new ArrayList<>();
		
		list.add(1); // f1 = 1
		list.add(2); // f2 = 2
		
		int n = 2;
		int fn = 2;

		while(true) {
			int lastValue = list.get(list.size() - 1);
			if (lastValue > 2000000000) break;
			
			for (int i=0; i < fn; i++) {
				int golomb = list.get(list.size() - 1) + n;
				list.add(golomb);
			}
			n++;
			if (list.get(fn) == n) fn++;
		}
		
		while (input.hasNextLine())	{
			int N = input.nextInt();
			if (N == 0) break;
			
			int res = Arrays.binarySearch(list.toArray(), N); // 결과 탐색
			System.out.println(abs(res+1));
			
		}
		input.close();
	}
}