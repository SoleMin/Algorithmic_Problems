import math
while True:
	people = input()
	money = []
	for i in range(int(people)):
		money.append(float(input()))
	if int(people) == 0:
		break
	average = sum(money) / len(money)
	
	move_money = []
	all_move = []
	for a in money:
			move_money.append(math.floor(100*(a - average)))
	for b in move_money:
		if (not b in all_move) and (b > 0):
			all_move.append(b/100)

	total = sum(all_move)
	print("$%.2f" %total)
	
	