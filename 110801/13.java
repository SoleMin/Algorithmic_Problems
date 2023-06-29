import java.util.*;

public class Main {
    static int n;
    static int k;
    static int count;
    static int[] posCount;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(sc.hasNext()) {
            n = sc.nextInt();
            k = sc.nextInt();

            if(n == 0 && k == 0) {
                break;
            }

            count = 0;

            if((n == k) || (n + n - 2) >= k) {
                for(int i = 0; i < n; i++) {
                    int[] position = new int[k];
                    int[] posCount = new int[n];
                    backtrack(position, 0, i, posCount);
                }
            }

            System.out.println(count);
        }

        sc.close();
    }

    static void backtrack(int[] position, int index, int pos, int[] posCount) {
        position[index] = pos;
        if(++posCount[pos] > n) {
            return;
        }

        if(index == position.length-1) {
            // 성공적으로 인덱스를 배치했을 경우. 백트래킹을 한번 더 함.
            for(int i = 0; i < n; i++) {
                int[] chess = new int[k];
                backtrack2(chess, 0, i, position);
            }
            return;
        }

        for(int i = pos; i < n; i++) {
            backtrack(position,index+1, i, posCount.clone());
        }
    }

    static void backtrack2(int[] chess, int index, int pos, int[] position) {
        chess[index] = pos;

        for(int i = 0; i < index; i++) {
            if(Math.abs(position[index] - position[i]) == Math.abs(chess[index] - chess[i])) {
                return;
            }
        }

        if(index == chess.length-1) {
            count++;
            return;
        }

        for(int i = position[index] == position[index+1] ? pos+1 : 0; i < n; i++) {
            backtrack2(chess, index+1, i, position);
        }
    }
}