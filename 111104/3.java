import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int idx = 0;
				Turtle[] t = new Turtle[5607];
        while(input.hasNextInt()) {
					int weight = input.nextInt();
					int strength = input.nextInt();
          t[idx] = new Turtle(weight, strength);
					idx++;
        }
        Arrays.sort(t, 0, idx);
				int n = idx + 1;
        int[] array = new int[n];
			
        Arrays.fill(array, Integer.MAX_VALUE);
        array[0] = 0;
        for(int i = 1; i <= idx; ++i) {
            for(int j = idx-1; j >= 1; j--) {
							int diff = t[i-1].getStrength() - t[i-1].getWeight();
              if(diff >= array[j-1]) {
                 array[j] = Math.min(array[j], array[j-1] + t[i-1].getWeight());
              }
            }
        }
				int result = 0;
        for(int i = 0; i < idx; i++) {
            if(array[i] != Integer.MAX_VALUE) {
                result = i;
            }
        }
        System.out.print(result);
				input.close();
    }
}

class Turtle implements Comparable<Turtle> {
    int weight;
		int strength;
    public Turtle(int weight, int strength) {
        this.weight = weight;
        this.strength = strength;
    }
	 	int getWeight() {
		 return this.weight;
		}
		int getStrength() {	
	 	return this.strength;
		}
    @Override
    public int compareTo(Turtle t) {
        return this.strength-t.strength;
    }
}
