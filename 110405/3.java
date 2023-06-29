import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int repeat = Integer.parseInt(input.nextLine());

		for(int r=0; r<repeat; r++) {
			input.nextLine();
			
			int m = Integer.parseInt(input.nextLine());
			double[] data = new double[m];
			int[] order = new int[m];
			
			for(int i=0; i<m; i++) {
				String[] split = input.nextLine().split("\\s+");
				data[i] = Double.parseDouble(split[1]) / Double.parseDouble(split[0]);
				order[i] = i+1;
			}
			
			for(int i=0; i<m-1; i++) {
				int max = i;
				for(int j=i; j<m; j++) 
					if(data[max] < data[j])
						max = j;
				
				double temp = data[max];
				data[max] = data[i];
				data[i] = temp;
				
				temp = order[max];
				order[max] = order[i];
				order[i] = (int) temp;
			}
			
			String s = order[0] + "";
			for(int i=1; i<m; i++)
				s = s + " " + order[i];
			
			if(r>0)
				System.out.println();
			System.out.println(s);
		}
		input.close();
	}
}