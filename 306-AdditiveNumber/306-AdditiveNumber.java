// Last updated: 4/1/2026, 11:10:15 pm
1class Solution {
2    public boolean isAdditiveNumber(String s) {
3        for (int i = 0; i < Math.min(s.length(), 18); i++) {
4			
5			for(int j = i+1;j<Math.min(s.length()-1, 18);j++) {
6				String a = s.substring(0,i+1);
7				String b = s.substring(i+1,j+1);
8                if(j+1==s.length())return false;
9                if(!isvalid(a) || !isvalid(b)) {
10			        continue;
11		        }
12				boolean ans = solve(a,b, s.substring(j+1));
13				if(ans==true) {
14					return true; 
15				}
16			}
17			
18		}
19		return false;
20    }
21    public static boolean solve(String a, String b, String s) {
22		System.out.println(s);
23		if (s.length() == 0) {
24			return true;
25		}
26		if(!isvalid(s)) {
27			return false;
28		}
29		int i = 1;
30		for (; i <= Math.min(s.length(), 17); i++) {
31			long sum = Long.parseLong(s.substring(0, i));
32			if (sum == (long) (Long.parseLong(a) + Long.parseLong(b))) {
33				boolean ans = solve(b, sum+"", s.substring(i));
34				if (ans)
35					return true;
36			}
37		}
38		return false;
39	}
40	
41	public static boolean isvalid(String s) {
42		if(s.length()<=1) {
43			return true;
44		}
45		boolean zero = false;
46		if(s.charAt(0)=='0') {
47			zero = true;
48		}
49		if(!zero)return true;
50		for(int i = 1;i<s.length();i++) {
51			if(s.charAt(i)!='0')return false;
52		}
53		return true;
54	}
55
56}