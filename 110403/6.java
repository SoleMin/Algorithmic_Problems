import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int t = input.nextInt(); //테스트케이스 개수
		int[] arr = new int[t];
		ArrayList<Integer> A = new ArrayList<>();

		while(t-->0) {
			ArrayList<Integer> a = new ArrayList<>();
			
			input.nextLine();
			int n = input.nextInt();

			int[] time = new int[n];
			for(int i = 0; i < n; i++) {
				//time[i] = input.nextInt();
				a.add(input.nextInt());
			}	
			Collections.sort(a); //오름차순 정렬
		
			A.add(Time(a, n));
			
		}
		for(int i = 0; i < A.size(); i++)
			System.out.println(A.get(i)+"\n");
		
		input.close();

	}
	public static int Time(ArrayList<Integer> a, int n) {
		int result;
		if(n < 3) 
			result = a.get(n-1);
		else if(n == 3) 
			result = a.get(0) + a.get(1) + a.get(2);
		else {
			int x = 2*a.get(0) + a.get(n-1) + a.get(n-2);
			int y = a.get(0) + 2*a.get(1) + a.get(n-1);

			if(x < y)
				result = 2*a.get(0) + a.get(n-1) + a.get(n-2) + Time(a, n-2);
			else
				result = a.get(0) + 2*a.get(1) + a.get(n-1) + Time(a, n-2);

		}
		return result;

	}

}
