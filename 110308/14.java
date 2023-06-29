import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int max = 72;
		int tmp = 0;
		String str = "";
		String result = "";
		
		String in = sc.nextLine();
		while(true) {
			if (in.length() != 0) {
				str = in;
				str = str.trim();
				String tmpList[] = str.split(" ");
				int cnt = 0;
				while(cnt < tmpList.length) {
					tmp += tmpList[cnt].length() + 1;
					if (str.length() >= max && tmpList.length == 1 && result.equals("")){
						System.out.println(in);
						tmp = 0;
					}
					else if (tmp-1 >= max) {
						System.out.println(result);
						result = tmpList[cnt] + " ";
						tmp = tmpList[cnt].length();
					} else {
						result += tmpList[cnt] + " ";
					}
					cnt++;
				}
			}
			if (in.length() == 0 || sc.hasNextLine() == false) {
				System.out.println(result);
				System.out.println();
				result = "";
				tmp = 0;
			}
			if(!sc.hasNextLine())break;
			in = sc.nextLine();
		}
	}
}