import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();
        int left, right, i, j, pivot, temp, sum_dist;

        for(int tcNum = 0; tcNum < tc; tcNum++) {
            int n = scan.nextInt();
            int[] array = new int[n];
            for(i = 0; i < n; i++) {
                array[i] = scan.nextInt();
            }
            left = 0;
            right = n - 1;
            do {
                pivot = array[left];
                i = left;
                j = right;
                while(i <= j) {
                    while(i <= right && array[i] <= pivot)
                        i++;
                    while(j > left && array[j] >= pivot)
                        j--;
                    if(i < j) {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                    array[left] = array[j];
                    array[j] = pivot;
                    if(j < n / 2)
                        left = j + 1;
                    else
                        right = j - 1;
                }
            } while(j != n / 2);

            sum_dist = 0;
            for(int k = 0; k < j; k++)
                sum_dist += (pivot - array[k]);
            for(int k = j + 1; k < n; k++)
                sum_dist += (array[k] - pivot);
            System.out.println(sum_dist);

        }
    }
}