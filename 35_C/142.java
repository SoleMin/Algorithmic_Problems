import java.util.Scanner;
import java.util.HashSet;
import java.io.PrintWriter;
import java.io.File;
public class FireAgain {

    public static void main(String[] args){
	
	File in = new File("input.txt");
	File out = new File("output.txt");
	Scanner sc;
	PrintWriter pw;
	try{
	    sc = new Scanner(in);
	    pw = new PrintWriter(out);
	}catch(Exception e){
	    sc = new Scanner(System.in);
	    pw = null;
	}

	int max_x = sc.nextInt();
	int max_y = sc.nextInt();
	int start_num = sc.nextInt();
	HashSet<int[]> start = new HashSet<int[]>();
	for(int i=0; i<start_num; i++){
	    int[] cell = new int[2];
	    cell[0] = sc.nextInt();
	    cell[1] = sc.nextInt();
	    start.add(cell);
	}

	int[] result = new int[]{1,1};
	int resultLen = 0;
	for(int i=1; i<=max_x; i++){
	    for(int j=1; j<=max_y; j++){
		int[] sh = new int[]{1,1};
		int shLen = Integer.MAX_VALUE;
		for(int[] fired: start){
		    int len = Math.abs(i - fired[0]) + Math.abs(j - fired[1]);
		    if(len < shLen){
			sh[0] = i;
			sh[1] = j;
			shLen = len;
		    }
		}
		if(shLen > resultLen){
		    result[0] = sh[0];
		    result[1] = sh[1];
		    resultLen = shLen;
		}
	    }
	}
	pw.print(result[0] + " " + result[1]);
	pw.close();
	return ;
    }
}  