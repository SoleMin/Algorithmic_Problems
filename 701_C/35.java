import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String in1 = in.readLine();
		String store = "";
		HashSet<Character> contain = new HashSet<Character>();
		for(int i = 0; i < n;i++){
			if(!contain.contains(in1.charAt(i))){
				store += in1.charAt(i);
				contain.add(in1.charAt(i));
			}
		}
		int[] index = new int[store.length()];
		for(int i = 0; i < store.length(); i++){
			index [i] = -1;
		}
		HashSet<Integer> index2 = new HashSet<Integer>();
		ArrayList<Integer> index3 = new ArrayList<Integer>();
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++){
			int index4 = store.indexOf(in1.charAt(i));
			if(index[index4] == -1){
				index[index4] = i;
				index2.add(i);
				index3.add(i);
			}
			else{
				index2.remove(index[index4]);
				index2.add(i);
				index3.add(i);
				index[index4] = i;
			}
			if(index2.size() == index.length){
				while(!index2.contains(index3.get(0))){
					index3.remove(0);
				}
				min = Math.min(min, i - index3.get(0)+ 1);
			}
			
		}
		System.out.println(min);
	}

}
