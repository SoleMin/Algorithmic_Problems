import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = {"XXXS", "XXS", "XS", "S", "M", "L", "XL", "XXL", "XXXL"};
		int[] size = new int[9];
		for(int i=0; i<N; i++){
			String c = br.readLine();
			for(int j=0; j<9; j++){
				if(s[j].equals(c)){
					size[j]++;
				}
			}
		}
		for(int i=0; i<N; i++){
			String c = br.readLine();
			for(int j=0; j<9; j++){
				if(s[j].equals(c)){
					size[j]--;
				}
			}
		}
		int sum = 0;
		for(int i=0; i<9; i++){
			if(size[i]>0)
				sum += size[i];
		}
		System.out.println(sum);
	}
}