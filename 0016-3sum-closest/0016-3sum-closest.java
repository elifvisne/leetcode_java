class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Diziyi sırala
        int closestSum = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int diff = Math.abs(sum - target);
                
                if (diff < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        return closestSum;
    }
    
}
