import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


public class Main {
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int mod=1000000007;
        String[] input=in.readLine().split(" ");
        int n=Integer.parseInt(input[0]);
        int a=Integer.parseInt(input[1]);
        int b=Integer.parseInt(input[2]);
        String[] h=in.readLine().split(" ");
        int[] mas=new int[n];
        for(int i=0; i<n; i++){
            mas[i]=Integer.parseInt(h[i]);
        }
        Arrays.sort(mas);
        int l=mas[b-1];
        int r=mas[b];
        int count=0;
        if(l==r) count=0;
        else count=r-l;
        out.println(count);
        out.close();
    }

}