import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int nums = Integer.parseInt(reader.readLine());
		
		String line = reader.readLine();
		int[] ar = new int[nums];
		String[] par = line.split(" ");
		
		for(int i=0; i<nums; i++){
			ar[i] = Integer.parseInt(par[i]);
		}
		A a = new A();
		
		System.out.print(a.getDif(ar));
	}
	
	private int getDif(int[] input){
		int odd = 0, even = 0, d = 0;
		int p = 0, q = 0;
		
		for(int i=0; i<input.length; i++){
			int t = input[i]%2;
			if(t==0){
				even++;
				p = i+1;
			}
			else{
				odd++;
				q = i+1;
			} 
			
			if(odd>0 && even>0 && (odd!=even)){
				if(even>odd)
					return q;
				else
					return p;
			}
			
		}
		
		return d;
	}

}
