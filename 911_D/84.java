import java.util.*;
public class inversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] values = new int[N];
        for(int i=0;i<N;i++){
            values[i] = sc.nextInt();
        }
        int query = sc.nextInt();
        int[][] tasks = new int[query][2];
        for(int i=0;i<query;i++){
            tasks[i][0] = sc.nextInt();
            tasks[i][1] = sc.nextInt();
        }
        int startinversions = 0;
        for(int i=1;i<values.length;i++){
            for(int j=i-1;j>=0;j--){
                if(values[i]<values[j]){
                    startinversions++;
                }
            }
        }
        int value = startinversions%2;
        for(int[] task : tasks){
            int n = task[1]-task[0];
            if(n*(n+1)/2 % 2 != 0){
                value = (value+1)%2;
            }
            if(value==1){
                System.out.println("odd");
            }
            else{
                System.out.println("even");
            }
        }
    }
}
