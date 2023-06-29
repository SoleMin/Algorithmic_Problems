import sys
from collections import deque
testcase = int(sys.stdin.readline())

def movements(people_list):
	if len(people_list) == 1:
		return [[people_list.pop()]]
	elif len(people_list) == 2:
		return [[people_list.pop(), people_list.pop()]]
	elif len(people_list) == 3:
		fast = people_list.popleft()
		return [[fast, people_list.pop()], [fast], [fast, people_list.pop()]]
	else:
		slow = people_list.pop()
		second_slow = people_list.pop()
		if people_list[1] * 2 < people_list[0] + second_slow:
			return [[people_list[0], people_list[1]], [people_list[0]], [slow, second_slow], [people_list[1]]]
		else:
			return [[people_list[0], second_slow], [people_list[0]], [people_list[0], slow], [people_list[0]]]

while testcase > 0:
	try:
		new_line = sys.stdin.readline()
		if new_line == '':
			pass
		n = int(sys.stdin.readline())
		p = sorted([int(sys.stdin.readline()) for _ in range(n)])
		total = 0
		wait = deque(p)
		while len(wait):
			move = movements(wait)
			total += sum(max(i) for i in move)
		print(total)
		
		if testcase > 0:
			print()
			testcase -= 1
	except EOFError:
		break
		