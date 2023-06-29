# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

import sys

l = []
for i in sys.stdin:
	l.append(i.rstrip('\n'))

for i in l:
	if i[0] == '0':
		print(int(i,16))
	else:
		print('0x'+hex(int(i))[2:].upper() )
			
