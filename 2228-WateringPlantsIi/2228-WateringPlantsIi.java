// Last updated: 27/7/2026, 11:44:22 am
class Solution {
    public int minimumRefill(int[] arr, int capa, int capb) {
        int count = 0;
        int n = arr.length;
        int st = 0;
        int ed = n-1;
        int watera = capa;
        int waterb = capb;
        while(st<=ed){
            if(st==ed){
                if(watera< arr[st] && waterb<arr[ed]){
                    count++;
                }
                break;
            }

            if(watera>=arr[st]){
                watera -= arr[st];
            }else{
                watera = capa-arr[st];
                count++;
            }

            if(waterb>=arr[ed]){
                waterb -= arr[ed];

            }else{
                waterb = capb - arr[ed];
                count++;
            }
            st++;
            ed--;
        }
       
        return count;
        
    }
}