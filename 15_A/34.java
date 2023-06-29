import java.util.Arrays;
import java.util.Scanner;

public class P015A {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        int n = inScanner.nextInt();
        int t = inScanner.nextInt();
        House[] houses = new House[n];
        for (int i = 0; i < n; i++)
            houses[i] = new House(inScanner.nextInt(), inScanner.nextInt());
        Arrays.sort(houses);
        int sum = 2;
        for (int i = 1; i < n; i++) {
            double space = houses[i].leftX - houses[i - 1].rightX;
            if (space >= t)
                sum++;
            if (space > t)
                sum++;
        }
        System.out.println(sum);
    }

    private static class House implements Comparable<House> {

        int x;
        double leftX;
        double rightX;

        public House(int x, int size) {
            super();
            this.x = x;
            leftX = x - (double) size / 2;
            rightX = x + (double) size / 2;
        }

        @Override
        public int compareTo(House o) {
            return x - o.x;
        }
    }
}
