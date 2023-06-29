import java.util.*;

public class Main {
    final int INF = Integer.MAX_VALUE / 2;
    private void doit(){
        Scanner sc = new Scanner(System.in);
        //while(sc.hasNext()){
            int n = sc.nextInt();
            if(n == 0){
                System.out.println("0 0 0");
            }
            else if(n == 1){
                System.out.println("0 0 1");
            }
            else{
                //create a fib
                ArrayList<Integer> fibList = new ArrayList<Integer>();
                int pre = 0;
                int next = 1;
                fibList.add(pre);
                fibList.add(next);
                while(next != n){
                    int temp = next;
                    next +=pre;
                    fibList.add(next);
                    pre = temp;
                }
                int len = fibList.size();
                int a = fibList.get(len-4);
                int b = fibList.get(len-3);
                int c = fibList.get(len-3);
                System.out.println(a + " " + b + " " + c);
            }
        //}
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.doit();
    }
}