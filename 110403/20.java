import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;
class Main {
	static int n;
	static int[] time = new int[1000];
	static PriorityQueue<Integer> oppo = new PriorityQueue<Integer>();
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		int testCase = input.nextInt();
		for(int i = 0; i < testCase; i++){
			input();
			int sum = 0;
			swap();
			if(i > 0)
				System.out.println();
			while(n >= 4){
				if(2 * time[1] < time[n - 2] + time[0]){		
					oppo.add(time[0]);
					oppo.add(time[1]);
					sum += time[1];
					sum += oppo.poll();
					oppo.add(time[n - 2]);
					oppo.add(time[n - 1]);
					sum += time[n - 1];
					sum += oppo.poll();
					n -= 2;
				}
				else{
					oppo.add(time[0]);
					oppo.add(time[n - 1]);
					sum += time[n - 1];
					sum += oppo.poll();
					oppo.add(time[0]);
					oppo.add(time[n - 1]);
					sum += time[n - 2];
					sum += oppo.poll();
					n -= 2;
				}
			}
			if(n == 3){
				oppo.add(time[0]);
				oppo.add(time[n - 1]);
				sum += time[n - 1];
				sum += oppo.poll();
				n--;
			}
			if(n == 2)
				sum += time[n - 1];
			if(n == 1)
				sum += time[0];
			System.out.println(sum);
			oppo.clear();
		}
		input.close();
	}
	static void input(){
		n = input.nextInt();
		for(int i = 0; i < n; i++)
			time[i] = input.nextInt();
	}
	static void swap(){
		for(int i = 0; i < n - 1; i++){
			for(int j = i; j < n; j++){
				if(time[i] > time[j]){
					int temp = time[i];
					time[i] = time[j];
					time[j] = temp;
				}
			}
		}
	}
}