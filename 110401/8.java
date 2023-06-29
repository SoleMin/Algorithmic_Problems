import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		  Scanner input =new Scanner(System.in);

        int testCase= input.nextInt();
        ArrayList<Integer> sumlist = new ArrayList<>();
        input.nextLine();
        while (testCase!=0){
            ArrayList<Integer> house = new ArrayList();
            int Sum=0;
            int relnum = input.nextInt();
            for(int i =0;i<relnum;i++){
                house.add(input.nextInt());
            }

            Collections.sort(house);

            for(int i=0;i<house.size();i++){
                if(house.get(i)<house.get(house.size()/2))
                Sum+= house.get(house.size()/2) -house.get(i);
                else
                    Sum+=house.get(i)-house.get(house.size()/2);
            }

            sumlist.add(Sum);
            testCase--;
        }

        for(int sum : sumlist){
            System.out.println(sum);
        }
	}
}