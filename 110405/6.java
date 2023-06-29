import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();
        scan.nextLine();
        for(int tcNum = 0; tcNum < tc; tcNum++) {
            scan.nextLine();
            int n = scan.nextInt();
            scan.nextLine();
            int[] ti = new int[n];
            int[] si = new int[n];
            int[] result = new int[n];

            for(int i = 0; i < n; i++) {
                String str = scan.nextLine();
                ti[i] = Integer.parseInt(str.split(" ")[0]);
                si[i] = Integer.parseInt(str.split(" ")[1]);
            }

            for(int i = 0; i < n; i++) {
                result[i] = i;
            }

            for(int i = 1; i < n; i++) {
                int temp = 0;
                for(int j = 0; j < n - 1; j++) {
                    if(ti[result[j]] * si[result[j + 1]] > ti[result[j + 1]] * si[result[j]]) {
                        temp = result[j];
                        result[j] = result[j + 1];
                        result[j + 1] = temp;
                    }
                }
            }

            if(tcNum > 0)
                System.out.println();
            for(int i = 0; i < n - 1; i++)
                System.out.print(result[i] + 1 + " ");
            System.out.println(result[n - 1] + 1);
        }
    }
}