qwerty = ['`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', "'", 'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/']

while True:
	try:
		
		letter = input()
		output = []

		i = 0 
		while i < len(letter):
			if letter[i] == '`' or letter[i] == 'Q' or letter[i] == 'A' or letter[i] == 'Z' or letter[i] == ' ':
				output.append(letter[i])
			elif letter[i] in qwerty:
				seq = qwerty.index(letter[i])
				output.append(qwerty[seq-1])
			else:
				output.append(letter[i])

			i += 1

		print(''.join(output))
	except:
		break
		
