public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            permutations.addAll(permute(nums, 1));

            temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
        }

        if (permutations.isEmpty()) {
            permutations.add(new ArrayList<>());
        }

        return permutations;
    }

    private List<List<Integer>> permute(int[] nums, int start) {
        List<List<Integer>> permutations = new ArrayList<>();

        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }

            permutations.add(permutation);
            return permutations;
        }

        for (int i = start; i < nums.length; i++) {
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;

            permutations.addAll(permute(nums, start + 1));

            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }

        return permutations;
    }
}
