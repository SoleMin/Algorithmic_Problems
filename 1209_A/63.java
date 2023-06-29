import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class a{
    public static void main(String[] args)throws IOException{
	br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	int n = nextInt();
	int v[] = new int[n];
	int fv[] = new int[101];
	for(int i = 0; i<n;i++){
	    v[i] = nextInt();
	}
	Arrays.sort(v);
	for(int i = 0; i<n;i++){
	    for(int j = i; j<n;j++){
		if(v[j]%v[i]==0){
		    v[j] = v[i];
		    fv[v[j]]++;
		}
	    }
	}
	int ans = 0;
	for(int i = 0; i<101;i++){
	    if(fv[i]!=0){
		ans++;
	    }
	}
	out.println(ans);
	out.close();
    }

    static BufferedReader br;
    static StringTokenizer st = new StringTokenizer("");

    static String next()throws IOException{
	while(!st.hasMoreTokens()){
	    st = new StringTokenizer(br.readLine());
	}
	return st.nextToken();
    }
    static int nextInt()throws IOException{
	return Integer.parseInt(next());
    }
    
}
