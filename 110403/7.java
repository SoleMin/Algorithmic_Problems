import java.util.*;
class Main {

    public static int calTime(ArrayList<Integer> list, int n) {
        if(n < 3)
            return list.get(n-1);
        else if(n == 3)
            return list.get(0) + list.get(1) + list.get(2);
        else {
            int a = list.get(n - 1) + list.get(0) + list.get(n - 2) + list.get(0);
            int b = list.get(1) + list.get(0) + list.get(n - 1) + list.get(1);

            if(a < b)
                return a + calTime(list, n - 2);
            else if(a > b)
                return b + calTime(list, n - 2);
            else
                return b + calTime(list, n - 2);
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();
        scan.nextLine();
        int[] result = new int[tc];
        for (int tcNum = 0; tcNum < tc; tcNum++) {
            scan.nextLine();
            int n = scan.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                list.add(scan.nextInt());
            }
            Collections.sort(list);
            result[tcNum] = calTime(list, n);
            scan.nextLine();
        }
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i] + "\n");
        }
    }
}