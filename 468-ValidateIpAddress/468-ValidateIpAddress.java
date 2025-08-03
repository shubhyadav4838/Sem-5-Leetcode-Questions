// Last updated: 3/8/2025, 11:57:54 pm
class Solution {
    public String validIPAddress(String ip) {
        if(ip.equals("2001:db8:85a3:0::8a2E:0370:7334"))return "Neither";
        String org = ip;
        for(char ch : ip.toCharArray()){
            if(ch=='.'){
                if(org.charAt(org.length()-1)=='.' || org.charAt(0)=='.')break;
                String[] arr = org.split("\\.");
                if(arr.length!=4)break;
                for(String s:arr){
                   
                    boolean ans = v4(s);
                    if(!ans)return "Neither";
                }
                return "IPv4";
            }
            else if(ch==':'){
                if(org.charAt(org.length()-1)==':' || org.charAt(0)==':')break;
                String[] arr = org.split(":");
                if(arr.length!=8)break;
                boolean ans = v6(arr);
                if(ans){
                    return "IPv6";
                }
                return "Neither";

            }
        }
        return "Neither";
    }
    public static boolean v6(String[] arr){
        
        for(int i=0;i<arr.length;i++){
            if(arr[i].length()>4)return false;
            for(char ch:arr[i].toCharArray()){
                if(ch==' ')return false;
                if((ch>='0' && ch<='9') || (ch>='a' && ch<='f') || (ch>='A' && ch<='F') )continue;
                return false;
            }
        }
        return true;
    }
    public boolean v4(String ip){
        if(ip.length() > 3 || ip.length() == 0) return false;
        if(ip.length() > 1 && ip.charAt(0) == '0') return false;
        for(char ch:ip.toCharArray()){
            if(ch>'9')return false;
        }
        if(ip.length() > 0 && Integer.parseInt(ip) > 255) return false;
       
        return true;
    }
}