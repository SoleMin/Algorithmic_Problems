import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		List<Integer> dy = new ArrayList<Integer>();
		dy.add(0);
		dy.add(1);
		
		int num = sc.nextInt();
		
		while (num != 0) {
			
			if (num == 1) {
				System.out.println(dy.get(num));
			} else {
				if (dy.size() > num) {
					System.out.println(dy.get(num));
				} else {
					for (int i = dy.size() - 1; i < num; i++) {
						dy.add(1 + dy.get(i + 1 - dy.get(dy.get(i))));
					}
					System.out.println(dy.get(num));
				}
			}
			
			num = sc.nextInt();
		}
	}
}