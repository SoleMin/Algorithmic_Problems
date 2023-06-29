import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < count; i++) {
            set.add(sc.nextInt());
        }

        ArrayList<Integer> list = new ArrayList<>(set);

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i) % list.get(j) == 0 ||
                        list.get(j) % list.get(i) == 0) {
                    list.remove(j);
                    j--;
                }
            }
        }

        System.out.println(list.size());
    }
}
