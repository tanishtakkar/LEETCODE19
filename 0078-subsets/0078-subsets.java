class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        solve(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    void solve(int index, int[] nums,
               List<Integer> curr,
               List<List<Integer>> ans){

        // Base Case
        if(index == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Take
        curr.add(nums[index]);
        solve(index+1, nums, curr, ans);

        // Backtracking
        curr.remove(curr.size()-1);

        // Not Take
        solve(index+1, nums, curr, ans);
    }
}