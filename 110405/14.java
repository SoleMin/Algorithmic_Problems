import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int cases = input.nextInt();
        for (int i = 0; i < cases ; i++) {
            input.nextLine();
            input.nextLine();
            int caseI = input.nextInt();
            double[] day = new double[caseI];
            int[] money = new int[caseI];
            LinkedList<Double> list = new LinkedList<>();
            double[] rank = new double[caseI];
            for (int j = 0; j < caseI; j++) {
                input.nextLine();
                day[j] = input.nextInt();
                money[j] = input.nextInt();
                list.add(money[j]/day[j]);
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < caseI ; j++) {
                double max = 0;
                for (int k = 0; k < list.size(); k++) {
                    if (max < list.get(k)){
                        max = list.get(k);
                    }

                }
                queue.offer(list.indexOf(max)+1);
                list.set(list.indexOf(max),0.0);
            }
            for (int j = 0; j < rank.length; j++) {
                System.out.print(queue.poll()+ " ");
            }

            System.out.println();
					System.out.println();
        }
    }
}
