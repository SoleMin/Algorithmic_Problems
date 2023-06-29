import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		String[] shape = {"Clubs", "Diamonds", "Hearts", "Spades"};
		
		String[] prev = new String[52];
		String[] original = new String[52];
		String[] curr = new String[52];
		
		int n = 0;
		for(int i = 0; i < shape.length; i++) {
			for(int j = 2; j <= 10; j++) {
				original[n++] = j+" of "+shape[i];
			}
			original[n++] = "Jack" + " of "+shape[i];
			original[n++] = "Queen"+" of "+shape[i];
			original[n++] = "King"+" of "+shape[i];
			original[n++] = "Ace"+" of "+ shape[i];
		}
		String sp[];
		int t = Integer.parseInt(br.readLine());
		int[][] shuffles;
		String line = "";
		String space = br.readLine(); //공백
		for(int i = 0; i < t; i++) {
			int num = Integer.parseInt(br.readLine());
			shuffles = new int[num][52];
			int count;
			for(int j = 0; j < num; j++) {
				count = 0;
				while(count < 52) {
					sp = br.readLine().split(" ");
					for(int k = 0; k < sp.length; k++) {
						shuffles[j][count++] = Integer.parseInt(sp[k]);
					}
				}
			}
			for(int j = 0; j < 52; j++) {
				prev[j] = original[j];
			}
			while((line = br.readLine()) != null && !line.equals("")) {
				int currs = Integer.parseInt(line)-1;
				for(int j = 0; j < 52; j++) {
					curr[j] = prev[shuffles[currs][j]-1];
				}
				for(int j = 0; j < 52; j++) {
					prev[j] = curr[j];
				}
			}
			for(int j = 0; j < 52; j++) {
				out.append(prev[j]+"\n");
			}
			if(i<t-1)
				out.append("\n");
		}
		System.out.print(out);
	
	}
}