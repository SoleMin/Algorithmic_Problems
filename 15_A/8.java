
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author madi
 */
public class CottageTown {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] in = sc.nextLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int t = Integer.parseInt(in[1]);

        int[] coor = new int[n];
        int[] side = new int[n];

        for (int i = 0; i < n; i++) {
            in = sc.nextLine().split(" ");
            coor[i] = Integer.parseInt(in[0]);
            side[i] = Integer.parseInt(in[1]);
        }

        quickSort(coor, 0, n - 1, side);

        int count = 2;
        double dist;
        for (int i = 0; i < n - 1; i++) {
            dist = (coor[i + 1] - coor[i]) - (double)(side[i + 1] + side[i]) / 2.0;
            if (dist > t) {
                count += 2;
            } else if (dist == t) {
                count += 1;
            }
        }

        System.out.println(count);

    }

    private static int partition(int[] arr, int left, int right, int[] temp) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

                tmp = temp[i];
                temp[i] = temp[j];
                temp[j] = tmp;

                i++;
                j--;
            }
        }

        return i;
    }

    private static void quickSort(int[] arr, int left, int right, int[] temp) {
        int index = partition(arr, left, right, temp);
        if (left < index - 1) {
            quickSort(arr, left, index - 1, temp);
        }
        if (index < right) {
            quickSort(arr, index, right, temp);
        }
    }
}
