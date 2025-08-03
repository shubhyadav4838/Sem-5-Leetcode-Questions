// Last updated: 4/8/2025, 12:00:30 am
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ludo = new ArrayList<>();
        restore(s,"",0,ludo);
        return ludo;
    }
    public void restore(String s, String ans, int dcount, List<String> ludo) {
		if (dcount == 4 && s.length() == 0) {
			ludo.add(ans.substring(0, ans.length() - 1));
		} else if (dcount > 3) {
			return;
		}
		for (int i = 0; i < s.length() && i<3; i++) {
			String st = s.substring(0, i + 1);
			if (isvalid(st)) {
				restore(s.substring(i+1), ans + st + ".", dcount + 1, ludo);
			}

		}
	}
    public boolean isvalid(String ip){
        if(ip.length() > 3 || ip.length() == 0) return false;
        if(ip.length() > 1 && ip.charAt(0) == '0') return false;
        if(ip.length() > 0 && Integer.parseInt(ip) > 255) return false;
       
        return true;
    }
    
}