import sys;
T = int(sys.stdin.readline())
sys.stdin.readline()
idx = 0
while( idx < T):
	textList = []
	while(1):
		text = (sys.stdin.readline().rstrip())
		if (len(text) == 0):
			break
		textList.append(text)
	
	existSolution = False
	plain = "the quick brown fox jumps over the lazy dog"
	
	dic = {}
	
	alpha = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j","k", "l", "m", "n", "o", "p", "q", "r", "s", "t","u","v","w","x","y","z"]
	
	for text in textList:
		if (len(text) == 43):
			plainList = plain.split()
			newTextList = text.split()
			if (len(plainList) == len(newTextList)):
				for i in range(len(newTextList)):
					if (len(newTextList[i]) != len(plainList[i])):
						break
				
				existSolution = True
				
				for i in range(len(text)):
					if (text[i] != " "):
						dic[text[i]] = plain[i]
				
	
	for a in alpha:
		if a not in dic:
			existSolution = False
	
	
	if(existSolution):
		ans = []
		for text in textList:
			newText = ""
			for i in range(len(text)):
				if (text[i] != " "):
					newText += dic[text[i]]
				else:
					newText += " "
			ans.append(newText)
		
		print("\n".join(ans) + "\n")
	else:
		print("No solution." + "\n")

	
	
	idx += 1