import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String input = br.readLine();
			double a = Double.parseDouble(input.split(" ")[0]);
			double b = Double.parseDouble(input.split(" ")[1]);
			
			if(a == 0 && b == 0) break;
			
			int cnt = 0;
			double[] num = new double[1000];
			num[1] = 1;
			num[2] = 2;
			for(int i = 3; i<num.length; i++)
				num[i] = num[i-1]+num[i-2];
			
			for (int i = 0; i<1000; i++)
				if(num[i] >= a && num[i] <= b) cnt++;
			System.out.println(cnt);
		}
		
	}
}