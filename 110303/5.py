import sys;
while(1):
	a = sys.stdin.readline().rstrip()
	b = sys.stdin.readline().rstrip()
	if (len(a) == 0):
		break
		
	bList = list(b)
		
	ans = []	
	for letter in a:
		if letter in bList:
			ans.append(letter)
			bList.remove(letter)
	
	ans.sort()
	
	print("".join(ans))
	