// Last updated: 30/12/2025, 1:15:14 am
1class Solution {
2    public int countSubstrings(String s) {
3        return countpalindrome(s);
4    }
5    public static int countpalindrome(String s) {
6		int even = 0;
7		int odd = s.length();
8		int n = s.length();
9		for(int i = 0;i<s.length();i++) {
10			for(int orbit = 1;i-orbit>=0 && i+orbit<n;orbit++) {
11				if(s.charAt(i-orbit)!=s.charAt(i+orbit)) {
12					break;
13				}
14                odd++;
15			}
16		}
17		for(double i = 0.5;i<s.length();i++) {
18			for(double orbit = 0.5;i-orbit>=0 && i+orbit<n;orbit++) {
19				if(s.charAt((int)(i-orbit))!=s.charAt((int)(i+orbit))) {
20					break;
21				}
22                even++;
23			}
24		}
25		return odd+even;
26	}
27
28}