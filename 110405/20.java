import java.util.*;

class Main {
	
	static class Penalty {
		int W, T, S;
		public Penalty(int W, int T, int S) {
			this.W = W;
			this.T = T;
			this.S = S;
		}
	}
	
	static Comparator<Penalty> comparator = new Comparator<>() {
		@Override
		public int compare(Penalty p1, Penalty p2) {
			int v1 = p1.T * p2.S;
			int v2 = p2.T * p1.S;
			if (v1 == v2) return 0;
			return v1 < v2 ? -1 : 1;
		}
	};
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int testcases = Integer.parseInt(input.nextLine());
		input.nextLine();
		
		for(int tc=0; tc < testcases; tc++) {
			if (0 < tc) {
				input.nextLine();
				System.out.println();
			}
			
			List<Penalty> list = new ArrayList<>();
				
			int works = Integer.parseInt(input.nextLine());
			
			for(int i=0; i < works; i++) {
				int T = input.nextInt();
				int S = input.nextInt();
				list.add(new Penalty(i+1,T,S));
				input.nextLine();
			}
			
			// 정렬
			list.sort(comparator);
			
			// 결과 출력
			for (int i=0; i < list.size(); i++) {
				if (i > 0) System.out.print(' ');
				System.out.print(list.get(i).W);
			}
			System.out.println();
		}
	}
}