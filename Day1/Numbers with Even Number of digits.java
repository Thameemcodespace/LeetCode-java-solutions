class Solution {
    public int findNumbers(int[] nums) {
        int total = 0;
        for(int b:nums)
        {
            int sum = 0;
            while(b > 0)
            {
                sum = sum + 1;
                b=b/10;
            }
            if(sum %2== 0)
            {
                total = total + 1;
            }
        }
        return total;
    }    
}
