// Last updated: 3/8/2025, 11:58:19 pm
class Solution {
    public String originalDigits(String s) {
        return Digits(s);
    }
    public static String Digits(String s) {
		int[] freq = new int[26];
		ArrayList<Integer> ll = new ArrayList();
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			freq[(ch+0)-97]+=1;
			if(ch=='z') {
				ll.add(0);
				remove("zero",freq);
			}else if(ch=='w') {
				ll.add(2);
				remove("two",freq);
			}else if(ch=='x') {
				ll.add(6);
				remove("six",freq);
			}else if(ch=='g') {
				ll.add(8);
				remove("eight",freq);
			}
		}
		while(freq[('s'+0)-97]>0) {
			ll.add(7);
			remove("seven",freq);
		}
		while(freq[('t'+0)-97]>0) {
			ll.add(3);
			remove("three",freq);
		}
		while(freq[('v'+0)-97]>0) {
			ll.add(5);
			remove("five",freq);
		}
		while(freq[('f'+0)-97]>0) {
			ll.add(4);
			remove("four",freq);
		}
		while(freq[('o'+0)-97]>0) {
			ll.add(1);
			remove("one",freq);
		}
		while(freq[('n'+0)-97]>0) {
			ll.add(9);
			remove("nine",freq);
		}
		Collections.sort(ll);
		StringBuilder sv = new StringBuilder();
		for(int i=0;i<ll.size();i++) {
			sv.append(ll.get(i));
		}
		return sv.toString();
		
		
	}
	public static void remove(String s,int[] freq) {
		for(int i=0;i<s.length();i++) {
			freq[(s.charAt(i)+0)-97]-=1;
		}
	}
}