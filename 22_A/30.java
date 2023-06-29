import java.util.*;

public class Beta22PA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int minimum = 200, second = 200;
		for(int i=0; i<n; i++) {
			int temp = scan.nextInt();
			if(temp<minimum) {
				second = minimum;
				minimum = temp;
			} else if(temp>minimum&&temp<second) {
				second = temp;
			}
		}
		if(second>100) {
			System.out.println("NO");
		} else {
			System.out.println(second);
		}
	}
}
