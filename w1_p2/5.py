# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

try:
	while True:
		num = input()
		if num[0] != "0":
			hex_num=hex(int(num))[2::].upper()
			print("0x"+hex_num)
		else:
			print(int(num,base=16))
except:
	pass
