
//app.は全部けす


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//流す前にfinalにする
public final class EcRound35DApplication {

	public static void main(String[] args) {

		Input input = new Input();
		input = SystemInput();
		List<String> resultList = run(input);
		for(String result:resultList){
			System.out.println(result);
		}

	}

	//流す前にstaticにする
	private static void tester(Integer no,List<Integer> inputList,List<String> answer) {
		Input input = new Input();
		input.setInput(inputList);
		List<String> result = run(input);

		if(result.equals(answer)) {
			System.out.println("No." + no + ":OK");
		}
		else {
			System.out.println("No." + no + ":failed");
			System.out.println("result:" + result);
			System.out.println("answer:" + answer);
		}
	}

	//流す前にstaticにする
	private static Input SystemInput() {
		Input input = new Input();
		Scanner sc = new Scanner(System.in);

		List<Integer> inputList = new ArrayList<Integer>();

		while(sc.hasNextInt()) {
			inputList.add(sc.nextInt());
		}

		input.setInput(inputList);
		sc.close();
		return input;
	}

	//流す前にstaticにする
	private static List<String> run(Input input) {
		List<String> result = new ArrayList<String>();

		List<Integer> permutation = input.getPermutationList();
		Integer count;

		count = inversion(permutation);

		for(Integer i = 0;i < input.getQueryNum();i++) {
			count = count + change(input.getQuery(i));

			result.add(evenOdd(count));
		}

		return result;
	}

	//カウントする
	private static Integer inversion(List<Integer>permutation) {
		String result = new String();
		Integer inversionCount = 0;

		for(Integer i = 0; i < permutation.size(); i++) {
			for(Integer j = i + 1; j < permutation.size(); j++) {
				if(permutation.get(i) > permutation.get(j)) {
					inversionCount++;
				}
			}
		}

		return inversionCount;

	}

	//交換時追加分カウント
	private static Integer change(Query query) {
		Integer result;

		result = query.getLength() * (query.getLength() - 1) / 2;

		return result;
	}

	//判定する
	private static String evenOdd(Integer i) {
		if(i % 2 == 0) {
			return "even";
		}

		else {
			return "odd";
		}
	}



	private static class Query{
		private Integer l;
		private Integer r;

		public void setQuery(Integer l,Integer r) {
			this.l = l;
			this.r = r;
		}

		public Integer getL() {
			return l;
		}
		public void setL(Integer l) {
			this.l = l;
		}
		public Integer getR() {
			return r;
		}
		public void setR(Integer r) {
			this.r = r;
		}
		public Integer getLength(){
			return r - l + 1;
		}

	}



	//流す前にstaticにする
	private static class Input{
		private Integer length;
		private List<Integer> permutationList = new ArrayList<Integer>();
		private Integer queryNum;
		private List<Query> queryList = new ArrayList<Query>();

		public void setInput(List<Integer> inputList) {
			this.length = inputList.get(0);

			setPermutationList(inputList.subList(1, length+1));

			this.queryNum = inputList.get(length+1);

			for(Integer j = length+2; j < inputList.size()-1; j = j + 2) {
				addQueryList(inputList.get(j),inputList.get(j+1));
			}

//			checkInput();

		}

		public void checkInput() {
			System.out.println("permutation length:" + permutationList.size());

			System.out.println("permutation:" + permutationList);

			System.out.println("query length:" + queryList.size());
			System.out.println("queries:");
			for(Integer i = 0;i < queryList.size();i++) {
				System.out.println(this.getQueryL(i) + " " + this.getQueryR(i));
			}

		}

		public Integer getLength() {
			return length;
		}

		public void setLength(Integer length) {
			this.length = length;
		}

		public List<Integer> getPermutationList() {
			return permutationList;
		}

		public void setPermutationList(List<Integer> permutationList) {
			this.permutationList = permutationList;
		}

		public Integer getPermutation(Integer i) {
			return permutationList.get(i);
		}

		public void addPermutationList(Integer newPermutation) {
			this.permutationList.add(newPermutation);
		}

		public Integer getQueryNum() {
			return queryNum;
		}

		public void setQueryNum(Integer queryNum) {
			this.queryNum = queryNum;
		}

		public Query getQuery(Integer i) {
			return queryList.get(i);
		}

		public Integer getQueryL(Integer i) {
			return queryList.get(i).getL();
		}

		public Integer getQueryR(Integer i) {
			return queryList.get(i).getR();
		}

		public List<Query> getQueryList() {
			return queryList;
		}

		public void setQueryList(List<Query> queryList) {
			this.queryList = queryList;
		}

		public void addQueryList(Query newQuery) {
			this.queryList.add(newQuery);
		}

		public void addQueryList(Integer l,Integer r) {
			Query newQuery = new Query();
			newQuery.setQuery(l, r);
			addQueryList(newQuery);
		}


	}
}
