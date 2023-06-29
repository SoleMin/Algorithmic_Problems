import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class VKRound2Div2Task1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] strs = str.split(" ");
		int n = Integer.parseInt(strs[0]);
		int a = Integer.parseInt(strs[1]);
		int b = Integer.parseInt(strs[2]);
		str = br.readLine();
		String[] hs = str.split(" ");
		int[] h = new int[hs.length];
		for(int i=0;i<hs.length;i++){
			h[i] = Integer.parseInt(hs[i]);
		}
		Arrays.sort(h);
		if(h[b-1]==h[b]){
			System.out.println(0);
		}else{
			System.out.println(h[b]-h[b-1]);
		}
		
	}

}
