import java.io.PrintWriter;
import java.util.*;

/*
10
R1C1
A1
R1C26
Z1
R1C27
AA1
R1C28
AB1
R1C52
AZ1

 */

public class Main {

	Scanner in;
	PrintWriter out;

	boolean isFirst(String line){
		int pos = 0;
		while( pos<line.length() && Character.isLetter(line.charAt(pos))){
			pos++;
		}
		while( pos<line.length() && Character.isDigit(line.charAt(pos))){
			pos++;
		}
		return pos!=line.length();
		
	}
	
	void solve() {
		int n = in.nextInt();
		in.nextLine();
		for (int i = 1; i<=n; i++){
			String line = in.nextLine();
			line = line.toUpperCase();
			if (isFirst(line)){
				int pos = 1;
				long row = 0;
				while(Character.isDigit(line.charAt(pos))){
					row*=10;
					row+=line.charAt(pos)-'0';
					pos++;
				}
				pos++;
				long col = 0;
				while(pos<line.length() && Character.isDigit(line.charAt(pos))){
					col*=10;
					col+=line.charAt(pos)-'0';
					pos++;
				}
				StringBuilder sb = new StringBuilder();
				while(col>0){
					sb.append((char)('A'+((col-1)%26)));
					col--;
					col/=26;
				}
				sb = sb.reverse();
				out.print(sb);
				out.println(row);
				// ��������� � 1 �������
			}else{
				// ��������� �� 2 �������
				int pos = 0;
				long col = 0;
				while( pos<line.length() && Character.isLetter(line.charAt(pos))){
					col*=26;
					col+=line.charAt(pos)-'A'+1;
					pos++;
				}
				long row = 0;
				while(pos<line.length() && Character.isDigit(line.charAt(pos))){
					row*=10;
					row+=line.charAt(pos)-'0';
					pos++;
				}
				out.println("R"+row+"C"+col);
			}
		}

	}

	void run() {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		try {
			solve();
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) {
		new Main().run();

	}

}
