// Last updated: 26/3/2026, 3:07:51 pm
1class Solution {
2   public static String reorganizeString(String s) {
3		int n = s.length();
4		int[][] freq = new int[26][2];
5		for (char ch : s.toCharArray()) {
6			freq[ch - 'a'][0]++;
7		}
8		for (int i = 0; i < 26; i++) {
9			freq[i][1] = i;
10		}
11
12		Arrays.sort(freq, (a, b) -> b[0] - a[0]);
13		
14		int max = freq[0][0];
15		int sum = 0;
16		for (int i = 1; i < 26; i++) {
17			sum += freq[i][0];
18		}
19		if (max > sum + 1) {
20			return "";
21		}
22		
23		char[] arr = new char[n];
24		int idx = 0;
25		int choose = 0;
26		for(int i = 0;i<n;i++) {
27			if(idx>=n) {
28				idx = 1;
29			}
30			char ch = (char)('a'+freq[choose][1] );
31			freq[choose][0]--;
32			if(freq[choose][0]<=0)choose++;
33			
34			arr[idx] = ch;
35			idx +=2;
36			
37		}
38		
39		StringBuilder sb = new StringBuilder();
40		for(char ch:arr) {
41			sb.append(ch);
42		}
43		return sb.toString();
44		
45		
46	}
47}