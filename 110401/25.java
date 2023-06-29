import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int tc = Integer.parseInt(input.nextLine());
		
		for (int i=0; i < tc; i++) {
			
			List<Integer> list = new ArrayList<>(); // 거리합계 저장
			
			int r = input.nextInt();
			int[] s = new int[r];
			for (int j=0; j < r; j++) {
				s[j] = input.nextInt();	
			}
			
			for(int j=0; j < r; j++) {
				int sum=0;
				for(int k=0; k<r; k++) {
					int distance = Math.abs(s[j] - s[k]);
					sum += distance;
				}
				list.add(sum);
			}
			list.sort(null); // 정렬
			System.out.println(list.get(0)); // 가장 작은값 출력
			input.nextLine();
		}
		input.close();
	}
}