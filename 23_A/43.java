import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader reader 
        = new BufferedReader(new InputStreamReader(System.in));       
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args){
        solve();
        return;
    }

    // the followings are methods to take care of inputs.
    static int nextInt(){
        return Integer.parseInt(nextLine());
    }
    static long nextLong(){
        return Long.parseLong(nextLine());
    }
    static int[] nextIntArray(){
        String[] inp = nextLine().split("\\s+");
        int[] ary = new int[inp.length];
        for (int i = 0; i < ary.length; i++){
            ary[i] = Integer.parseInt(inp[i]);
        }
        return ary;
    }
    static int[] nextIntArrayFrom1(){
        String[] inp = nextLine().split("\\s+");
        int[] ary = new int[inp.length + 1];
        for (int i = 0; i < inp.length; i++){
            ary[i+1] = Integer.parseInt(inp[i]);
        }
        return ary;
    }
    static long[] nextLongArray(){
        String[] inp = nextLine().split("\\s+");
        long[] ary = new long[inp.length];
        for (int i = 0; i < inp.length; i++){
            ary[i] = Long.parseLong(inp[i]);
        }
        return ary;
    }
    static long[] nextLongArrayFrom1(){
        String[] inp = nextLine().split("\\s+");
        long[] ary = new long[inp.length + 1];
        for (int i = 0; i < inp.length; i++){
            ary[i+1] = Long.parseLong(inp[i]);
        }
        return ary;
    }
    static String nextLine(){
        try { 
            return reader.readLine().trim();
        } catch (Exception e){}
        return null;
    }
    static void solve(){
        String str = nextLine();
        int max=0;
        int index=0;
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(i)==str.charAt(j)){
                    int count=1;
                    while(true){
                        if(str.length()<=i+count || str.length()<=j+count || str.charAt(i+count)!=str.charAt(j+count) ) 
                            break;
                        count++;
                    }
                    if(max<count){
                        max=count;
                        index=i;
                    }
                }
            }
        }
        System.out.println(max);

        return;
    }
}

