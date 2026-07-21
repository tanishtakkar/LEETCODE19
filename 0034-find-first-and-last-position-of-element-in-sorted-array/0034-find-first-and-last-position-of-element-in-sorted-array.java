class Solution {
    public int[] searchRange(int[] nums, int target) {
        int arr2[]=new int[2];
        int first = firstocc(nums,target);
        int last = lastocc(nums,target);
        arr2[0]=first;
        arr2[1]=last;
        return arr2;
    }
     public int firstocc(int[] nums, int k) {
        int l=0;
        int u=nums.length-1;
        int ans=-1;
        while(l<=u){
            int mid= l+(u-l)/2;
            if(nums[mid]==k){
                ans=mid;
                u=mid-1;
            }
            else if(k<nums[mid]){
                u=mid-1;
            }
            else{
                l=mid+1;
            }
        }
         
         return ans;
    }
    public int lastocc(int[] nums, int k) {
        
        int l=0;
        int u=nums.length-1;
        int ans=-1;
        while(l<=u){
            int mid= l+(u-l)/2;
            if(nums[mid]==k){
                ans=mid;
                l=mid+1;
            }
            else if(k<nums[mid]){
                u=mid-1;
            }
            else{
                l=mid+1;
            }
        }
         
         return ans;
    }
}