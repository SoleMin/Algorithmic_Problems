#include <iostream>
# include <stdlib.h>
# include <string>
#include <cmath>
#define MAX_SIZE (1000)

using namespace std;

static double student_money[MAX_SIZE];	//학생들이 지불한 금액
//static int flag_money[MAX_SIZE]; // 계산에 사용될 각 학생마다의 기준 금액

/*
	평균 구하고 분산구하는 문제?
	단순 분산이기 보다는 돈을 넘겨주는 개념이다.
	결국 평균과의 떨어진 정도를 다뤄야 하는 건 동일하다.
	다만 돈을 넘겨주기 때문에 평균 이상인 값들에 대한 분산의 합을 구하면 끝
	
	1센트 단위 내에서 같아야 한다는 조건이 걸린다.
	조건에 전달 되는 최소 액수가 있다.
	평균 보다 큰 값들에 대한 분산의 합이므로 평균을 2번째 자리까지 올려서 다뤄야한다.
	
	부동 소수점 정밀도 문제 어카냐....
	
	1. 라이브러리 쓰지 말고 형병환을 이용해서 해보자
		=> 동일한 문제 발생
		
	2. float 형을 쓰지말고 int 형으로 처리해보자.
		=> 부분적으로 float형 사용이 강제되므로 동일한 문제 발생
		=> 부분적으로 사용하는 부분이 입력을 받는 순간임
		=> 입력 받는 순간 자료형 implicit 캐스팅을 통해서 적절하게 형 변환을 한다면?
	
	3. 앗싸리 문자열로 처리하기?
		=> 니가 마지막 희망이다... 제발 되줘 제발
	
	
*/

int main() {
	int n = 0;
	
 	while( true ){
		
 		double sum = 0;
 		cin >> n;
// 		double student_money[MAX_SIZE] = {0, };
		
 		if (n == 0){
 			break;
 		}
		
//  		for(int i = 0; i < n; i++){
//  			int cur_money = 0;
// 			cin >> get_money;
			
//  			for (int index = 0; index < get_money.length(); index++){
//  				if (get_money[index] == '.'){
//  					continue;
// 				}
//  				else {
//  					cur_money *= 10;
//  					cur_money += get_money[index] - '0';
//  				}
//  			}
			
//  			student_money[i] = cur_money;
//  			sum += student_money[i];
//  		}
		
//  		int average = sum/n;
		
//  		int answer = 0;
//  		for (int i = 0; i < n; i++){
//  			if (student_money[i] <= average) {
//  				answer += average - student_money[i];
//  			}
//  		}
		
// 		char tc[10];
// 		int k_index = 0;
		
// 		while (answer != 0) {
// 			tc[k_index] = (answer % 10) + '0';
// 			k_index++;
// 			answer /= 10;
// 		}
		
// 		k_index--;
		
// 		cout << '$';
// 		if (k_index == -1){
// 			cout << "0.00";
// 		}
// 		for (int k = k_index; k >= 0; k--) {
// 			if (k == 1) {
// 				cout << '.';
// 			}
			
// 			cout << tc[k];
// 		}
// 		cout << '\n';
 		//printf("$%.2f\n", (float)answer / 100);
		
		/*
			평균을 구하고, 학생이 낸돈에서 하는 것은 정밀도 오차가 난다.
			다르게 설계해보자.
			
			sum에 있는 총 돈을 달러 단위로 먼저 분배한다.
			어짜피 문제는 cent 처리에 있다.
			한 번 생각해보자...
			1센트 내외로 분배하기 떄문에, 남은 센트들을 학생들한테 1센트씩 반복해서 준다치자.
			0번 학생부터 n번 학생한테까지 1센트씩 주다가 끊겨도, 1센트내외의 오차다.
			
			그것부터 해보자. sum을 각 학생들에 맞게 나누기
			오케이 굿
			
			이제 제발 되라..
		*/
		
		// int average = sum/n;
		//cout << "sum => " << sum << endl;	//average가 곧 소모한 doleer와 같은 값을 가짐 => 그러면 나머지는 cent나오겠네 근데 이거 어케쓰지...
		//cout << " dolor => " << sum/n << endl;
		//cout << " cent => " << sum%n << endl;
		//average = average;
		//cout << "avg => " << average << endl;
		
		// double answer = 0;
		// for (int i = 0; i < n; i++){
		// 	if(student_money[i] < average){
		// 		answer += average - used_money[i];
		// 	}
		// }
		
// 		int doller = sum/n;
// 		for (int i = 0; i < n; i++){
// 			flag_money[i] = doller;
// 		}
		
// 		int cent = sum%n;
// 		for (int i = 0; i < cent; i++){
// 			flag_money[i] += 1;
// 		}
		
		// for (int i = 0; i < n; i++){
		// 	cout << "student[" << i << "] => " << flag_money[i] << endl;
		// }
// 		int answer = 0;
		
// 		for(int i = 0; i < n; i++){
// 			answer += abs(student_money[i] - flag_money[i]);
// 		}
		
		// cout << "before divide =>" << answer << endl;
		// cout << "after divide =>" << answer/2 << endl;
		// answer /= 2;
		// printf("$%.2lf\n", answer/100.0);
		
		
		/*==================================*/
		for(int i = 0; i < n; i++){
			cin >> student_money[i];
			sum += student_money[i];
		}
		
		double average = sum/(double)n;
		average = ceil((average*100))/100.0;
		double answer = 0;
		for (int i = 0; i < n; i++){
			if(student_money[i] >= average){
				answer += student_money[i] - average;
			}
		}
		
		printf("$%.2lf\n", answer);
		
		
	} // EOW
	
	return 0;
}