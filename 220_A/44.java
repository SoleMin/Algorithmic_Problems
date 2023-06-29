import java.io.InputStreamReader;
import java.io.IOException;
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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n=in.nextInt();
        int arr[]=new int[n];
        in.getArray(arr);
        int arrc[]=new int[n];
        for(int i=0;i<n;i++){
            arrc[i]=arr[i];
        }
        Library.sort(arrc);
        int c=0;
        for(int i=0;i<n;i++){
            if(arrc[i]!=arr[i]){
                c++;
            }
        }
        if(c>2){
            out.println("NO");
        }
        else{
            out.println("YES");
        }
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

class Library{
    public static void sort(int n[]){
        int len=n.length;
        int l1=len/2;
        int l2=len-l1;
        int n1[]=new int[l1];
        int n2[]=new int[l2];
        for(int i=0;i<l1;i++){
            n1[i]=n[i];
        }
        for(int i=0;i<l2;i++){
            n2[i]=n[i+l1];
        }
        if(l1!=0){
            sort(n1);
            sort(n2);
        }
        int ind1=0;
        int ind2=0;
        int ind=0;
        for(int i=0;i<len&&ind1<l1&&ind2<l2;i++){
            if(n1[ind1]<n2[ind2]){
                n[i]=n1[ind1];
                ind1++;
            }
            else{
                n[i]=n2[ind2];
                ind2++;
            }
            ind++;
        }
        if(ind1<l1){
            for(int i=ind1;i<l1;i++){
                n[ind]=n1[i];
                ind++;
            }
        }
        if(ind2<l2){
            for(int i=ind2;i<l2;i++){
                n[ind]=n2[i];
                ind++;
            }
        }
    }
    
    }

