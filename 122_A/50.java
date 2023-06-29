import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;
        private void  solution() throws IOException{
   int n=nextInt();
   if((n % 4==0 && n>=4)||(n % 7==0 && n>=7) || (n % 44==0 && n>=44) || (n % 47==0 && n>=47) || (n % 77==0 && n>=77) || (n % 74==0 && n>=74)
   || (n % 444==0 && n>=444) || (n % 447==0 && n>=447) || (n % 474==0 && n>=74) || (n % 477==0 && n>=477) || (n % 744==0 && n>=744)
   || (n % 747==0 && n>=747) || (n % 777==0 && n>=777)){
           System.out.println("YES");
   }else{
                System.out.println("NO");}
        }
        String nextToken()throws IOException {
                if(st==null || !st.hasMoreTokens()){
                        st = new StringTokenizer(bf.readLine());
                }
                return st.nextToken();
        }
        int nextInt() throws IOException {
                return Integer.parseInt(nextToken());
        }

        long nextLong() throws IOException {
                return Long.parseLong(nextToken());
        }

        double nextDouble() throws IOException {
                return Double.parseDouble(nextToken());
        }

        public static void main(String args[]) throws IOException {
                new CF().solution();
        }
}