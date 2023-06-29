import java.io.*;
import java.util.*;

public class A {
    String filename = "";

    final int INF = 1_000_000_000;
    void solve() {
        int n = readInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = readInt();
        }
        Map<Integer, Integer>[] maps = new Map[n];
        Map<Integer, Integer> sums = new HashMap();
        for(int i = 0;i<n;i++){
            maps[i] = new HashMap<>();
        }

        for(int i = 0;i<n;i++){
            int summ = 0;
            for(int j = i;j<n;j++){
                summ += a[j];
                if(!maps[i].containsKey(summ)) maps[i].put(summ, j);
                int x = sums.getOrDefault(summ, 0);
                sums.put(summ, x + 1);
            }
        }
        int max = 0;
        int goodSumm = 0;
        for(int summ : sums.keySet()){
            if(sums.get(summ) <= max) continue;
            int right = -1;
            int ans = 0;
            for(int j = 0;j<n;j++){
                if(!maps[j].containsKey(summ)) continue;
                int end = maps[j].get(summ);
                if(right == -1){
                    right = end;
                    ans++;
                    continue;
                }

                if(j > right){
                    right = end;
                    ans++;
                    continue;
                }

                if(end < right){
                    right = end;
                }
            }
            if(max < ans){
                max = ans;
                goodSumm = summ;
            }
        }
        int left = -1;
        int right = -1;
        List<Integer> ans = new ArrayList<>();
        for(int j = 0;j<n;j++){
            if(!maps[j].containsKey(goodSumm)) continue;
            int start = j;
            int end = maps[j].get(goodSumm);
            if(right == -1){
                left = j;
                right = end;
                continue;
            }

            if(start > right){
                ans.add(left + 1);
                ans.add(right + 1);
                left = start;
                right = end;
                continue;
            }

            if(end < right){
                left = start;
                right = end;
            }
        }
        ans.add(left + 1);
        ans.add(right  + 1);
        out.println(max);
        for(int i  = 0;i<ans.size();i+=2){
            out.println(ans.get(i) + " " + ans.get(i + 1));
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new A().run();
    }
    void run() throws FileNotFoundException {
        init();
        solve();
        out.close();
    }
    BufferedReader in;
    PrintWriter out;

    StringTokenizer tok = new StringTokenizer("");

    void init() throws FileNotFoundException {
        if(!filename.equals("")) {
            in = new BufferedReader(new FileReader(new File(filename + ".in")));
            out = new PrintWriter(new File(filename + ".out"));
            return;
        }

        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    String readLine(){
        try{
            return in.readLine();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    String readString(){
        while(!tok.hasMoreTokens()){
            String nextLine = readLine();
            if(nextLine == null) return null;
            tok = new StringTokenizer(nextLine);
        }
        return tok.nextToken();
    }

    int readInt(){
        return Integer.parseInt(readString());
    }

    long readLong(){
        return Long.parseLong(readString());
    }
}