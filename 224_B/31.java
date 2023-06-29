import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Sunits789
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n=in.nextInt();
        int k=in.nextInt();
        int arr[]=new int[n];
        in.getArray(arr);
        int ansl=-1;
        int ansr=n;
        int occ[]=new int[100100];
        boolean f[]=new boolean[n];
        Arrays.fill(occ,0);
        Arrays.fill(f,true);
        int pk=0;
        for (int l=0,r=0;r<n&&l<n;){
            int num=arr[r];
            if(f[r]){
                f[r]=false;
                occ[num]++;
                if(occ[num]==1){
                    pk++;
                }
            }
            //System.out.println(l+" "+r+" "+pk+" "+k);
            if(pk<k){
                r++;
            }
            else if (pk==k){
                if((r-l)<=(ansr-ansl)){
                    ansl=l+1;
                    ansr=r+1;
                }
                num=arr[l];
                occ[num]--;
                if(occ[num]==0){
                    pk--;
                }
                l++;
            }
            else {
                num=arr[l];
                occ[num]--;
                if(occ[num]==0){
                    pk--;
                }
                l++;
            }
        }
        if(ansl==-1){
            ansr=-1;
        }
        out.println(ansl+" "+ansr);
    }
}

class InputReader{
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream){
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }
    public String next(){
        while (tokenizer == null||!tokenizer.hasMoreTokens()){
            try{
                tokenizer = new StringTokenizer(reader.readLine());
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt(){
        return Integer.parseInt(next());
    }

    public void getArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            arr[i]=nextInt();
        }
    }

    }

