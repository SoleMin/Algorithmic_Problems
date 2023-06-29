import java.util.*;
import java.lang.*;
import java.io.*;
//****Use Integer Wrapper Class for Arrays.sort()****
public class AG1 {
    public static void main(String[] Args){
        FastReader scan=new FastReader();
        int n=scan.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=scan.nextInt();
        }
        Arrays.sort(arr);
        boolean[] done=new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(!done[i]){
                done[i]=true;
                ans++;
                for(int j=i+1;j<n;j++){
                    if(arr[j]%arr[i]==0){
                        done[j]=true;
                    }
                }
            }
        }
        System.out.println(ans);
    }
    static class FastReader {
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

}
