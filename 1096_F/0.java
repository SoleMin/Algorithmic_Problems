import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class F {
    public static int mod = 998244353;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // Scanner scan = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] a = new int[n]; for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());

        int total_neg = 0;
        int[] neg_before = new int[n];
        for(int i=0; i<n; i++) {
          neg_before[i] = total_neg;
          if(a[i] == -1) total_neg++;
        }
        Set<Integer> vals = new HashSet<Integer>();
        for(int i=1; i<=n; i++) vals.add(i);
        for(int i=0; i<n; i++) if(a[i] != -1) vals.remove(a[i]);

        int total_not_in = vals.size();
        int[] arr = new int[total_not_in];
        int counter = 0;
        for(int i : vals) {
          arr[counter] = i;
          counter++;
        }
        Arrays.sort(arr);


        long ans = 0;
        for(int i=0; i<n; i++) {
          if(a[i] != -1) {
            int below = neg_before[i];
            int above = total_neg - below;

            int index = Arrays.binarySearch(arr, a[i]);
            index = 0-(index+1);
            long p_less = frac(index, total_neg);
            long p_above = (1+mod-p_less)%mod;
            ans += (p_less * above % mod + p_above * below) % mod;

            // probability less is index/total_neg
            // above * p_less + below*p_above
          }
        }

        ans += frac((int)(1L*total_neg*(total_neg-1)/2 % mod), 2);

        int[] arr_2 = new int[n-total_not_in];
        int counter_2 = 0;
        for(int i=0; i<n; i++) {
          if(a[i] != -1) {
            arr_2[counter_2] = a[i];
            counter_2++;
          }
        }

        int[] t = new int[arr_2.length];
        long inv_count = mergeSort(arr_2, t, 0, arr_2.length-1);

        ans += inv_count;

        ans %= mod;

        out.println(ans);

        // int n = Integer.parseInt(st.nextToken());
        // int n = scan.nextInt();

        out.close(); System.exit(0);
    }
    public static int exp(int base, int e) {
      if(e == 0) return 1;
      if(e == 1) return base;
      int val = exp(base, e/2);
      int ans = (int)(1L*val*val % mod);
      if(e % 2 == 1)
        ans = (int)(1L*ans*base % mod);
      return ans;
    }
    public static int inv(int base) {
      return exp(base, mod-2);
    }
    public static long frac(int p, int q) {
      return (1L*p*inv(q) % mod);
    }

    public static long mergeSort(int[] a, int[] t, int l, int r)
    {
        int mid = 0;
        long inv_count = 0;
        if (r > l) {
            mid = (r + l) / 2;
            inv_count = mergeSort(a, t, l, mid);
            inv_count += mergeSort(a, t, mid + 1, r);
            inv_count += merge(a, t, l, mid + 1, r);
        }
        return inv_count;
    }

    public static long merge(int[] a, int[] t, int l, int mid, int r)
    {
        int i, j, k;
        long inv_count = 0;
        i = l;
        j = mid;
        k = l;
        while ((i <= mid - 1) && (j <= r)) {
            if (a[i] <= a[j]) {
                t[k++] = a[i++];
            }
            else {
                t[k++] = a[j++];
                inv_count = inv_count + (mid - i);
            }
        }
        while (i <= mid - 1)
            t[k++] = a[i++];
        while (j <= r)
            t[k++] = a[j++];
        for (i = l; i <= r; i++)
            a[i] = t[i];
        return inv_count;
    }
}
