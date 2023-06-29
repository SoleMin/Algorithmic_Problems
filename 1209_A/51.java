import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = scanner.nextInt();
        }
        Arrays.sort(colors);
        int amountOfColors = 0;
        for (int i = 0; i < n; i++) {
            if (colors[i] != 0){
                amountOfColors++;
                int color = colors[i];
                for (int j = i; j < n; j++) {
                    if (colors[j] % color == 0){
                        colors[j] = 0;
                    }
                }
            }
        }
        System.out.println(amountOfColors);
    }
}