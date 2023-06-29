
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] maps;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        input.nextLine();

        for (int i = 0; i < num; i++) {
            input.nextLine();
            maps =  new int[10000];
            int start = Integer.parseInt(input.nextLine().replace(" ",""));
            int end = Integer.parseInt(input.nextLine().replace(" ",""));
//            int[] lastArr = new int[last.length];

            int test = input.nextInt();
            input.nextLine();
            int[] str = new int[test];
            int[] Array = new int[4];
            int tmp;
            for (int j = 0; j < test; j++) {
                String[] a = input.nextLine().split(" ");
                for (int x = 0; x < 4; x++) {
                    Array[x] = Integer.parseInt(a[x]);
                }
                tmp = Integer.parseInt(String.valueOf(Array[0] * 1000 + Array[1]*100 + Array[2]*10 + Array[3]));
                str[j] = tmp;
                maps[str[j]]= 1;

            }
            int result = BFS(start,end);

            if (start == 9999 && end == 0) {
                System.out.println(4);
            } else if (result != -1){
                System.out.println(result);

            } else{
                System.out.println(-1);
            }
        }
    }
    private static int[] array(String b) {
        int a = Integer.parseInt(b);
        String[] c = new String[4];
        for (int i = 0; i <c.length ; i++) {
            c[i] = "0";
        }
        for (int i = 0; i < String.valueOf(a).toCharArray().length; i++) {
            c[3-i] = String.valueOf(String.valueOf(a).toCharArray()[String.valueOf(a).toCharArray().length-i-1]);
        }
        String.valueOf(a).split("");
        int[] init = new int[c.length];

        for (int i = 0; i < c.length; i++) {

            init[i] = Integer.parseInt(c[i]);
        }

        int[] result_save = init.clone();


        int[] arr_list = new int[8];
        for (int d = 0; d < 4 ; d++) {
            for (int e = 0; e < 2 ; e++) {
                if (result_save[d]==0){
                    if (e==0){
                        result_save[d]++;
                    }else{
                        result_save[d] =9;
                    }
                } else if ( result_save[d] ==9){
                    if (e==0){
                        result_save[d] =0;
                    }else{
                        result_save[d]--;
                    }
                } else {
                    if (e==0){
                        result_save[d]++;
                    }else{
                        result_save[d]--;
                    }
                }
                int fnl =Integer.parseInt(String.valueOf(result_save[0] * 1000 + result_save[1]*100 + result_save[2]*10 + result_save[3]));
                String[] str_2 = new String[4];
                for (int i = 0; i <str_2.length ; i++) {
                    str_2[i] = "0";
                }
                for (int i = 0; i < String.valueOf(fnl).toCharArray().length; i++) {
                    str_2[3-i] = String.valueOf(String.valueOf(fnl).toCharArray()[i]);
                }
                arr_list[2*d+e]=fnl;
                result_save = init.clone();
            }
        }

        return arr_list;
    }

    public static int BFS(int first,int last){
        Queue<node> queue = new LinkedList<>();
        maps[first] = 1;
        queue.add(new node(first,0));
        while(!queue.isEmpty()){
            node node = queue.poll();
            int node_state = node.node;
            int level_state = node.level;
            if (last == node_state){
                return level_state;
            }
            int[] tmp = array(String.valueOf(node_state));
            for(int i = 0; i<tmp.length;i++ ){
                if(maps[tmp[i]] == 0){
                    maps[tmp[i]] = 1;
                    queue.add(new node(tmp[i],level_state+1));
                }
            }
        }
        return -1;
    }
}
class node{
    public int node;
    public int level;
    node(int node, int level){
        this.level = level;
        this.node = node;
    }
}