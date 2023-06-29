import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ran Bi (ran.bi@addepar.com)
 */
public class C {

  public static void main(String[] arg) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.valueOf(in.readLine());
    char[] s = in.readLine().toCharArray();
    int i = 0, j = 0;
    int[] ct = new int[256];
    Set<Character> all = new HashSet<>();
    for (char c : s) {
      all.add(c);
    }
    int total = 0, res = Integer.MAX_VALUE;
    while (j < s.length) {
      while (total < all.size() && j < s.length) {
        if (ct[s[j]] == 0) {
          total++;
        }
        ct[s[j]]++;
        j++;
      }
      res = Math.min(res, j - i);
      while (total == all.size() && i < s.length) {
        ct[s[i]]--;
        if (ct[s[i]] == 0) {
          total--;
        }
        i++;
        if (total == all.size()) {
          res = Math.min(res, j - i);
        }
      }
    }
    System.out.println(res);
  }
}
