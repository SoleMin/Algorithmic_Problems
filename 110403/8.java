import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Main {
	public static void main(String[] args) throws Exception {
		 Scanner input = new Scanner(System.in);
        ArrayList<Integer> Sumlist = new ArrayList<>();

        int testCase = input.nextInt();
        input.nextLine();
        input.nextLine();
        while (testCase!=0){
            ArrayList<Integer> time = new ArrayList<>();
            int Sum=0;
            ArrayList<Integer> arrive = new ArrayList<>();
            int n= input.nextInt();
            input.nextLine();

            for(int i=0;i<n;i++){
                time.add(input.nextInt());
                if(i!=n-1) input.nextLine();
            }
            Collections.sort(time);

            Sum=bridge(time,time.size());

            Sumlist.add(Sum);
            if(testCase!=1) {
                input.nextLine();
                input.nextLine();
            }
            testCase--;
        }

       for(int i=0;i<Sumlist.size();i++){
           System.out.println(Sumlist.get(i));
           if(i!=Sumlist.size()-1) System.out.println();
       }
    }
    public static int bridge(ArrayList<Integer> time,int n){


        if(n<3){
            return time.get(n-1);
        }
        else if(n==3){
            return time.get(0)+time.get(1)+time.get(2);
        }
        else{
            int Sum1 = time.get(n-1)+time.get(0)+time.get(n-2)+time.get(0);
            int Sum2 = time.get(1)+time.get(0)+time.get(n-1)+time.get(1);

            if(Sum1<Sum2){
                return Sum1+bridge(time,n-2);
            }
            else if(Sum2>Sum1){
                return Sum2+bridge(time,n-2);
            }
            else{
                return Sum2+bridge(time,n-2);
            }
        }

	}
}