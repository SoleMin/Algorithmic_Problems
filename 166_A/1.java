import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class App {
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	public static void main(String args[] ) {
		//FastReader sc = new FastReader();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int p[] = new int[n];
		int t[] = new int[n];

		Map<Integer, ArrayList<Integer>> map = new HashMap();
		for(int i = 0; i<n; i++) {
			p[i] = sc.nextInt();
			t[i] = sc.nextInt();
			if(map.containsKey(p[i])) {
				ArrayList<Integer> al = map.get(p[i]);
				al.add(t[i]);
				map.put(p[i], al);
			}else {
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(t[i]);
				map.put(p[i], al);
			}
		}
		int count = 0;
	    Arrays.sort(p);
		int a = p[(n-k)];
		for(int i = (n-k)+1; i<n; i++) {
			if(p[i] == a)count++;
			else break;
		}
		
		ArrayList<Integer> al = map.get(a);
        Collections.sort(al);

        int ans = 1;
        int b = al.get(count);
        for(int i = count-1; i>=0; i--) {
        	if(al.get(i) == b)ans++;
        	else break;
        }
        for(int i = count+1; i<al.size(); i++) {
        	if(al.get(i) == b)ans++;
        	else break;
        }
        System.out.println(ans);
	}
	

}