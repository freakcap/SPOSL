	START	100
A	DS	3
L1	MOVER	AREG,='5'
	ADD	AREG,C
	MOVEM	AREG,D
D	EQU	A+1
L2	PRINT	D
	ORIGIN	A+1
C	DC	'5'
	ORIGIN	L2+1
	STOP
B	DC	'19'
	END
