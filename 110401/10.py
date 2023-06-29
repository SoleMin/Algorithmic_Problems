case = int(input())

for i in range(case):
	a = list(map(int,input().split()))
	a.remove(a[0])
	a.sort()
	t = len(a)
	
	mid = a[t//2]
	hap = 0
	for j in range(t):
		hap = hap + abs(mid - a[j])
	
	print(hap)
		
	