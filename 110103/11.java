import java.text.DecimalFormat;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		while(input.hasNextInt()){
			double average=0;
			double total =0;
			double SUM=0;
			int count=0;
			int Stud = input.nextInt();
			double[] array = new double[Stud];
			if(Stud ==0) break;
			
			for(int i =0;i<Stud;i++){
				double cost = input.nextDouble();
				array[i] = cost;
				input.nextLine();
			}
			if(Stud==1){
				DecimalFormat form = new DecimalFormat("0.00");
				System.out.println("$" + form.format(SUM));
				continue;
			}
			for(int i =0;i<Stud;i++){
				total +=array[i];
			}
			average = total/Stud;
			average= Math.round(average*1000)/1000.0;
			double averageSum=0;
			for(int i=0;i<Stud;i++){
				if(array[i]>average){
					averageSum +=array[i];
					count++;
				}
			}
			
			SUM=averageSum-average*count;
			
			SUM=Math.floor(SUM*100)/100;
			DecimalFormat form = new DecimalFormat("0.00");
			System.out.println("$"+form.format(SUM));
		}
	}
}