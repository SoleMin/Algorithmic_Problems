import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(true) {
			int n = input.nextInt();
			if(n == 0) break;
			
			ArrayList<Integer> list = new ArrayList<>();
			list.add(0);
			list.add(1);
			int calc = 1, count = 1, pivot = 1;
			for(int i=2; i<=n; i++) {
				if(pivot == list.get(count)) {
					pivot = 1;
					count++;
				}
				else
					pivot++;
				list.add(count);
				calc += count;
				
				if(n <= calc) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}