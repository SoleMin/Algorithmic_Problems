import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int casenum = input.nextInt();
		input.nextLine();
		input.nextLine();
		for(int i=0; i<casenum; i++){
			String buf = input.nextLine();
			String[] sen = buf.split(" ");
			int[] centArr = new int[sen.length];
			for(int j=0; j<sen.length; j++){
				centArr[j] = Integer.parseInt(sen[j]);
			}
			ArrayList<ArrayList<String>> photolist = new ArrayList<>();
			
			while(input.hasNextLine()){
				String s = input.nextLine();
				if(s.equals("")){
					break;
				}
				ArrayList<String> array = new ArrayList<>();
				String[] temp = s.split(" ");
				for(int k = 0; k<temp.length; k++){
					array.add(temp[k]);
				}
				photolist.add(array);
			}
			ArrayList<String> check_name = new ArrayList<>();
			for(int m=0; m<photolist.size(); m++){
				if(!check_name.contains(photolist.get(m).get(0))) check_name.add(photolist.get(m).get(0));
			}
			ArrayList<String> check_time = new ArrayList<>();
			ArrayList<ArrayList<String>> time_photo = new ArrayList<>();
			for(int m =0; m<photolist.size(); m++){
				check_time.add(photolist.get(m).get(1).replace(":",""));
			}
			Collections.sort(check_name);
			Collections.sort(check_time);
			
			for(int m=0;m< check_time.size();m++){
				for(int n=0; n<photolist.size(); n++){
					if(check_time.get(m).equals(photolist.get(n).get(1).replace(":",""))){
						time_photo.add(photolist.get(n));
					}
				}
			}
			for(int l=0; l<check_name.size();l++){
				double money = 2.00;
				ArrayList<ArrayList<String>> remove_photo = new ArrayList<>();
				
				for(int z=0; z<time_photo.size(); z++){
					if(check_name.get(l).equals(time_photo.get(z).get(0))){
						remove_photo.add(time_photo.get(z));
					}
				}
				if(remove_photo.size() == 1){
				}
				else {
					boolean isCheck = false;
					for(int k=0; k<remove_photo.size()-1; k++){
						if(remove_photo.get(k).get(2).equals("enter")&& remove_photo.get(k+1).get(2).equals("exit")){
							int km = Math.abs(Integer.parseInt(remove_photo.get(k).get(3)) - Integer.parseInt(remove_photo.get(k+1).get(3)));
							String[] time = remove_photo.get(k).get(1).split(":");
							double temp = centArr[Integer.parseInt(time[2])]/100.00;
							money = money + (km * temp);
							money = money + 1.00;
							isCheck = true;													 
						}
					}
					DecimalFormat decimalFormat = new DecimalFormat("0.00");
					if(isCheck){
						System.out.println(remove_photo.get(0).get(0) + " $" + decimalFormat.format(money));
					}
				}
			}
			System.out.println();
		}
	}
}