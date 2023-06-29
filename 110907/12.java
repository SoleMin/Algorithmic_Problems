import java.util.Scanner;

public class Main {

    static int maxN = 100;
    static int maxE = 1000;
    static int maxName = 32;
    static int maxQueueSize = 10000;
    static int n, route_num, ne, start, finish;
    static boolean reachable;
    static int[][] edges = new int[maxE][4];
    static int[][] check = new int[maxN][2];
    static String[] city = new String[maxN];
    static int front, rear;
    static int[] queue = new int[maxQueueSize];

    static int getCity(String name){
        for (int i = 0; i < n; i++){
            if (name.equals(city[i]))
                return i;
        }
        city[n] = name;
        return n++;
    }

    static void bfs(){
        int[] now = new int[3];
        front = 0;
        rear = 0;
        reachable = false;

        for (int i = 0; i < n; i++){
            check[i][0] = 10000;
        }
        queue[rear++] = start;
        check[start][0] = 0;
        check[start][1] = 0;
        while (front < rear){
            now[0] = queue[front++];
            now[1] = check[now[0]][0];
            now[2] = check[now[0]][1];
            if (now[0] == finish){
                reachable = true;
                continue;
            }
            for (int i = 0; i < ne; i++){
                if (edges[i][0] != now[0])
                    continue;
                if (now[2] <= edges[i][2] && (check[edges[i][1]][0] > now[1] || (check[edges[i][1]][0] == now[1] && check[edges[i][1]][1] > edges[i][2] + edges[i][3]))) {
                    queue[rear++] = edges[i][1];
                    check[edges[i][1]][0] = now[1];
                    check[edges[i][1]][1] = edges[i][2] + edges[i][3];
                }
                if (now[2] > edges[i][2] && ( check[edges[i][1]][0] > now[1] || (check[edges[i][1]][0] == now[1]  && check[edges[i][1]][1] > edges[i][2] + edges[i][3]) ) ){
                    queue[rear++] = edges[i][1];
                    check[edges[i][1]][0] = now[1] + 1;
                    check[edges[i][1]][1] = edges[i][2] + edges[i][3];
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int testcase_num = scan.nextInt();
        scan.nextLine();

        for (int testcase = 0; testcase < testcase_num; testcase++){

            String name1;
            String name2;

            n = ne = 0;

            route_num = scan.nextInt();
            scan.nextLine();
            for (int route = 0; route < route_num; route++){
                String[] input = new String[4];
                input = scan.nextLine().split(" ");
                name1 = input[0];
                name2 = input[1];
                int t1 = Integer.parseInt(input[2]);
                int t2 = Integer.parseInt(input[3]);
                t1 %= 24;

                if ((t1 >= 6 && t1 < 18) || (t1 < 6 && t2 > 6 - t1) || (t1 >= 18 && t2 > 30 - t1))
                    continue;
                edges[ne][0] = getCity(name1);
                edges[ne][1] = getCity(name2);
                edges[ne][2] = (t1 + 12) % 24;
                edges[ne][3] = t2;
                ne++;
            }
            String[] input = scan.nextLine().split(" ");
            name1 = input[0];
            name2 = input[1];
            start = getCity(name1);
            finish = getCity(name2);

            bfs();

            System.out.println("Test Case " + (testcase + 1) + ".");
            if (reachable)
                System.out.println("Vladimir needs " + check[finish][0] + " litre(s) of blood.");
            else
                System.out.println("There is no route Vladimir can take.");
        }
    }
}

