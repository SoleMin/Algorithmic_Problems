import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Task1b {

	static int[] fromRC (String data) {
		int pos = data.indexOf('C');
		int res[] = new int[2];
		res[0] = Integer.parseInt(data.substring(1, pos));
		res[1] = Integer.parseInt(data.substring(pos + 1));
		return res;
	}
	
	static int[] fromXC (String data) {
		int pos = 0;
		int res[] = new int[2];
		res[0] = res[1] = 0;
		while (data.charAt(pos) >= 'A' && data.charAt(pos) <= 'Z') {
			res[1] *= 26;
			res[1]++;
			res[1] += data.charAt(pos) - 'A';
			pos++;
		}
		res[0] = Integer.parseInt(data.substring(pos));
		return res;
	}
	
	static String toRC (int[] data) {
		return String.format("R%dC%d", data[0], data[1]);
	}
	
	static String toXC (int[] data) {
		StringBuilder sb = new StringBuilder();
		while (data[1] > 0) {
			data[1]--;
			sb.append((char)('A' + data[1] % 26));
			data[1] /= 26;
		}
		sb = sb.reverse();
		sb.append(data[0]);
		return sb.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			if ((s.charAt(0) == 'R') && 
				(s.charAt(1) >= '0' && s.charAt(1) <= '9') &&
				(s.indexOf('C') != -1)) {
				
				System.out.println(toXC(fromRC(s)));
			} else {
				System.out.println(toRC(fromXC(s)));
			}
		}
	}

}
