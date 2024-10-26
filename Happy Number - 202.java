// Write an algorithm to determine if a number n is happy.

// A happy number is a number defined by the following process:

// Starting with any positive integer, replace the number by the sum of the squares of its digits.
// Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
// Those numbers for which this process ends in 1 are happy.
// Return true if n is a happy number, and false if not.

 

// Example 1:

// Input: n = 19
// Output: true
// Explanation:
// 12 + 92 = 82
// 82 + 22 = 68
// 62 + 82 = 100
// 12 + 02 + 02 = 1
// Example 2:

// Input: n = 2
// Output: false
 

// Constraints:

// 1 <= n <= 231 - 1

class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int x = 0;
        while(true){
            x = sum(n);
            if(x == 1){
                return true;
            }
            else{
                hash.put(x, hash.getOrDefault(x, 0) + 1);
                if (hash.get(x) > 1){
                    return false;
                }
                else{
                    n = x;
                }
            }
        }
    }
    public int sum(int num){
        int res = 0;
        while(num != 0){
            res += (num%10) * (num%10);
            num /= 10;
        }
        return res;
    }
}
class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do{
            slow = sum(slow);           //at some point fast and slow will intersect.
            fast = sum(sum(fast));
        }while (slow != fast && fast != 1);

        return fast == 1;

    }
    public int sum(int num){
        int res = 0;
        while( num!=0){
            res += (num%10) * (num%10);
            num /= 10;
        }
        return res;
    }
}