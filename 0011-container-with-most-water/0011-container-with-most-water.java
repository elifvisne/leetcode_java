class Solution {
    public int maxArea(int[] height) {
        int maxCapacity = 0; 
        int left = 0;
        int right = height.length - 1; 

        while (left < right) { 
            int width = right - left;
            
            int minHeight = Math.min(height[left], height[right]);
            
            int capacity = width * minHeight;
            maxCapacity = Math.max(maxCapacity, capacity);

            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxCapacity;
    }
}
