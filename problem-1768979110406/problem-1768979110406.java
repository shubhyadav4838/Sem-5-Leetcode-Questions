// Last updated: 21/1/2026, 12:35:10 pm
1class Solution {
2    public int minimizeXor(int num1, int num2) {
3		int set_bit = 0;
4		while (num2 > 0) {
5			num2 = (num2 & (num2 - 1));
6			set_bit++;
7		}
8
9		int x = 0;
10		for (int i = 30; i >= 0; i--) {
11			int mask = (1 << i);
12			if ((num1 & mask) != 0) {
13				x |= mask;
14				set_bit--;
15				if(set_bit==0)return x;
16			}
17		}
18		
19		for(int i = 0; i<=30; i++) {
20			int mask = (1 << i);
21			if ((num1 & mask) == 0) {
22				x |= mask;
23				set_bit--;
24				if(set_bit==0)return x;
25			}
26		}
27		return x;
28
29
30	}
31}