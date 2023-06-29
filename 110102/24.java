import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int field = 1;
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int count;
		char[][] arr;
		while(n != 0 && m != 0) {
			if(field > 1) {
				s = br.readLine().split(" ");
				n = Integer.parseInt(s[0]);
				m = Integer.parseInt(s[1]);
				if(n == 0 && m == 0) break;
			}
			arr = new char[n][m];
			for(int i = 0; i < n; i++) {
				String str = br.readLine();
				for(int j = 0; j < m; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			System.out.println("Field #" + field + ":");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(arr[i][j] == '*')
						System.out.print('*');
					else {
						count = 0;
						if(i-1 >= 0) {
							if((j-1 >= 0) && (arr[i-1][j-1] == '*'))count++;
							if(arr[i-1][j] == '*')count++;
							if((j+1 <= m-1) && (arr[i-1][j+1] == '*'))count++;
						}
						
						if((j-1 >= 0) && (arr[i][j-1] == '*'))count++;
						if((j+1 <= m-1) && (arr[i][j+1] == '*'))count++;
						
						if(i+1 <= n-1) {
							if((j-1 >= 0) && (arr[i+1][j-1] == '*'))count++;
							if(arr[i+1][j] == '*')count++;
							if((j+1 <= m-1) && (arr[i+1][j+1] == '*'))count++;
						}
						System.out.print(count);
					}
				}
				System.out.println();
			}
			System.out.println();
			field++;
		}
	}
}