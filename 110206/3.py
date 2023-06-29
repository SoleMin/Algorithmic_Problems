import sys;
T = int(sys.stdin.readline())
idx = 0
while( idx < T):
	P, N = map(int, sys.stdin.readline().split())
	lst = [sys.stdin.readline() for _ in range(P)]
	authors = [sys.stdin.readline() for _ in range(N)]
	erdosNums = {
		"Erdos, P.": 0,
		
	}
	
	
	for text in lst:
		comma = 0
		start = 0
		authorList = []
		for i in range(len(text)):
			if (text[i] == ":"):
				authorList.append(text[start:i])
				break
			if (text[i] == ","):
				if (comma == 1):
					authorList.append(text[start:i])
					start = i + 2
					comma = 0
				else:
					comma = 1
		m = sys.maxsize
		for author in authorList:
			if author in erdosNums:
				if(m > erdosNums[author]):
					m = erdosNums[author]
		
		for author in authorList:
			if author in erdosNums:
				if (m < erdosNums[author]):
					erdosNums[author] = m + 1
			else:
				erdosNums[author] = m + 1		
	
	answer = []
	for author in authors:
		if (erdosNums[author.rstrip()] == sys.maxsize + 1):
			erdosNums[author.rstrip()] = "infinity"
		answer.append(author.rstrip() + " " + str(erdosNums[author.rstrip()]))
	
	print("Scenario %d" % (idx + 1))
	print("\n".join(answer))
	idx += 1