import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		while((input=br.readLine()) != null)
		{
			String[] num = input.split(" ");
			long n = Long.parseLong(num[0]);
			long m = Long.parseLong(num[1]);
			int cnt = 0;
			int max = 0;
			long tmp = 0;
			
			if(n > m){
				tmp = n;
				n = m;
				m = tmp;
			}
			
			if (n < 1 && n > 1000000)
				continue;
			if(m < 1 && m > 1000000)
				continue;
			
			for(long i = n; i<= m; i++){
				
				cnt = 1;
				long numb = i;
				
				while (numb != 1){
				
					if(numb%2 != 0){
						numb = 3*numb + 1;
						cnt++;
					}
					while (numb%2 == 0) {
						numb = numb/2;
						cnt++;
					}
				}
				if (cnt > max)
					max = cnt;
			}
			if (tmp!=0)
				System.out.printf("%d %d %d",m, n, max);
			else
				System.out.printf("%d %d %d", n, m, max);
			System.out.println();
		}
	}
}