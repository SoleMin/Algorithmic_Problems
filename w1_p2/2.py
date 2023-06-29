# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
contents = []
while True:
	try:
		number = input()
	except EOFError:
		break
	contents.append(number)


for value in contents:
	if value.isdecimal():
		a=int(value)
		print(f"0x{a:X}")
	else:
		print(int(value, 16))