import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			double[] array = new double[n];
			double sum = 0;
			for(int i=0; i<n; i++){
				double k = Double.parseDouble(br.readLine());
				array[i] = k;
				sum += k;
			}
			double av = sum/n;
			double plus = 0;
			double minus = 0;
			
			for(int i=0; i<n; i++){
				if(array[i]-av < 0) minus += av - array[i];
				else plus += array[i] - av;
			}
			plus = Math.floor(plus*100)/100.0;
			minus = Math.floor(minus*100)/100.0;
			
			sb.append('$').append(String.format("%.2f",Math.min(plus,minus))).append('\n');
		}
		
		System.out.println(sb);
	}
}