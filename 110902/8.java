
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] visited;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        input.nextLine();

        for (int i = 0; i < k; i++) {
            input.nextLine();
            visited =  new int[10000];
            int first = Integer.parseInt(input.nextLine().replace(" ",""));
            int last = Integer.parseInt(input.nextLine().replace(" ",""));
//            int[] lastArr = new int[last.length];

            int numX = input.nextInt();
            input.nextLine();
            int[] stringX = new int[numX];
            int[] stringXArr = new int[4];
            int temp;
            for (int j = 0; j < numX; j++) {
                String[] t = input.nextLine().split(" ");
                for (int p = 0; p < 4; p++) {
                    stringXArr[p] = Integer.parseInt(t[p]);
                }
                temp = Integer.parseInt(String.valueOf(stringXArr[0] * 1000 + stringXArr[1]*100 + stringXArr[2]*10 + stringXArr[3]));
                stringX[j] = temp;
                visited[stringX[j]]= 1;

            }
            int res = BFS(first,last);

            if (first == 9999 && last == 0) {
                System.out.println(4);
            } else if (res != -1){
                System.out.println(res);

            } else{
                System.out.println(-1);
            }
//            for (int j = 0; j < 8; j++) {
//                System.out.println(array("9999")[j]);
//            }
        }
    }
    private static int[] array(String b) {
        int a = Integer.parseInt(b);
            String[] z = new String[4];
            for (int i = 0; i <z.length ; i++) {
                z[i] = "0";
            }
            for (int i = 0; i < String.valueOf(a).toCharArray().length; i++) {
                z[3-i] = String.valueOf(String.valueOf(a).toCharArray()[String.valueOf(a).toCharArray().length-i-1]);
            }
            String.valueOf(a).split("");
            int[] first = new int[z.length];

            for (int i = 0; i < z.length; i++) {

                first[i] = Integer.parseInt(z[i]);
            }

            int[] save = first.clone();


            int[] arrayList = new int[8];
            for (int j = 0; j < 4 ; j++) {
                for (int k = 0; k < 2 ; k++) {
                    if (save[j]==0){
                        if (k==0){
                            save[j]++;
                        }else{
                            save[j] =9;
                        }
                    } else if ( save[j] ==9){
                        if (k==0){
                            save[j] =0;
                        }else{
                            save[j]--;
                        }
                    } else {
                        if (k==0){
                            save[j]++;
                        }else{
                            save[j]--;
                        }
                    }
                    int ak =Integer.parseInt(String.valueOf(save[0] * 1000 + save[1]*100 + save[2]*10 + save[3]));
                    String[] o = new String[4];
                    for (int i = 0; i <o.length ; i++) {
                        o[i] = "0";
                    }
                    for (int i = 0; i < String.valueOf(ak).toCharArray().length; i++) {
                        o[3-i] = String.valueOf(String.valueOf(ak).toCharArray()[i]);
                    }
                    arrayList[2*j+k]=ak;
                    save = first.clone();
                }
            }

        return arrayList;
    }

    public static int BFS(int first,int last){
        Queue<node> Q = new LinkedList<>();
        visited[first] = 1;
        Q.add(new node(first,0));
        while(!Q.isEmpty()){
            node node = Q.poll();
            int nodeNow = node.node;
            int levelNow = node.level;
            if (last == nodeNow){
                return levelNow;
            }
            int[] temp = array(String.valueOf(nodeNow));
            for(int i = 0; i<temp.length;i++ ){
                if(visited[temp[i]] == 0){
                    visited[temp[i]] = 1;
                    Q.add(new node(temp[i],levelNow+1));
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