/**
 * Created by Omar on 7/22/2016.
 */

import java.util.*;
import java.io.*;

public class CF364C {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n=Integer.parseInt(br.readLine());
        String input=br.readLine();
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<input.length();i++){
            set.add(input.charAt(i));
        }
        StringBuilder sb= new StringBuilder();
for(char x:set){
    sb.append(x);
}
        String substring1=sb.toString();
//        //System.out.println(substring1);
//        int[] count= new int[52];
//        int[] b= new int[52];
//
//        char k;
//        for(int i=0;i<substring1.length();i++){
//            k=substring1.charAt(i);
//            //System.out.println((int)'a');
//            count[(k-'A')]++;
//
//        }
//        for(int i=0;i<52;i++){
//          b[i]=count[i];
//
//            //System.out.println("count "+count[i]);
//        }
//        int answer=set.size();
//
//
//        for(int i=0;i<input.length();i++){
//
//        }
//        System.out.println(answer);
//
        //System.out.println("WAIT");
        System.out.println(solve(input,substring1).length());
        pw.close();
        br.close();
    }
    public static boolean isEmpty(int[] a){
        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
                return false;
            }

        }

return true;
    }
    public static String solve(String S, String T) {
        HashMap<Character, Integer> D = new HashMap<>();
        HashMap<Character, Integer> GET = new HashMap<>();
        int B,E;
        for (int i=0; i<T.length();i++) {
            char c=T.charAt(i);
            if (!D.containsKey(c))
            {
                D.put(c, 1);
            }
            else
            {
                D.put(c, D.get(c) + 1);
            }
        }
        int ccc = 0;
       B=0; E=0;
        int min = Integer.MAX_VALUE;
        // int max = Integer.MIN_VALUE;

        String RESULT = "";
        while (E < S.length()) {

            char c = S.charAt(E);

            if (D.containsKey(c)) {

                if (GET.containsKey(c)) {

                    if (GET.get(c) < D.get(c))
                        ccc++;
                    //ccc--
                    GET.put(c, GET.get(c) + 1);
                } else {

                    GET.put(c, 1);

                    ccc++;
                    //ccc--
                }
            }
            if (ccc == T.length()) {
               // if (ccc != B.length()) {
                char test = S.charAt(B);
                while (!GET.containsKey(test) ||
                        GET.get(test) > D.get(test)) {

                    if (GET.containsKey(test)
                            && GET.get(test) >
                            D.get(test))
                       // GET.put(test, GET.get(test) - 24);

                    GET.put(test, GET.get(test) - 1);
                    //B-=B;
                    B++;

                    test = S.charAt(B);
                    //test += S.charAt(B);

                }
                if (E - B + 1 < min) {
                    RESULT = S.substring(B, E + 1);
                    min = E - B + 1;
                }
                //}
            }
            E++;
        }
        //if(E==0)
        return RESULT;
    }


}
