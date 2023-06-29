one = '`1234567890-='
two = 'QWERTYUIOP[]\\'
three = 'ASDFGHJKL;'
four = 'ZXCVBNM,./'
while True:
	try:
		keyboard = input()
		answer = []
		for i in range(len(keyboard)):
			a = keyboard[i]
			if a == one[0]:
				answer.append(one[0])
			elif a == two[0]:
				answer.append(two[0])
			elif a == three[0]:
				answer.append(three[0])
			elif a == four[0]:
				answer.append(four[0])
			elif a == " ":
				answer.append(" ")
			if a in one:
				answer.append(one[one.find(a) - 1])
			elif a in two:
				answer.append(two[two.find(a) - 1])
			elif a in three:
				answer.append(three[three.find(a) - 1])
			elif a in four:
				answer.append(four[four.find(a) - 1])
		print("".join(answer))
	except EOFError:
		break
	