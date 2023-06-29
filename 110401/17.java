import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        input.nextLine();
        for (int i = 0; i < cases ; i++) {

            int houseNum = input.nextInt();
            int[] house = new int[houseNum];
            for (int j = 0; j < houseNum ; j++) {
                house[j] = input.nextInt();
            }
            int res =0;
            Arrays.sort(house);
            for (int j = 0; j < houseNum; j++) {
                res += Math.abs(house[j]-house[houseNum/2]);
            }
            System.out.println(res);

        }
    }
}
