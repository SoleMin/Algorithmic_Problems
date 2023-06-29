import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	  public static int power(int p){
        if(p==4) return 10000;
        if(p==3) return 1000;
        if(p==2) return 100;
        if(p==1) return 10;
        return 1;
    }
    public static int mknum(int c[]){
        int ret =0;
        ret += c[0]*1000;
        ret += c[1]*100;
        ret += c[2]*10;
        ret += c[3];
        return ret;
    }
	
	public static void main(String[] args) throws Exception {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        br.readLine();
        while ( tc-- !=0){
            String[] input;
            int[] press = new int[10000+10];
            boolean[] visited = new boolean[10000 + 10];
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0;i<press.length;i++){
                press[i] = 0;
            }
            for(int i =0;i<visited.length;i++){
                visited[i] = false;
            }
            int number = 0;

            input = br.readLine().split(" ");
            number +=(Integer.parseInt(input[0])*power(3));
            number +=(Integer.parseInt(input[1])*power(2));
            number +=(Integer.parseInt(input[2])*power(1));
            number +=(Integer.parseInt(input[3])*power(0));

            press[number] = 0;
            queue.offer(number);

            int destination =0;

                input = br.readLine().split(" ");
                destination +=(Integer.parseInt(input[0])*power(3));
                destination +=(Integer.parseInt(input[1])*power(2));
                destination +=(Integer.parseInt(input[2])*power(1));
                destination +=(Integer.parseInt(input[3])*power(0));


            int n;
            n=Integer.parseInt(br.readLine());
            for(int i=0;i<n;i++){
                number= 0;
                input = br.readLine().split(" ");
                number +=(Integer.parseInt(input[0])*power(3));
                number +=(Integer.parseInt(input[1])*power(2));
                number +=(Integer.parseInt(input[2])*power(1));
                number +=(Integer.parseInt(input[3])*power(0));
                visited[number] = true;
            }
            boolean resultFound = false;

            while (!queue.isEmpty()){
                number = queue.poll();
                if(visited[number] == true) continue;
                visited[number] = true;

                if(number==destination){
                    resultFound = true;
                    break;
                }

                int[] child = new int[4];
                child[3] = number%10;
                child[2] = (number%100)/10;
                child[1] = (number%1000)/100;
                child[0] = number/1000;

                for(int i=0;i<4;i++){
                    child[i] +=1;
                    child[i] %=10;
                    int num = mknum(child);
                    if(visited[num] == false)
                        queue.offer(num);
                    press[num] = press[number]+1;

                    child[3] = number%10;
                    child[2] = (number%100)/10;
                    child[1] = (number%1000)/100;
                    child[0] = number/1000;
                }
                for(int i=0;i<4;i++){
                    child[i] -= 1;
                    if(child[i]==-1) child[i] =9;
                    int num = mknum(child);
                    if(visited[num] == false)
                        queue.offer(num);
                    press[num] = press[number]+1;

                    child[3] = number%10;
                    child[2] = (number%100)/10;
                    child[1] = (number%1000)/100;
                    child[0] = number/1000;
                }
            }
        if(resultFound) System.out.printf("%d\n",press[destination]);
        else System.out.println("-1");
        br.readLine();
        }

	}
}