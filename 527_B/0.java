import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(reader.readLine());
    char[] s1 = reader.readLine().toCharArray();
    char[] s2 = reader.readLine().toCharArray();

    int res = 0;
    HashMap<Character, HashMap<Character, Integer>> someOccurrence = new HashMap<Character, HashMap<Character, Integer>>();

    for(int i = 0;i < n;i++) {
      if(s1[i] != s2[i]) {
        res++;

        if(!someOccurrence.containsKey(s1[i])) {
          someOccurrence.put(s1[i], new HashMap<Character, Integer>());
        }

        someOccurrence.get(s1[i]).put(s2[i], i);
      }
    }

    boolean flag = false;
    int x = -1, y = -1;
    for(int i = 0;i < n;i++) {
      if(s1[i] != s2[i]) {
        if(someOccurrence.containsKey(s2[i])) {
          if(someOccurrence.get(s2[i]).containsKey(s1[i])) {
            flag = true;
            res -= 2;

            x = i+1;
            y = someOccurrence.get(s2[i]).get(s1[i])+1;

            break;
          }
        }
      }
    }

    if(!flag) {
      for(int i = 0; i < n; i++) {
        if(s1[i] != s2[i]) {
          if(someOccurrence.containsKey(s2[i])) {
            res -= 1;

            for(char c : someOccurrence.get(s2[i]).keySet()) {
              x = i+1;
              y = someOccurrence.get(s2[i]).get(c)+1;
              break;
            }

            break;
          }
        }
      }
    }

    System.out.println(res);
    System.out.println(x + " " + y);
  }
}