class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        
        if (n <= 1) {
            return 0;
        }
        
        int currentJumpEnd = 0;  
        int farthest = 0;  
        
        for (int i = 0; i < n; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
                if (farthest >= n - 1) {
                    return jumps;
                }
            }
        }
        
        return -1;  
    }
}
