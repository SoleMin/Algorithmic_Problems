

import javafx.util.Pair;

import java.util.*;

import static java.lang.Math.floor;
import static java.lang.Math.min;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanInt();
        List<Integer> a = scanList(n);
        int m = scanInt();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            left.add(scanInt());
            right.add(scanInt());
        }

        String even = "even";
        String odd = "odd";

        int inversions = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = i; j < a.size(); j++) {
                if (a.get(i) > a.get(j)) {
                    ++inversions;
                }
            }
        }

        inversions = inversions % 2;
        for (int i = 0; i < m; i++) {
            inversions = (inversions + (right.get(i) - left.get(i) + 1) / 2 % 2) % 2;
            println(inversions % 2 == 0 ? even : odd);
        }


    }

    private static Integer get(int digit, List<Integer> numbers) {
        Integer toReturn = null;
        for (Integer number : numbers
                ) {
            if (number <= digit) {
                toReturn = number;
                break;
            }
        }
        return toReturn;

    }

    private static List<Integer> toList(char[] chars) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            integers.add(Integer.parseInt(String.valueOf(chars[i])));
        }
        return integers;
    }

    private static List<Pair<Integer, Integer>> scanPairs(int amount) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            list.add(new Pair<>(scanInt(), scanInt()));
        }
        return list;
    }

    private static int[] scanArray(int length) {
        int array[] = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static List<Integer> scanList(int length) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            integers.add(scanner.nextInt());
        }
        return integers;
    }

    public static String scanString() {
        return scanner.next();
    }

    private static int scanInt() {
        return scanner.nextInt();
    }

    private static void println(int n) {
        System.out.println(n);
    }

    private static void print(int n) {
        System.out.print(n);
    }

    private static void println(String s) {
        System.out.println(s);
    }

    private static void print(String s) {
        System.out.print(s);
    }

    private static void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}



