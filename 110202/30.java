import java.io.*;
import java.util.Arrays;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while ((input = br.readLine()) != null) {
			String[] arr = input.split(" ");
			String[] b = func(Arrays.copyOfRange(arr, 0, 5));
			String[] w = func(Arrays.copyOfRange(arr, 5, 10));
			b[0] = Integer.toString(func2(b[0]));
			w[0] = Integer.toString(func2(w[0]));
			int[] bi = Arrays.stream(b).mapToInt(Integer::parseInt).toArray();
			int[] wi = Arrays.stream(w).mapToInt(Integer::parseInt).toArray();
			String bw = "Black wins.";
			String ww = "White wins.";
			Boolean tie = true;
			for (int i = 0; i < bi.length; i++) {
				if (bi[i] != wi[i]) {
					System.out.println(bi[i] > wi[i] ? bw : ww);
					tie = false;
					break;
				}
			}
			if (tie) {
				System.out.println("Tie.");
			}
		}
	}
	
	static String[] func(String[] arr) {
		boolean flush;
		if (arr[0].charAt(1) == arr[1].charAt(1) && arr[1].charAt(1) == arr[2].charAt(1) && arr[2].charAt(1) == arr[3].charAt(1) && arr[3].charAt(1) == arr[4].charAt(1)) {
			flush = true;
		} else {
			flush = false;
		}
		int[] nums = new int[5];
		for (int i = 0; i < nums.length; i++) {
			switch(arr[i].charAt(0)) {
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					nums[i] = arr[i].charAt(0) - '0';
					break;
				case 'T':
					nums[i] = 10;
					break;
				case 'J':
					nums[i] = 11;
					break;
				case 'Q':
					nums[i] = 12;
					break;
				case 'K':
					nums[i] = 13;
					break;
				case 'A' :
					nums[i] = 14;
					break;
			}
		}
		Arrays.sort(nums);
		String[] snums = {Integer.toString(nums[0]), Integer.toString(nums[1]), Integer.toString(nums[2]), Integer.toString(nums[3]), Integer.toString(nums[4])};
		if (flush && nums[4] - nums[3] == 1 && nums[3] - nums[2] == 1 && nums[2] - nums[1] == 1 && nums[1] - nums[0] == 1) {
			return new String[]{"sf", snums[4]};
		} else if ((nums[1] == nums[2] && nums[2] == nums[3] && nums[3] == nums[0]) || (nums[2] == nums[3] && nums[3] == nums[4] && nums[4] == nums[1])) {
			return new String[]{"fc", snums[4]};
		} else if ((nums[0] == nums[1] && nums[1] == nums[2] && nums[3] == nums[4]) || (nums[0] == nums[1] && nums[2] == nums[3] && nums[3] == nums[4])) {
			return new String[]{"fh", snums[2]};
		} else if (flush) {
			return new String[]{"fl", snums[4]};
		} else if (nums[4] - nums[3] == 1 && nums[3] - nums[2] == 1 && nums[2] - nums[1] == 1 && nums[1] - nums[0] == 1) {
			return new String[]{"st", snums[4]};
		} else if (nums[0] == nums[1] && nums[1] == nums[2] || nums[2] == nums[3] && nums[3] == nums[4]) {
			return new String[]{"tc", snums[2]};
		} else if (nums[0] == nums[1] && nums[2] == nums[3]) {
			return new String[]{"tf", snums[2], snums[0], snums[4]};
		} else if (nums[0] == nums[1] && nums[3] == nums[4]) {
			return new String[]{"tf", snums[3], snums[0], snums[2]};
		} else if (nums[1] == nums[2] && nums[3] == nums[4]) {
			return new String[]{"tf", snums[3], snums[1], snums[0]};
		} else if (nums[0] == nums[1]) {
			return new String[]{"of", snums[0], snums[4], snums[3], snums[2]};
		} else if (nums[1] == nums[2]) {
			return new String[]{"of", snums[1], snums[4], snums[3], snums[0]};
		} else if (nums[2] == nums[3]) {
			return new String[]{"of", snums[2], snums[4], snums[1], snums[0]};
		} else if (nums[3] == nums[4]) {
			return new String[]{"of", snums[3], snums[2], snums[1], snums[0]};
		} else {
			return new String[]{"hc", snums[4], snums[3], snums[2], snums[1], snums[0]};
		}
	}
	static int func2(String a) {
		switch (a) {
			case "sf":
				return 9;
			case "fc":
				return 8;
			case "fh":
				return 7;
			case "fl":
				return 6;
			case "st":
				return 5;
			case "tc":
				return 4;
			case "tf":
				return 3;
			case "of":
				return 2;
			case "hc":
				return 1;
			default:
				return -1;
		} 
	}
}