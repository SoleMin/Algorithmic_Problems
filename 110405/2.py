from collections import namedtuple

TC = int(input())

for _ in range(TC):
	input()
	N = int(input())
	work = namedtuple('work', ['number', 'value'])
	work_list = []
	for i in range(N):
		T, S = input().split()
		work_list.append(work(i+1,float(T)/float(S)))
	
	work_list.sort(key=lambda x: x.value)
	for n, v in work_list:
		print(n, end=" ")
	print()
	print()