# Last updated: 4/8/2025, 12:02:19 am
class Solution(object):
    def isPalindrome(self, x):
        rev = 0
        i=0
        while rev<x: 

            if x%10==0:
                break
            if i==0:
                a = x % 10
            else:
                a =int(x/10**i)
           
            rev = (rev*10)+(a%10)
            i+=1

        if rev==x:
            return True
        else:
            return False
        
        