import sys;
lst = []
while(1):
	word = sys.stdin.readline().rstrip();
	if(len(word) == 0):
		break
	lst.append(word)
	
	
def check(a, b):
	count = 0
	
	if (len(a) != len(b)):
		return False
	
	for i in range(len(a)):
		if (a[i] != b[i]):
			count += 1
		if (count >= 2):
			return False
	
	if (count == 1):
		return True
	
	return False
	
	
while(1):
	pair = sys.stdin.readline().split();
	if (len(pair) == 0):
		break
	
	if(len(pair[0]) != len(pair[1])):
		print("No solution.")
		print("")
		continue
	
	newLst = lst.copy()
	flag = False
	q=[]
	q.append([pair[0]])


	while(len(q)):
		tmpLst = q.pop(0)	
		tmp = tmpLst[-1]
		newLst.remove(tmp)
		
		if (tmp == pair[1]):
			print("\n".join(tmpLst))
			print("")
			flag = True
			break
		
		
		for word in newLst:
			if (check(tmp, word)):
				q.append(tmpLst + [word])

		
	if(not flag):
		print("No solution.")
		print("")
		
		
		
		
	