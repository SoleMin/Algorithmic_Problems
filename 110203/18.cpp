# include <iostream>
# include <set>
# define MAX_SIZE (100)

using namespace std;

static int hartals[MAX_SIZE];

int main() {
	
	int test_case = 0;
	cin >> test_case;
	
	while ( test_case-- > 0){
		set <int> s;
		
		/*입력처리*/
		int n = 0;
		cin >> n;
		
		int p = 0;
		cin >> p;
		
		for (int p_index = 0; p_index < p; p_index++){
			cin >> hartals[p_index];
		}
		/*입력처리*/
		
		/*집합을 통해 정당이 쉬는 요일 파악*/
		for(int p_index = 0; p_index < p; p_index++){
			int multiple_num = 1;
			
			/*휴일 지수의 배수가 시뮬레이션 하고자 하는 일자의 이하인 경우를 집합의 푸쉬*/
			while (hartals[p_index] * multiple_num <= n){
				/*핸들링 조건 : 금요일 또는 토요일은 동맹 휴업이 없다.*/
				if( ((hartals[p_index] * multiple_num) % 7 != 0) &&
				  	((hartals[p_index] * multiple_num) % 7 != 6) ){
						s.insert(hartals[p_index] * multiple_num);
				}
				multiple_num++;	//배수를 위한 카운터 증가
			}
		}
		/*집합을 통해 정당이 쉬는요일 파악*/
		
		cout << s.size() << '\n';
	}	//EOW(test_case)
	
	return 0;
}