import java.util.*;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int n = arr.length;
        
        // Create sorted copy
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int chunks = 0;
        
        for (int i = 0; i < n; i++) {
            
            // Original array element frequency +1
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            
            // Sorted array element frequency -1
            map.put(sorted[i], map.getOrDefault(sorted[i], 0) - 1);
            
            
            // If frequency becomes 0, remove it
            if (map.get(arr[i]) == 0) {
                map.remove(arr[i]);
            }
            
            if (map.containsKey(sorted[i]) && map.get(sorted[i]) == 0) {
                map.remove(sorted[i]);
            }
            
            
            // Both prefixes have exactly same elements
            if (map.isEmpty()) {
                chunks++;
            }
        }
        
        return chunks;
    }
}