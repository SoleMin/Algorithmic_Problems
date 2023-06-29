import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Main {
	
	List<Integer> costs = new ArrayList<>();
	
	int N = 0;
	int sum = 0;
	double avg = 0;
	double taken = 0;
	double given = 0;
	
	public Main(int nCosts) {
		this.N = nCosts;
	}
	
	public void addCost(Integer cost) {
		costs.add(cost);
	}
	
	public void calcAvg() {
		for (int i = 0; i < costs.size(); i++) 
			sum = sum + costs.get(i);
		avg = (double) sum / N;
	}
	
	
	
	
	public void calcDelta() {
		for (int i = 0; i < N; i++) {
			double delta = costs.get(i) - avg;
			
			if (delta < 0)
				taken += -((int) delta) / 100.0;
			else
				given += ((int) delta) / 100.0;
		}
	}
	
	
	
	
	public double getAmount() {
		return taken > given ? taken : given;
	}
	
	
	
	public static void main(String[] args) {
		
		List<Double> result = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		
		while (true) {

			String line = input.nextLine();
			int N = 0;
			try {
				N = Integer.parseInt(line);	
			} catch(Exception e) {}
			
			if (N == 0) 
				break;
			
			Main tcc = new Main(N);
			
			for (int i = 0; i < N; i++) {
				String[] str = input.nextLine().split("\\.");
				
				int dollars = Integer.parseInt(str[0]);
				int cents = str.length > 1 ? Integer.parseInt(str[1]) : 0;
				
				tcc.addCost(dollars * 100 + cents);
			}
			
			
			tcc.calcAvg();
			tcc.calcDelta();
			
			result.add(tcc.getAmount());
		}
		
		
		// 결과 출력
		for (int i = 0; i < result.size(); i++) 
			System.out.println(String.format("$%.2f", result.get(i)));
	
	
		input.close();
	}
}