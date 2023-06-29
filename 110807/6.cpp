#include <map>
#include <iostream>
#include <string>
#define FINAL_POS "034305650121078709a90121"
#define MAX_DEPTH 9
#define LEFT_WHL_CLKWISE 		 1
#define RIGHT_WHL_CLKWISE 		 2
#define LEFT_WHL_ANTI_CLKWISE  3
#define RIGHT_WHL_ANTI_CLKWISE 4

using namespace std;

string  read_input();
string leftwheel_clockwise_rotation(string curr_posrent_pos);
string rightwheel_clockwise_rotation(string curr_posrent_pos);
string leftwheel_counterclockwise_rotation(string curr_posrent_pos);
string rightwheel_counterclockwise_rotation(string curr_posrent_pos);
void backtrack_and_solve(int previous, int solution_depth, string curr_pos, string sequence);
void create_first_rotation(int previous, int solution_depth, string curr_pos, string sequence);
inline bool valid_solution(string &solution,map<string,string> &sequence_map,string &curr_pos,string &sequence);


map<string, string> sequence_map ;

string solution;



int main()
{
    int count;
    cin >> count;

    create_first_rotation(0, 0, FINAL_POS, "");

    for (int i = 0; i < count; i++){
        string s = "";
		  s = read_input();

        if(s !=  FINAL_POS){
            solution = "0";
            backtrack_and_solve(0, 0, s, "");
            if(solution != "0")
                cout << solution << endl;
            else
                cout << "NO SOLUTION WAS FOUND IN 16 STEPS" << endl;
        }else{
            cout << "PUZZLE ALREADY SOLVED" << endl;
            continue;
        }

    }

    return 0;

}

string  read_input(){
     string input; 
    for (int i = 0; i < 24; i++)
    {
      int a;
      cin >> a;
      if(a == 10){
        input += 'a';
      }else{
        input += '0' + a;
		}
    }
	 return input;
}

string leftwheel_clockwise_rotation(string current_pos)
{
    char swap_1 ,swap_2;
    swap_1 = current_pos[10];
    swap_2 = current_pos[11];
	 //Perform the rotation
    for (int i = 11; i >= 2; i--){
        current_pos[i] = current_pos[i-2];
	 }
	 //Write back overwrriten position
    current_pos[0] = swap_1;
    current_pos[1] = swap_2;

    current_pos[21] = current_pos[9];
    current_pos[22] = current_pos[10];
    current_pos[23] = current_pos[11];

    return current_pos;
}

string rightwheel_clockwise_rotation(string current_pos)
{
    char swap_1 ,swap_2;
    swap_1 = current_pos[12];
    swap_2 = current_pos[13];
	 //Perform the rotation
    for (int i = 14; i <= 23; i++){
        current_pos[i-2] = current_pos[i];
	 }
	 //Write back overwrriten position
    current_pos[22] = swap_1;
    current_pos[23] = swap_2;

    current_pos[9] = current_pos[21];
    current_pos[10] = current_pos[22];
    current_pos[11] = current_pos[23];

    return current_pos;
}

string leftwheel_counterclockwise_rotation(string current_pos)
{
    char swap_1 ,swap_2;
    swap_1 = current_pos[0];
    swap_2 = current_pos[1];
	 //Perform the rotation
    for (int i = 2; i <= 11; i++){
        current_pos[i-2] = current_pos[i];
	 }
	 //Write back overwrriten position
    current_pos[10] = swap_1;
    current_pos[11] = swap_2;

    current_pos[21] = current_pos[9];
    current_pos[22] = current_pos[10];
    current_pos[23] = current_pos[11];

    return current_pos;
}

string rightwheel_counterclockwise_rotation(string current_pos)
{
    char swap_1 ,swap_2;
    swap_1 = current_pos[22];
    swap_2 = current_pos[23];
	 //Perform the rotation
    for (int i = 23; i >= 14; i--){
        current_pos[i] = current_pos[i-2];
	 }
	 //Write back overwrriten position
    current_pos[12] = swap_1;
    current_pos[13] = swap_2;

    current_pos[9] = current_pos[21];
    current_pos[10] = current_pos[22];
    current_pos[11] = current_pos[23];

    return current_pos;
}

void create_first_rotation(int previous, int solution_depth, string curr_pos, string sequence)
{
    if(solution_depth == MAX_DEPTH)
        return;

    if(!sequence_map.count(curr_pos) || sequence_map[curr_pos].size() > sequence.size() || (sequence_map[curr_pos].size() == sequence.size() && sequence_map[curr_pos] > sequence))
        sequence_map[curr_pos] = sequence;

    if(previous != LEFT_WHL_CLKWISE){
        create_first_rotation(LEFT_WHL_ANTI_CLKWISE,solution_depth+1,leftwheel_counterclockwise_rotation(curr_pos), '1'+sequence);
	 }
    if(previous != RIGHT_WHL_CLKWISE){
        create_first_rotation(RIGHT_WHL_ANTI_CLKWISE,solution_depth+1,rightwheel_counterclockwise_rotation(curr_pos), '2'+sequence);
	 }
    if(previous != LEFT_WHL_ANTI_CLKWISE){
        create_first_rotation(LEFT_WHL_CLKWISE,solution_depth+1,leftwheel_clockwise_rotation(curr_pos), '3'+sequence);
	 }
    if(previous != RIGHT_WHL_ANTI_CLKWISE){
        create_first_rotation(RIGHT_WHL_CLKWISE,solution_depth+1,rightwheel_clockwise_rotation(curr_pos), '4'+sequence);
	 }
}

void backtrack_and_solve(int previous, int solution_depth, string curr_pos, string sequence)
{
    if(solution_depth == MAX_DEPTH)
        return;

    if(sequence_map.count(curr_pos)){
	     if(valid_solution(solution,sequence_map,curr_pos,sequence)){
           solution = sequence + sequence_map[curr_pos];
		  }
	 }

    if(previous != LEFT_WHL_ANTI_CLKWISE){
        backtrack_and_solve(LEFT_WHL_CLKWISE,solution_depth+1,leftwheel_clockwise_rotation(curr_pos), sequence+'1');
	 }
    if(previous != RIGHT_WHL_ANTI_CLKWISE){
        backtrack_and_solve(RIGHT_WHL_CLKWISE,solution_depth+1,rightwheel_clockwise_rotation(curr_pos), sequence+'2');
	 }
    if(previous != LEFT_WHL_CLKWISE){
        backtrack_and_solve(LEFT_WHL_ANTI_CLKWISE,solution_depth+1,leftwheel_counterclockwise_rotation(curr_pos), sequence+'3');
	 }
    if(previous != RIGHT_WHL_CLKWISE){
        backtrack_and_solve(RIGHT_WHL_ANTI_CLKWISE,solution_depth+1,rightwheel_counterclockwise_rotation(curr_pos), sequence+'4');
	 }
}

inline bool valid_solution(string &solution,map<string,string> &sequence_map,string &curr_pos,string &sequence){
        return (solution == "0" || solution.size() > sequence.size() + sequence_map[curr_pos].size() || (sequence_map[curr_pos].size() == sequence.size()  + sequence_map[curr_pos].size() && sequence_map[curr_pos] > sequence));
}