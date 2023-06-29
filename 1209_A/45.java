import java.util.*;
import java.io.*;
import java.math.*;

public class Es1
{
    static IO io = new IO();
    public static void main(String[] args)
    {
		int n = io.getInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++)
			a[i] = io.getInt();
		
		Arrays.sort(a);
		int[] color = new int[n];
		int num = 1;
		for(int i=0; i<n; i++){
			if(color[i]==0){
				for(int j=i+1; j<n; j++){
					if(a[j]%a[i]==0)
						color[j] = num;
				}
				num++;
			}
		}
		
		io.println(num-1);

		
		
		
        io.close();
    }
}



class IO extends PrintWriter {
	public IO() {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(System.in));
    }

    public IO(String fileName) {
        super(new BufferedOutputStream(System.out));
        try{
            r = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            this.println("File Not Found");
        }
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

	public String getLine(){
        try{
            st = null;
            return r.readLine();
        }
        catch(IOException ex){}
        return null;
    }
	

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
