class Solution {
    public int bs(int[]arr, int k, int s, int e){
        if(s>e){
            return -1;
        }
        int mid= s+(e-s)/2;

        if(arr[mid]==k){
            return mid;
        }
        if(arr[s]<=arr[mid]){
            if(k>=arr[s] && k<=arr[mid]){
                return bs(arr,k,s,mid-1);
            }
            else{
                return bs(arr,k,mid+1,e);
            }
        }
        if(k>=arr[mid] && k<=arr[e]){
            return bs(arr,k,mid+1,e);
        }
        return bs(arr,k,s,mid-1);

    }
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        return bs(nums,target,start,end);
    }

}