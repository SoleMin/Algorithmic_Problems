# include <iostream>
# include <string>
# include <vector>
# include <sstream>
# include <queue>

using namespace std;

static string full_text = "";

/*
	일단 하나의 string에 입력 다 넣기
	
	space기준으로 스플릿 하되, 판단해야 하는 것
	1. 다음 토큰을 추가 했을때 72글자가 넘는가?
	2. 빈 문자 라인은 어떻게 판단할 것인가. string으로 합치면 구분이 안 될 텐데
	3. 문장 시작이 공백 문자로 시작되면 스플릿이 이상하게 될 텐데 어떻게 처리 할 것인가?
	
	예외 처리 하 것
	1. 다음 토큰의 길이가 72를 초과하면 단독출력 해야 함
	
	※아이디어
	del토큰인 ' '가 들어왔을 때 토글 스위치를 On 줄바꿈이 아닌이상 스플릿 된 토큰을 계속추가 => 토큰 추가 과정에서 72자 초과 되면 토글 off.
	3번 문제는 해결이 되었다. 결국은 토큰 추가시 72자 넘은지 핸들링하면 자연스레 처리 될 일이였다.
	
	2번 문제는 입력 처리 과정에서 빈 문자열일 경우 '\n'와 같은 이스케이프 문을 string에 저장해서 읽을 때 판단을 하는 등의 처리를 하면 해결 될 것 같다.
	
	그냥 빈 문자열 단위로 처리하는게 훨씬 쉽겠다.
	
	왜 실행 이상하게 꼬이지
	마지막에 공백문자 들어가서 그런가?
	뭐지 입력 처리가 왜 안될까
	
	다시짜야겠네....ㅎ
	
*/

void fmt() {
	stringstream ss(full_text);
	vector<string> tokens;
	queue<string> que;
	string token;
	int long_flag = 0;
	int print_flag = 0;
	
	while(getline(ss, token, ' ')) {
		//tokens.push_back(token);
		que.push(token);
	}
	
	string print_line = "";
	
	while(!que.empty()){
		//cout << "in" << endl;
		string temp = que.front();
		//cout << "Tok => " << temp << endl;
		

		if(print_line.size() + temp.size() > 72 && print_line.size() >= 1){
			print_line.erase(0, 1);
			cout << print_line << endl;
			print_line = "";
		}
		
		else if(print_line.size() + temp.size() <= 72){
			print_line +=  ' ' + temp;
			que.pop();
		}
		
		else if(temp.size() >= 72){
			if(print_line.size() != 0){
				cout << print_line << endl;
				print_line = "";
			}
			cout << temp << endl;
			que.pop();
		}
	}
	
	if(print_line.size() != 0){
		print_line.erase(0, 1);
		cout << print_line << endl;
	}
// 	for (int i = 0; i < tokens.size(); i++) {
		
// // 		if(tokens[i].size() == 0){
// // 			//cout << "IN" << endl;
// // 			tokens[i] = '@';
// // 		}
		
//  		//cout << "Cur Tok => " << tokens[i] << endl;
// 		// if (print_line.length() + tokens[i].length() > 72)	 {
// 		// 	cout << print_line << endl;
// 		// 	print_line = tokens[i] + '@';
// 		// }
// 		// else if (print_line.length() + tokens[i].length() <= 72) {
// 		// 	print_line += tokens[i] + '@';
// 		// }
// 		if(tokens[i].size() > 72){
// 			//cout << print_line << endl;
// 			print_flag = 1;
// 			cout << tokens[i] << endl;
// 			print_line = "";
// 			long_flag = 1;
// 		}
// 		else if (i == 0) {
// 			if(tokens[i].length() > 71){
// 				//cout << "Part => ";
// 				print_flag = 1;
// 				cout << tokens[i] << endl;
// 			}
// 			else {
// 				// if(tokens[i].size() == 0){
// 				// 	print_line += ' ';
// 				// }
// 				//else{
// 					print_line += tokens[i];
// 				//}
// 			}
// 		}
// 		else if (i == tokens.size() - 1){
// 			if(print_line.length() + tokens[i].length() > 71){
// 				print_flag = 1;
// 				cout << print_line << endl;
// 				cout << tokens[i] << endl;
// 			}
// 			else {
// 				print_flag = 1;;
// 				print_line += ' ' + tokens[i];
// 				cout << print_line << endl;
// 			}
// 		}
// 		else {
// 			if(print_line.length() + tokens[i].length() > 71) {
// 				print_flag = 1;
// 				cout << print_line << endl;
// 				print_line = tokens[i];
// 			}
// 			else {
// 				// if(print_line.size() == 0){
// 				// 	// cout << "@[" << tokens[i] << "]";
// 				// 	// if(tokens[i].size() == 0){
// 				// 	// 	print_line += ' ';
// 				// 	// }
// 				// 	// else{
// 				// 		print_line += tokens[i];
// 				// 	//}
// 				// }
// 				if(long_flag){
// 					long_flag = 0;
// 					print_line += tokens[i];
// 				}
// 				else {
// 					print_line += ' ' + tokens[i];
// 				}
// 			}
// 		}
// 	}
	
// 	if(print_flag == 0){
// 		cout << print_line << endl;
// 	}
	
	//cout << print_line << endl;
}

int main() {
	string input;
	int end_flag = 0;
	
	while (getline(cin, input)) {
		
		//cout << "Cur line => " << input << endl;
		if(end_flag == 1 && input == ""){
			break;
		}
		
		if (!(input == "")) {
			end_flag = 0;
			full_text += input + ' ';
			continue;
		}
		// if (input == "") {
		// 	//cout << "IN1" << endl;
		// 	if (end_flag == 1) {
		// 		//cout << "IN2" << endl;
		// 		full_text = "";
		// 		break;
		// 	}
		// 	end_flag = 1;	
		// }
		
		//cout << "FUll => " << full_text << endl;
		
		//cout << "P1" << endl;
 		fmt();
 		end_flag = 1;
		
 		cout << endl;
 		full_text = "";
	}
	//cout << "last => " << full_text << endl;
	fmt();
	
	return 0;
}