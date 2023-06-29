import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caseI = input.nextInt();
        input.nextLine();
        input.nextLine();
        for (int j = 0; j < caseI; j++) {
            String cents = input.nextLine();
            String[] centsArr = cents.split(" ");
            int[] centArr = new int[centsArr.length];
            for (int i = 0; i < centsArr.length; i++) {
                centArr[i] = Integer.parseInt(centsArr[i]);
            }

            ArrayList<ArrayList<String>> photos = new ArrayList<>();

            while (input.hasNextLine()) {
                String s = input.nextLine();
                if(s.equals("")){
                    break;
                }
                ArrayList<String> array = new ArrayList<>();
                String[] temp = s.split(" ");
                for (int i = 0; i < temp.length; i++) {
                    array.add(temp[i]);
                }
                photos.add(array);
            }
            ArrayList<String> checkName = new ArrayList<>();
            for (int i = 0; i < photos.size(); i++) {
                if (!checkName.contains(photos.get(i).get(0))) checkName.add(photos.get(i).get(0));
            }
            ArrayList<String> checkTime = new ArrayList<>();
            ArrayList<ArrayList<String>> sortedByTimePhotos = new ArrayList<>();
            for (int i = 0; i < photos.size(); i++) {
                checkTime.add(photos.get(i).get(1).replace(":",""));
            }

            Collections.sort(checkTime);
            Collections.sort(checkName);
            for (int i = 0; i <  checkTime.size(); i++) {
                for (int k = 0; k < photos.size() ; k++) {
                    if (checkTime.get(i).equals(photos.get(k).get(1).replace(":",""))){
                        sortedByTimePhotos.add(photos.get(k));
                    }
                }
            }


            for (int i = 0; i < checkName.size() ; i++) {
                double resultMoney = 2.00;

                ArrayList<ArrayList<String>> removedAnotherNamePhotos = new ArrayList<>();

                for (int z = 0; z < sortedByTimePhotos.size() ; z++) {
                    if (checkName.get(i).equals(sortedByTimePhotos.get(z).get(0))){
                        removedAnotherNamePhotos.add(sortedByTimePhotos.get(z));
                    }
                }
                if ( removedAnotherNamePhotos.size() ==1){

                } else {
                    boolean isCheck = false;
                    for (int k = 0; k < removedAnotherNamePhotos.size()-1; k++) {
                        if (removedAnotherNamePhotos.get(k).get(2).equals("enter") && removedAnotherNamePhotos.get(k+1).get(2).equals("exit"))
                        {
                            int km = Math.abs(Integer.parseInt(removedAnotherNamePhotos.get(k).get(3)) - Integer.parseInt(removedAnotherNamePhotos.get(k+1).get(3)));
                            String[] time = removedAnotherNamePhotos.get(k).get(1).split(":");
                            double temp = centArr[Integer.parseInt(time[2])]/100.00;
                            resultMoney = resultMoney +  (km * temp);
                            resultMoney = resultMoney + 1.00;
                            isCheck = true;
                        }
                    }
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    if (isCheck){
                        System.out.println(removedAnotherNamePhotos.get(0).get(0) + " $" + decimalFormat.format(resultMoney));

                    }
                }
            }
            System.out.println();
        }
    }
}
