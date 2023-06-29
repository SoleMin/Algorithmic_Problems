import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.PI;
import static java.lang.System.in;
import static java.lang.System.out;
import static java.lang.System.err;
/*
11
1
1
1
2
2
1
2
1
2
2
3
*/
public class C {    
    static public void main(String... args) throws Exception {   
        Foster sc = new Foster();
        PrintWriter p = new PrintWriter(out);
        int t = sc.nextInt();
        while(t--!=0){
            int n = sc.nextInt();
            int a[] = sc.intArray(n);
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for(int i = 0; i < n; i++){
                ArrayList<Integer> temp = new ArrayList<>();
                if(i-1 < 0){
                    temp.add(1);
                }
                else{
                    ArrayList<Integer> inner = arr.get(i-1);
                    int last = inner.get(inner.size()-1);
                    ArrayDeque<Integer> q = new ArrayDeque<>();
                    for(int j : inner){
                        q.addLast(j);
                    }
                    // if current is one greater then increment
                    if(last+1 == a[i]){
                        q.pollLast();
                        q.addLast(a[i]);
                    }
                    // move the chain
                    else if(a[i]==1){
                        q.addLast(a[i]);
                    }
                    // move back
                    else{
                        while(!q.isEmpty() && a[i]-q.peekLast() != 1){
                            q.pollLast();
                        }
                        if(q.isEmpty()) q.addLast(a[i]);
                        else{
                            q.pollLast();
                            q.addLast(a[i]);
                        }
                    }
                    // transfer queue to list
                    while(!q.isEmpty()){
                        temp.add(q.pollFirst());
                    }
                }
                arr.add(temp);
            }

            // output answer
            for(int i = 0; i < arr.size(); i++){
                p.print(arr.get(i).get(0));
                for(int j = 1; j < arr.get(i).size(); j++){
                    p.print("." + arr.get(i).get(j));
                }
                p.println();
            }
        }
        p.close();
    }
    
    static long[] sort(long a[]){
        ArrayList<Long> arr = new ArrayList<>();
        for(long i : a){
            arr.add(i);
        }
        Collections.sort(arr);
        for(int i = 0; i < arr.size(); i++){
            a[i] = arr.get(i);
        }
        return a;
    }
    static int[] sort(int a[]){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i : a){
            arr.add(i);
        }
        Collections.sort(arr);
        // Collections.reverse(arr);
        for(int i = 0; i < arr.size(); i++){
            a[i] = arr.get(i);
        }
        return a;
    }
    
    
/* 
*/    
/*
1. Check overflow in pow function or in general
2. Check indices of read array function
3. Think of an easier solution because the problems you solve are always easy
4. Check iterator of loop
5. If still doesn't work, then jump from the 729th floor 'coz "beta tumse na ho paayega"

    Move to top!!
*/
    static class Foster {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        int[] intArray(int n) {                   // Check indices
            int arr[] = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
        long[] longArray(int n) {                 // Check indices
            long arr[] = new long[n];
            for(int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
        int[] getBits(int n) {                   //in Reverse Order
            int a[] = new int[31];
            for(int i = 0; i < 31; i++) {
                if(((1<<i) & n) != 0)
                    a[i] = 1;
            }
            return a;
        }
        static long pow(long... a) {
            long mod = Long.MAX_VALUE;
            if(a.length == 3)   mod = a[2];
            long res = 1;
            while(a[1] > 0) {
                if((a[1] & 1) == 1)
                    res = (res * a[0]) % mod;
                a[1] /= 2;
                a[0] = (a[0] * a[0]) % mod;
            }
            return res;
        }
    }
}
