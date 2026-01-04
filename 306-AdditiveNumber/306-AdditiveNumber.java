// Last updated: 4/1/2026, 11:08:44 pm
1class Solution {
2    public boolean isAdditiveNumber(String s) {
3        for (int i = 0; i < Math.min(s.length(), 18); i++) {
4			
5			for(int j = i+1;j<Math.min(s.length()-1, 18);j++) {
6				String a = s.substring(0,i+1);
7				String b = s.substring(i+1,j+1);
8                if(j+1==s.length())return false;
9				boolean ans = solve(a,b, s.substring(j+1));
10				if(ans==true) {
11					return true; 
12				}
13			}
14			
15		}
16		return false;
17    }
18    public static boolean solve(String a, String b, String s) {
19		System.out.println(s);
20		if (s.length() == 0) {
21			return true;
22		}
23		if(!isvalid(a) || !isvalid(b) || !isvalid(s)) {
24			return false;
25		}
26		int i = 1;
27		for (; i <= Math.min(s.length(), 17); i++) {
28			long sum = Long.parseLong(s.substring(0, i));
29			if (sum == (long) (Long.parseLong(a) + Long.parseLong(b))) {
30				boolean ans = solve(b, sum+"", s.substring(i));
31				if (ans)
32					return true;
33			}
34		}
35		return false;
36	}
37	
38	public static boolean isvalid(String s) {
39		if(s.length()<=1) {
40			return true;
41		}
42		boolean zero = false;
43		if(s.charAt(0)=='0') {
44			zero = true;
45		}
46		if(!zero)return true;
47		for(int i = 1;i<s.length();i++) {
48			if(s.charAt(i)!='0')return false;
49		}
50		return true;
51	}
52
53}