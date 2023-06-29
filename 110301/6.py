import sys;
while(1):
	text = sys.stdin.readline().rstrip()
	if (len(text) == 0):
		break
	keyboard = [
		["`","1","2","3","4","5","6","7","8","9","0","-","="],
		["Q","W","E","R","T","Y","U","I","O","P","[","]"],
		["A","S","D","F","G","H","J","K","L",";","'"],
		["Z","X","C","V","B","N","M",",",".","/"]
	]
	
	ans =""
	for i in range(len(text)):
		if (text[i] == " "):
			ans += text[i]
			continue
		for j in range(4):
			if text[i] in keyboard[j]:
				ans += keyboard[j][keyboard[j].index(text[i]) - 1]
	
	
	print(ans)