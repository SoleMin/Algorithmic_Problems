
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class A {

    static class Entity implements Comparable {

        public Entity(int x, int a) {
            this.x = x;
            this.a = a;
        }
        public int x, a;

        public int compareTo(Object t) {
            Entity o = (Entity) t;
            return x == o.x ? 0 : x < o.x ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), t = 2 * scanner.nextInt();
        if (1 == n) {
            System.out.println(2);
        } else {
            int rez = 2;
            ArrayList<Entity> list = new ArrayList<Entity>();
            for (int i = 0; i < n; i++) {
                list.add(new Entity(scanner.nextInt(), scanner.nextInt()));
            }
            Collections.sort(list);
            for (int i = 1; i < n; i++) {
                int num = 2 * (list.get(i).x - list.get(i - 1).x)
                        - list.get(i).a - list.get(i - 1).a;
                if (t < num) {
                    rez += 2;
                } else if (t == num) {
                    rez++;
                }
            }
            System.out.println(rez);
        }
    }
}
