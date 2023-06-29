import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run();
    }


    private void run() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        String[] line = reader.readLine().split("\\s");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        Arrays.sort(arr);

        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Iterator<Integer> iter = numbers.iterator();
            boolean contains = false;
            while (iter.hasNext()){
                int elem = iter.next();
                if(gcd(elem, arr[i]) == elem){
                    contains = true;
                }

            }
            if(!contains)
                numbers.add(arr[i]);
        }


        System.out.println(numbers.size());

    }

    private int gcd(int a, int b){
        while (a != b){
            if(a > b)
                a -= b;
            else
                b -= a;
        }

        return a;
    }



}