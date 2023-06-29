import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            Map<String, Integer> map = new HashMap<>();
            String[] name = new String[n];
            for (int i = 0; i < n; i++) {
                name[i] = br.readLine();
                map.put(name[i], i);
            }
            int[][] arr = new int[n][n];
            int r = Integer.parseInt(br.readLine());
            for (int i = 0; i < r; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = map.get(st.nextToken());
                int end = map.get(st.nextToken());
                arr[start][end] = 1;
                arr[end][start] = 1;
            }

//            for(int i=0; i<n; i++){
//                System.out.println(Arrays.toString(arr[i]));
//            }
//            System.out.println();


            List<String> result = new ArrayList<>();


            // i번째 노드 제외하고 탐색
            for (int i = 0; i < n; i++) {
                boolean[] visited = new boolean[n];
                visited[i] = true;
                Queue<Integer> queue = new LinkedList<>();
                if (i == 0) queue.add(1);
                else queue.add(0);
                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if (arr[current][j] == 1 && !visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }

                for (int j = 0; j < n; j++) {
                    if (!visited[j]) {
                        result.add(name[i]);
                        break;
                    }
                }
            }
            Collections.sort(result);
            if (n == 2) result = new ArrayList<>();
//            System.out.println(result);

            System.out.printf("City map #%d: %d camera(s) found\n", testCount, result.size());
            for (String s : result) {
                System.out.println(s);
            }


            System.out.println();


            testCount++;
        }


    }
}

