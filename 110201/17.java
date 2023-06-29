import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	int[] value;
	int[] present;
	
	boolean jolly = false;
	
	public Main(String line) {
		String[] input = line.split(" ");
		int N = Integer.parseInt(input[0]);
		
		value = new int[N];
		present = new int[N];
		
		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(input[i+1]);
			present[i] = 0;
		}
		
		eval();
	}
	
	
	private void eval() {
		int N = value.length;
		int prev, curr;
		
		prev = value[0];
		jolly = true;
		
		for (int i = 1; i < N; i++) {
			curr = value[i];
			int diff = abs(curr - prev);
			
			if (diff <= 0 || diff >= N || present[diff] != 0) {
				jolly = false;
				break;
			}
			
			present[diff] = 1;
			prev = curr;
		}
	}
	
	private int abs(int x) {
		return (x) < 0 ? ((-x)) : (x);
	}
	
	public boolean isJolly() {
		return jolly;
	}
	
	
	public static void main(String[] args) {
		
		List<Main> list = new ArrayList<>();
		
		Scanner input = new Scanner(System.in);
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			
			if (line == null || line.length() == 0) {
				break;
			}
			
			list.add(new Main(line));
		}
		
		
		// 결과 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).isJolly() ? "Jolly" : "Not jolly");
		}
		
		input.close();
	}
}