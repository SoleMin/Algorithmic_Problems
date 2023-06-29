import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.util.Scanner;

public class Main {
    private static FastReader scanner = new FastReader();
    public static void main(String[] args) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] array = new int[m];
        readArray(array);
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ;i<=n;i++){
            list.add(i);
        }
        int points =Integer.MAX_VALUE;
        for(int i =  0;i<list.size();i++){
            int nas=0;
            for(int j = 0 ;j< array.length;j++){
                if(list.get(i)==array[j]){
                    nas++;
                }
            }
            points = Math.min(points,nas);
        }
        System.out.println(points);

    }
    private static void swap(int[] array , int a ,int b){
        if (a==b){
            return;
        }
        int temp = array[a];
        array[a] =array[b];
        array[b] =temp;
    }
    private static String revString(String str){
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
    private static int fibo(int n){
        int[] dp = new int[n];
        for(int i= 0 ;i<n;i++){
            if(i<2){
                dp[i] = 1;
            }else{
                dp[i] =dp[i-1]+dp[i-2];
            }
        }
        return dp[dp.length-1];
    }
    private static void swap(char[] array , int a,int b){
        if(a==b){
            return;
        }
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    private static Scanner slowscanner = new Scanner(System.in);
    private static int max(int[] array ){
        int min = Integer.MIN_VALUE;
        for(int i = 0;i< array.length;i++){
            if(array[i]>min){
                min = array[i];
            }
        }
        return min;
    }
    private static int min(int[] array ){
        int min = Integer.MAX_VALUE;
        for(int i = 0;i< array.length;i++){
            if(array[i]<min){
                min = array[i];
            }
        }
        return min;
    }
    private static void readArray(int[] array){
        for(int i = 0;i< array.length;i++){
            array[i] = scanner.nextInt();
        }
    }
    private static int gcd(int a , int b){
        if(b==0) return  a;
        else return gcd(b,a%b);
    }
    private static long fact(int n){
        if(n==1 || n==0) return 1;
        else return (long) n*fact(n-1);
    }
    private static int Arraysum(int[] array){
        int sum = 0;
        for(int i = 0 ;i< array.length;i++){
            sum+=array[i];
        }
        return sum;
    }
    private static boolean isPrime(long n){
        if(n==1){
            return false;
        }
        for(long i = 2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    private static int multiply(int[] array){
        int mult = 1 ;
        for(int i = 0 ;i< array.length;i++) {
            mult *= array[i];
        }
        return mult;
    }
    private static int FromStringtoInt(String s){
        s = s.replaceAll("[^0-9]","");
        return Integer.parseInt(s);
    }
    static class BIT{
        static int[] BitTree = new int[1000];
        int sum(int index){
            int s =0;
//            index+=1;
            while (index>0){
                s+=BitTree[index];
                index-=(index&-index);
            }
            return s;
        }
        public static void updateBIT(int n, int index, int val) {
            index = index + 1;
            while(index <= n) {
                BitTree[index] += val;
                index += index & (-index);
            }
        }
        void constructBITree(int arr[], int n) {
            for(int i=1; i<=n; i++)
                BitTree[i] = 0;
            for(int i = 0; i < n; i++)
                updateBIT(n, i, arr[i]);
        }
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