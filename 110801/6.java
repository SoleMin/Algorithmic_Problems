
import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf;
        StringTokenizer token;
        int map, bishops, answer;
        int [][] mapArr;
        while(true) {
            buf = br.readLine();
            token = new StringTokenizer(buf);
            map = Integer.parseInt(token.nextToken());
            bishops = Integer.parseInt(token.nextToken());
            if (map == 0 && bishops == 0)
                break;
            else
                result = 0;
            mapArr = new int[bishops][2];
            littleBishop(0, bishops, mapArr, map, 0, 0);
            System.out.println(result);

        }
    }
    public static void littleBishop(int count, int bishops, int [][] mapArr, int map, int row, int col) {
        int j = row;
        if (count == bishops) {
            result++;
            return;
        }
        for (int i = col; i < map; i++) {
            for (; j < map; j++) {
                mapArr[count][0] = i;
                mapArr[count][1] = j;
                if (possible(count, mapArr))
                    littleBishop(count + 1, bishops, mapArr, map, j, i);
            }
            j = 0;
        }
    }
    public static boolean possible (int count, int [][] mapArr) {
        for (int i = 0; i < count; i++)
            if (Math.abs(mapArr[count][0] - mapArr[i][0]) == Math.abs(mapArr[count][1] - mapArr[i][1]))
                return false;
        return true;
    }
}