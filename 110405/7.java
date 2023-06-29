import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Main {
	static class Node implements Comparable<Node>{
        int order=0;
        int TS=0;

        @Override
        public int compareTo(Node o) {
            if(this.TS >o.TS){
                return -1;
            }
            else if(this.TS ==o.TS){
                 if(this.order>o.order){
                    return 1;
                }
                else{
                    return -1;
                }
            }else{
                return 1;
            }
        }
    }
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);

        int testCase = input.nextInt();
        input.nextLine();
        input.nextLine();
        ArrayList<ArrayList<Node>> output = new ArrayList<>();
        while (testCase!=0){
            ArrayList<Node> out = new ArrayList<>();
            int client = input.nextInt();
            input.nextLine();
            for(int i =0;i<client;i++){
                int T=input.nextInt();
                int S=input.nextInt();
                Node node = new Node();
                node.order=i+1;
                node.TS=S/T;
                out.add(node);
                if(i!=client-1) input.nextLine();
            }

            Collections.sort(out);

            output.add(out);
            if(testCase!=1){
                input.nextLine();
                input.nextLine();
            }
            testCase--;
        }

        for(int i=0; i<output.size();i++){
            for(int j=0;j<output.get(i).size();j++){
                System.out.print(output.get(i).get(j).order);
                if(j==output.get(i).size()-1){
                    System.out.println();
                    break;
                }
                System.out.print(" ");
            }
            if(i!=output.size()-1) System.out.println();
        }

	}
}