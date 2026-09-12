class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n=nums1.length;
        int m=nums2.length;
        int i=0;int j=0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<n && j<m){
            while(i + 1 < n && nums1[i] == nums1[i + 1]) {
                    i++;
            }
            while(j + 1 < m && nums2[j] == nums2[j + 1]){
                j++;
            }
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums2[j]<nums1[i]){
                j++;
            }
            else{
                ans.add(nums1[i]);
                i++;
                j++;
            }
    
        }
        int[] result = new int[ans.size()];
        for(int k = 0; k < ans.size(); k++) {
            result[k] = ans.get(k);
        }

        return result;
    }
}