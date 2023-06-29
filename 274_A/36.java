import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    //http://www.codeforces.com/contest/275/problem/C

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        if (k == 1) System.out.println(num); 
        else {
            Set<Integer> set = new TreeSet<Integer>();
            Set<Integer> bad = new TreeSet<Integer>();
            int sel;
            
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt((st.nextToken()));
            }

            shuffle(arr);
            Arrays.sort(arr);

            for (int i = 0; i < num; i++) {
                sel = arr[i];
                if (sel % k != 0) {
                    set.add(sel);
                    bad.add(sel * k);
                }
                if (!bad.contains(sel) && !set.contains(sel / k)) {
                    bad.add(sel * k);
                    set.add(sel);
                }
            }

            System.out.println(set.size()); 
        }
    }

    public static void shuffle(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i >= 0; --i) {
            int pos = rand.nextInt(i + 1);
            int aux = arr[i];
            arr[i] = arr[pos];
            arr[pos] = aux;
        }
    }
}