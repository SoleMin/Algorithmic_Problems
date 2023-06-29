import java.math.BigInteger;
  import java.util.*;
  
  public class A {
      public static void main(String[] args) {
          Scanner io = new Scanner(System.in);
          int n = io.nextInt(), a = io.nextInt();
          BigInteger bigA = new BigInteger(a + "");
          long[] b = new long[n];
         int[] c = new int[n];
         long[] pow = new long[15];
         String[] pow2 = new String[15];
         HashSet<Integer> set = new HashSet<>();
         pow[0] = 1;
         pow2[0] = "";
         for (int i = 1; i < pow.length; i++) {
             pow[i] = pow[i - 1] * 10;
             pow2[i] = pow2[i - 1] + "0";
         }
         long ans = 0;
 
         for (int i = 0, t; i < n; i++) {
             t = io.nextInt();
             b[i] = t % a;
             c[i] = (t + "").length();
             set.add(c[i]);
         }
 
         HashMap<Long, Long>[] map = new HashMap[pow.length];
         for (int l : set) {
             map[l] = new HashMap();
             for (int i = 0; i < n; i++) {
                 long m = (1L * (b[i] % a) * pow[l] % a);
                 if (m < 0) {
                     BigInteger big = new BigInteger(b[i] + pow2[l]);
                     m = big.mod(bigA).longValue();
                 }
                 map[l].put(m, map[l].getOrDefault(m, 0L) + 1);
             }
         }
 
         for (int i = 0; i < n; i++) {
             long find = b[i] == 0 ? 0 : a - b[i];
             if (!map[c[i]].containsKey(find)) continue;
             long cnt = map[c[i]].get(find);
             long t = 1L * (b[i] % a) * pow[c[i]] % a;
             if (t < 0) {
                 BigInteger big = new BigInteger(b[i] + pow2[c[i]]);                 t = big.mod(bigA).longValue();
             }
             //减去（a1+“”+a1）%mod的贡献
             if (t == find) cnt--;
             ans += cnt;
         }
         System.out.println(ans);
     }
}
				 	 								 	 		 	 			  		