import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		List<Float> ml = new ArrayList<>();
		while(true) {
			int n = sc.nextInt();
			if(n == 0) 
				break;
			float[] money = new float[n];
			float avg = 0.0f;
			float min = 0.0f;
			int[] temp = new int[n];
			for(int i = 0; i < n; i++) {
				money[i] = sc.nextFloat();
				avg += money[i]/n;
			}
			for(int i = 0; i < n; i++) {
				if(money[i] >= avg) {
					min += ((int)(100*(money[i] - avg)))/100.0; 
				}
			}
			ml.add(min);
		}
		for(int i = 0; i < ml.size(); i++) {
			System.out.printf("$%.2f\n",ml.get(i));
		}

	}
}