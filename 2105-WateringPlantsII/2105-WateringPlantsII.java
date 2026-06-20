// Last updated: 20/6/2026, 12:22:58 pm
1class Solution {
2    public int minimumRefill(int[] arr, int capa, int capb) {
3        int count = 0;
4        int n = arr.length;
5        int st = 0;
6        int ed = n-1;
7        int watera = capa;
8        int waterb = capb;
9        while(st<=ed){
10            if(st==ed){
11                if(watera< arr[st] && waterb<arr[ed]){
12                    count++;
13                }
14                break;
15            }
16
17            if(watera>=arr[st]){
18                watera -= arr[st];
19            }else{
20                watera = capa-arr[st];
21                count++;
22            }
23
24            if(waterb>=arr[ed]){
25                waterb -= arr[ed];
26
27            }else{
28                waterb = capb - arr[ed];
29                count++;
30            }
31
32            st++;
33            ed--;
34        }
35
36        // if(st==ed){
37        //     if(watera>= arr[st] && waterb>=arr[ed]){
38        //         count++;
39        //     }
40        // }
41       
42        return count;
43        
44    }
45}