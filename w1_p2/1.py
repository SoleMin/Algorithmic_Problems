# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
while True:
	try:
		s = input()
		if s[0] == '0':
			print(int(s, 16))
		else:
			print(f'0x{int(s):X}')
	except EOFError:
		break