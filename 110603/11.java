import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


class Main {
	 public static class Counting{
        public ArrayList<BigInteger> list;
        int count;
        int[] num = {1,2,3,1};

        public void SetList(int number){
            list=new ArrayList<>();
            for(int i=1;i<=3;i++){
                count=0;
                Set(i);
                list.add(new BigInteger(""+count));
            }

            for(int i=4;i<=number;i++){
                list.add(list.get(i-2).add(list.get(i-2)).add(list.get(i-3)).add(list.get(i-4)));
            }
        }

        public void Set(int k){
            for(int i=0;i<num.length;i++){
                int temp = k-num[i];

                if(temp==0) count++;
                else if(temp>0){
                    Set(temp);
                }
            }
        }
    }
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		 ArrayList<BigInteger> list = new ArrayList<>();
        Counting counting = new Counting();

        while (input.hasNextLine()){
        int number = input.nextInt();
        counting.SetList(number);
        list.add(counting.list.get(number-1));
        if(input.hasNextLine()) input.nextLine();
        }
        for(BigInteger a: list){
            System.out.println(a);
        }
	}
}