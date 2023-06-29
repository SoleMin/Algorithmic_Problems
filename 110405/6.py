import sys;
T = int(sys.stdin.readline());
idx = 0;

while(idx < T):
	sys.stdin.readline()
	n = int(sys.stdin.readline());
	array = [];
	for i in range(n):
		array.append(list(map(int, sys.stdin.readline().split())))
	
	
	arr = []
	for i in range(n):
		arr.append([array[i][1]/ array[i][0], i+1])
		
		
	arr.sort(key=lambda x: -x[0]);
	
	ans = ""
	for i in range(n):
		ans += str(arr[i][1]) + " "
		
	print(ans + "\n")
	idx += 1;