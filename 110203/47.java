import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] abc = new int[0];
		int[] narr = new int[0];
		int sum = 0;
		int count = Integer.parseInt(input);
		
		for (int i = 0; i<count; i++){
			int days = Integer.parseInt(br.readLine());
			int jungdangcount = Integer.parseInt(br.readLine());
			abc = new int[jungdangcount];
			narr = new int[days];
			for (int j=0;j<jungdangcount;j++){
				abc[j] = Integer.parseInt(br.readLine());
			}
			for(int j=0;j<jungdangcount;j++){
				for(int q=1;q<=days;q++){
					if(q%abc[j]==0){
						if(narr[q-1]>=1){ }
						else if(abc[j]==1) narr[q-1]++;
						else narr[q-1]++;
					}
				}
			}
			for(int q=6;q<=days;){
				narr[q-1]=0;
				if(q==days){
					break;
				}
				narr[q] =0;
				q+=7;
			}
			for(int j=0;j<days;j++){
				sum+=narr[j];
			}
			System.out.println(sum);
			sum=0;
		}
	}
}