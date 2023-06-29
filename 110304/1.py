T = int(input())
hint = 'the quick brown fox jumps over the lazy dog'
hint_length = [len(h) for h in hint.split()]
hint_ch = list(hint)
input()

for _ in range(T):
	sens = []
	while True:
		try:
			sen = input()
			if sen == "":
				break
			sens.append(sen)
		except EOFError:
			break
	dic = {}
	check = False

	for sen in sens:
		sen_length = [len(s) for s in sen.split()]
		sen_ch = list(sen)
		if hint_length == sen_length:
			if len(set(sen_ch)) != len(set(hint_ch)):
				continue
			for h, s in zip(hint, sen):
				dic[s] = h
			check = True
			break
		
	if check:
		for sen in sens:
			for s in sen:
				print(dic[s], end="")
			print()
	else:
		print("No solution.")
	print()
					
					
					
					
					
					
					
					
					
					
					
					
					
				