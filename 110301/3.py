keyboard = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./"


while True:
	try:
		line = input()
		for i in range(len(line)):
			if line[i] == ' ':
				continue
			elif line[i] == 'n':
				continue
			else:
				line = line[:i] + keyboard[keyboard.find(line[i]) - 1] + line[i + 1:]
		print(line)
	except EOFError:
		break