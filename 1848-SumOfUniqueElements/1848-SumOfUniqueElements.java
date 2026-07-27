// Last updated: 27/7/2026, 11:44:56 am
class Solution {
    public int sumOfUnique(int[] nums) {
        return unique(nums);
    }
    public int unique(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        int sum = 0;
        for(int k: map.keySet()){
            if(map.get(k)==1)sum+=k;
        }
        return sum;
    }
}