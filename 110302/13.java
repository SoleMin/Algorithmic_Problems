import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int c = input.nextInt();
        input.nextLine();
        input.nextLine();
        for (int i = 0; i < c; i++) {
            String[] arr = new String[input.nextInt()];
            input.nextInt();
            input.nextLine();
            for (int j = 0; j < arr.length; j++) {
                arr[j] = input.nextLine();
            }
            int word = input.nextInt();
            input.nextLine();
            int[][] res = new int[2][word];
            String[] arrWord = new String[word];
            for (int j = 0; j < word ; j++) {
                arrWord[j] = input.nextLine();
            }

            for (int j = 0; j < word; j++) {
                int count = 0;
                          int a = 0;
							
                for (int n = 0; n < arr.length; n++) {
									
                    for (int k = 0; k < arr[0].toCharArray().length ; k++) {
                        if (arrWord[j].charAt(0)==arr[n].charAt(k) || arrWord[j].toUpperCase().charAt(0)== arr[n].toUpperCase().charAt(k)){
                            if(checkAlpha(arr, arrWord[j], n, k, count)){
                                //arr 주변이 다음단어랑 같을시\
                                if (a==0){
                                    int saveY = n +1;
                                    int saveX = k +1;
                                    res[0][j] = saveY;
                                    res[1][j] = saveX;
                                    a++;
                                }
                                break;


                            }
                        }
                    }
                }
            }

            for (int j = 0; j < res[0].length; j++) {
                System.out.println( res[0][j] + " "+ res[1][j]);
            }
          System.out.println();
        }
    }


    private static boolean checkAlpha(String[] arr, String arrWord, int y, int x, int count) {
        if (checkAlpha1(arr,arrWord,y,x,count)){
            return true;
        } else if (checkAlpha2(arr,arrWord,y,x,count)) {
            return true;
        } else if (checkAlpha3(arr,arrWord,y,x,count)) {
            return true;
        } else if (checkAlpha4(arr,arrWord,y,x,count)) {
            return true;
        } else if (checkAlpha5(arr,arrWord,y,x,count)) {
            return true;
        } else if (checkAlpha6(arr,arrWord,y,x,count)) {
            return true;
        } else if (checkAlpha7(arr,arrWord,y,x,count)) {
            return true;
        } else if (checkAlpha8(arr,arrWord,y,x,count)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkAlpha1(String[] arr, String arrWord, int y, int x, int count) {
        count++;
        y = y-1;
        x = x-1;
        if (count >= arrWord.length()){
            return true;
        }
        try {
            if (arrWord.charAt(count)== arr[y].charAt(x)|| arrWord.toUpperCase().charAt(count)== arr[y].toUpperCase().charAt(x)){
               return checkAlpha1(arr,arrWord,y,x,count);

            }
        } catch (Exception e){
            return false;
        }
        return false;
    }
    private static boolean checkAlpha2(String[] arr, String arrWord, int y, int x, int count) {
        count++;
        y = y-1;

        if (count >= arrWord.length()){

            return true;
        }
        try {
            if (arrWord.charAt(count)== arr[y].charAt(x)|| arrWord.toUpperCase().charAt(count)== arr[y].toUpperCase().charAt(x)){
                return checkAlpha2(arr,arrWord,y,x,count);
            }
        } catch (Exception e){
            return false;
        }
        return false;
    }
    private static boolean checkAlpha3(String[] arr, String arrWord, int y, int x, int count) {
        count++;
        y =y-1;
        x = x+1;
        if (count >= arrWord.length()){

            return true;
        }
        try {
            if (arrWord.charAt(count)== arr[y].charAt(x)|| arrWord.toUpperCase().charAt(count)== arr[y].toUpperCase().charAt(x)){
               return checkAlpha3(arr,arrWord,y,x,count);
            }
        } catch (Exception e){
            return false;
        }
        return false;
    }
    private static boolean checkAlpha4(String[] arr, String arrWord, int y, int x, int count) {
        count++;
        x =x-1;
        if (count >= arrWord.length()){

            return true;
        }
        try {
            if (arrWord.charAt(count)== arr[y].charAt(x)|| arrWord.toUpperCase().charAt(count)== arr[y].toUpperCase().charAt(x)){
                return checkAlpha4(arr,arrWord,y,x,count);
            }
        } catch (Exception e){
            return false;
        }
        return false;
    }
    private static boolean checkAlpha5(String[] arr, String arrWord, int y, int x, int count) {
        count++;
        x = x+1;
        if (count >= arrWord.length()){

            return true;
        }
        try {
            if (arrWord.charAt(count) == arr[y].charAt(x)|| arrWord.toUpperCase().charAt(count)== arr[y].toUpperCase().charAt(x)){
                return checkAlpha5(arr,arrWord,y,x,count);
            }
        } catch (Exception e){
            return false;
        }
        return false;
    }
    private static boolean checkAlpha6(String[] arr, String arrWord, int y, int x, int count) {
        count++;
        y = y+1;
        x = x-1;
        if (count >= arrWord.length()){

            return true;
        }
        try {
            if (arrWord.charAt(count)== arr[y].charAt(x)|| arrWord.toUpperCase().charAt(count)== arr[y].toUpperCase().charAt(x)){
                return checkAlpha6(arr,arrWord,y,x,count);
            }
        } catch (Exception e){
            return false;
        }
        return false;
    }
    private static boolean checkAlpha7(String[] arr, String arrWord, int y, int x, int count) {
        count++;
        y = y+1;

        if (count >= arrWord.length()){

            return true;
        }
        try {
            if (arrWord.charAt(count)== arr[y].charAt(x)|| arrWord.toUpperCase().charAt(count)== arr[y].toUpperCase().charAt(x)){
                return checkAlpha7(arr,arrWord,y,x,count);
            }
        } catch (Exception e){
            return false;
        }
        return false;
    }
    private static boolean checkAlpha8(String[] arr, String arrWord, int y, int x, int count) {
        count++;
        y= y+1;
        x =x+1;
        if (count >= arrWord.length()){

            return true;
        }
        try {
            if (arrWord.charAt(count)== arr[y].charAt(x)|| arrWord.toUpperCase().charAt(count)== arr[y].toUpperCase().charAt(x)){
                return checkAlpha8(arr,arrWord,y,x,count);
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }

}