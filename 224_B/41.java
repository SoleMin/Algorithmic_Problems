import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;


public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("b.in"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] parts = bf.readLine().trim().split("[ ]+");
		int N = Integer.parseInt(parts[0]);
		int K = Integer.parseInt(parts[1]);
		
		int[] nums = new int[N];
		int idx = 0;
		
		String line = bf.readLine();
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if(c == ' ') idx++;
			else {
				int d = c - '0';
				nums[idx] = 10 * nums[idx] + d;
			}
		}
		
		int from = -1, to = -1;
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		for(int i = 0; i < N; i++) {
			Integer q = count.get(nums[i]);
			
			if(q == null) count.put(nums[i], 1);
			else count.put(nums[i], q + 1);
			
			if(count.size() == K) {
				to = i;
				break;
			}
		}
		
		if(count.size() < K) {
			System.out.println("-1 -1");
			return;
		}
		
		for(from = 0; from <= to; from++) {
			Integer q = count.get(nums[from]);
			
			if(q == 1) count.remove(nums[from]);
			else count.put(nums[from], q - 1);
			
			if(count.size() < K) break;
		}
		
		System.out.println((from + 1) + " " + (to + 1));

	}

}
