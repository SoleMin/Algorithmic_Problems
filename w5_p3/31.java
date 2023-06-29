import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t = br.readLine();
		String p = br.readLine();
		
		int next[] = new int[p.length()];
		int match_arr[] = new int[t.length()];
		int match_num = 0;
		next[0] = 0;
		int w = 0;
		int q = 1;
		for(q=1; q<p.length(); q++){
			while(w > 0 && p.charAt(w) != p.charAt(q))
				w = next[w-1];
			if(p.charAt(w) == p.charAt(q))
				next[q] = ++w;
		}
		
		int i = 0;
		int l = 0;
		for(i = 0; i<t.length(); i++){
			while(l > 0 && p.charAt(l) != t.charAt(i))
				l = next[l -1];
			if(p.charAt(l) == t.charAt(i)){
				if(l == p.length() -1){
					match_arr[match_num++] = (i - p.length() + 2);
					l = next[l];
				} else l++;
			}
		}
		System.out.println(match_num);
		for(i = 0; i< match_num; i++){
			System.out.print(match_arr[i] + " ");
		}
	}
}