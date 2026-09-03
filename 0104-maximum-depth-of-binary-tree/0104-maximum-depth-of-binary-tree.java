/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        // Queue<TreeNode> q=new LinkedList<>();
        // int level=0;
        // q.add(root);
        // while(!q.isEmpty()){
        //     int size=q.size();
        //     for(int i=0;i<size;i++){
        //         TreeNode curr=q.poll();
        //         if(curr.left!=null){
        //             q.add(curr.left);
        //         }
        //         if(curr.right!=null){
        //             q.add(curr.right);
        //         }
        //     }
        //     level++;
        // }
        // return level;
        return height(root);

    }

    public int height(TreeNode root){
        int level=0;
        if(root==null){
            return 0;
        }
        int leftsub=height(root.left);
        int rightsub=height(root.right);
        
        return Math.max(leftsub,rightsub)+1;
    }
}