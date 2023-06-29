import java.io.*;

public class Min_Number {

	public static void main(String[] args) throws IOException{
		BufferedReader fs = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(fs.readLine());
		int count = 0;
		String str = fs.readLine();
		
		if(n == 1) {
			System.out.println(str);
		} else {
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '0') {
					count++;
				}
			}
			System.out.print("1");
			for(int i = 0; i < count; i++) {
				System.out.print("0");
			}
		}
	}
}


