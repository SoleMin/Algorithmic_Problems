import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class World_Cup {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        String nextLine(){
            String str = "";
            try
            {
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        int brr[] = new int [n];
        for(int i = 0; i < n; i++){
            brr[i] += arr[i]/n;
            if(i >= (arr[i] % n)){
                brr[i]+=1;
            }else{
                brr[i]+=2;
            }
        }
        int ans = brr[0];
        int ind = 0;
        for(int i = 1; i < n; i++){
            if(ans > brr[i] ){
                ans = brr[i];
                ind = i;
            }
        }
        ind++;
        System.out.println(ind);
    }
}
