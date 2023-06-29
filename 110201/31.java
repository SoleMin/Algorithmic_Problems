import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputl;
		while ((inputl = br.readLine()) != null) {
			String[] input = inputl.split(" ");
			int[] arr = new int[Integer.parseInt(input[0]) - 1];
			boolean jolly = true;
			
			for (int i = 1; i < input.length - 1; i++) {
				int n = Math.abs(Integer.parseInt(input[i]) - Integer.parseInt(input[i + 1]));
				try {
					if (arr[n - 1] > 0) {
						jolly = false;
						break;
					} else {
						arr[n - 1]++;
					} 
				} catch(ArrayIndexOutOfBoundsException e) {
					jolly = false;
					break;
				}
			}
		
			for (int num: arr) {
				if (num != 1) {
					jolly = false;
					break;
				}
			}
			System.out.println(jolly ? "Jolly" : "Not jolly");
		}
	}
}