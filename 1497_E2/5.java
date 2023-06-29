import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(in);

    int t = Integer.parseInt(br.readLine());

    // get primes up to 10000
    /*
    boolean[] prime = new boolean[10001];
    for (int i = 0; i <= 10000; i++) {
      prime[i] = true;
    }

    for (int p = 2; p * p <= 10000; p++) {
      if (prime[p]) {
        for (int i = p * p; i <= 10000; i += p) {
          prime[i] = false;
        }
      }
    }
    ArrayList<Integer> primes = new ArrayList<>();

    for (int i = 2; i < 10001; i++) {
      if (prime[i]) {
        primes.add(i);
      }
    }
    */
    int A = 10000000;
    int[] convert = new int[A+1];
    for (int a = 1; a <= A; a++) {
      convert[a] = a;
    }
    for (int a = 2; a <= A/a; a++) {
      int sq = a*a;
      for (int b = sq; b <= A; b += sq) {
        while (convert[b] % sq == 0) {
          convert[b] /= sq;
        }
      }
    }

    int[] prevIndex = new int[A+1];
    for (int i = 0; i <= A; i++) {
      prevIndex[i] = -1;
    }

    for (int c = 0; c < t; c++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      int[] a = new int[n];
      int maxA = 0;

      st = new StringTokenizer(br.readLine());

      for (int i = 0; i < n; i++) {
        /*
        int raw = Integer.parseInt(st.nextToken());
        
        for (int p : primes) {
          if (p*p > raw) {
            break;
          }
          while (raw % (p*p) == 0) {
            raw /= p*p;
          }
        }
        a[i] = raw;
        */

        a[i] = convert[Integer.parseInt(st.nextToken())];
        maxA = Math.max(maxA, a[i]);
      }

      // hard version has extra here
      // better version O(nk)

      int[] partitions = new int[k+1];
      int[] partIndex = new int[k+1];

      for (int i = 0; i < n; i++) {
        int cur = a[i];
        for (int j = k; j >= 0; j--) {
          if (prevIndex[cur] >= partIndex[j]) {
            partitions[j]++;
            partIndex[j] = i;
          }
          if (j > 0 && (partitions[j-1] < partitions[j] || partitions[j-1] == partitions[j] && partIndex[j-1] > partIndex[j])) {
            partitions[j] = partitions[j-1];
            partIndex[j] = partIndex[j-1];
          }
        }
        prevIndex[cur] = i;
      }

      System.out.println(partitions[k]+1);

      for (int i = 0; i < n; i++) {
        int cur = a[i];
        prevIndex[cur] = -1;
      }


      /* this should work (O(n*k^2))
      int[][] minLeftIndex = new int[n][k+1];
    
      for (int j = 0; j <= k; j++) {
        HashMap<Integer, Integer> interval = new HashMap<>();
        int leftIndex = 0; // the right index is i in this case
        int removed = 0;

        for (int i = 0; i < n; i++) {
          if (!interval.containsKey(a[i])) {
            interval.put(a[i], 0);
          }
          interval.put(a[i], interval.get(a[i])+1);
          if (interval.get(a[i]) > 1) {
            removed++;
          }
          while (removed > j) {
            interval.put(a[leftIndex], interval.get(a[leftIndex])-1);
            if (interval.get(a[leftIndex]) > 0) {
              removed--;
            }
            leftIndex++;
          }
          minLeftIndex[i][j] = leftIndex;
          //System.out.println(i + " " + j + " " + leftIndex);
        }
      }

      int[][] dp = new int[n][k+1];

      // dp at all i = 0 = 0
      for (int i = 0; i < n; i++) {
        for (int j = 0; j <= k; j++) {
          int min = Integer.MAX_VALUE;
          for (int l = 0; l <= j; l++) {
            if (minLeftIndex[i][l] > 0) {
              min = Math.min(min, dp[minLeftIndex[i][l]-1][j-l] + 1); // 
            } else {
              min = 0;
            }
            
          }
          if (min != Integer.MAX_VALUE) {
            dp[i][j] = min;
          }
        }
      }
      
      System.out.println(dp[n-1][k]+1);

      

      */

      // easy solution
      /*
      HashSet<Integer> hs = new HashSet<>();

      int segments = 1;

      for (int i = 0; i < n; i++) {
        if (hs.contains(a[i])) {
          segments++;
          hs.clear();
        }
        hs.add(a[i]);
      }
      System.out.println(segments);
      */
    } 
  }
}