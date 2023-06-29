T = int(input())
for _ in range(T):
	result = 0
	lst = list(map(int,input().split()))
	mid = 0
	if len(lst) % 2 == 0:
		mid = len(lst) / 2
	else:
		mid = len(lst) // 2 + 1
	
	cnt = 0
	for i in range(1,len(lst)):
		cnt += abs(lst[int(mid)] - lst[i])
	print(cnt)
	

