class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        if (nums == null || nums.length == 0) {
            return result;
        }

        int leftIdx = findPosition(nums, target, true);
        
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return result;
        }

        int rightIdx = findPosition(nums, target, false) - 1;

        result[0] = leftIdx;
        result[1] = rightIdx;

        return result;
    }

    private int findPosition(int[] nums, int target, boolean findLeft) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target || (findLeft && nums[mid] == target)) {
                right = mid;
            } 
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}
