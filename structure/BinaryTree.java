package structure;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by wyy on 2/24/17.
 */
public class BinaryTree {

    private TreeNode root;
    public void BinaryTree(){

    }

    public static TreeNode sampleTree(){
        TreeNode root  = new TreeNode(0);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(17);
        return root;
    }

    public static void printTree(TreeNode root){
        if(root!=null){
            printTree(root.left);
            System.out.println(root.val);
            printTree(root.right);
        }
    }

    //leetcode_107   level order traverse and in reversed output
    public static List<List<Integer>> levelOrderBottom(TreeNode root){
        LinkedList<List<Integer>> result = new java.util.LinkedList<List<Integer>>();
        if(root==null) return result;
        ArrayList<Integer> level = new ArrayList<Integer>();
        Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        int curLevel =0, parentNum=1,childNum=0;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp.left!=null){
                queue.add(temp.left);
                childNum++;
            }
            if(temp.right!=null){
                queue.add((temp.right));
                childNum++;
            }
            parentNum--;
            level.add(temp.val);
            System.out.print(temp.val+" ");
            if(parentNum==0){
                curLevel++;
                System.out.println();
                parentNum=childNum;
                childNum=0;
                result.addFirst(level);
                level = new ArrayList<Integer>();  // new area in memory
            }

        }
        return result;
    }
    //leetcode_101 whether a binarytree is the mirror to itself
    public static boolean isSymmetric(TreeNode root){
        if(root==null) return true;
        return mutualSymmetric(root.left,root.right);

    }
    private static boolean mutualSymmetric(TreeNode x, TreeNode y){
        if(x==null&&y==null)
            return true;
        if(x==null||y==null)
            return false;
        return ((mutualSymmetric(x.left,y.right))&&(mutualSymmetric(x.right,y.left))&&(x.val==y.val));
    }

    //leetcode_110  Balanced Binary Tree
    // the depth of the two subtrees of every node never differ by more than 1
    public boolean isBalanced(TreeNode root){
        if(root==null) return true;
        if(Math.abs(getDepth(root.left)-getDepth(root.right))>1)
            return false;
        else
            return (isBalanced(root.left)&&isBalanced(root.right));

    }

    // the depth of a node in the binary tree
    public int getDepth(TreeNode root){
        if(root==null) return 0;
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }

    //leetcode_257 return all path (from root to leaves) in a binary tree
    // DFS +recursive
    public List<String> binaryTreePathsDFS(TreeNode root){
        ArrayList<String> result = new ArrayList<String>();
        if(root==null) return result;   //empty list
        if(root.left==null && root.right ==null){   //leaf only add itself
            result.add(Integer.toString(root.val));
        }
        if(root.left!=null){
            for(String subpath : binaryTreePathsDFS(root.left)){
                result.add(Integer.toString(root.val)+"->"+subpath);
            }
        }
        if(root.right!=null){
            for(String subpathr : binaryTreePathsDFS(root.right)){
                result.add(Integer.toString(root.val)+"->"+subpathr);
            }
        }
        return result;
    }
    //leetcode_257
    // BFS + queue
    public List<String> binaryTreePathsBFS(TreeNode root){
        List<String> result = new ArrayList<String>();
        LinkedList<TreeNode> nqueue = new LinkedList<TreeNode>();
        LinkedList<String> strqueue = new LinkedList<String>();
        if(root==null)
            return result;
        nqueue.add(root);
        strqueue.add("");
        while(!nqueue.isEmpty()){
            TreeNode temp = nqueue.remove();
            String subpath = strqueue.remove();
            if(temp.left==null&&temp.right==null){
                result.add(subpath+Integer.toString(temp.val));  //leaf
            }
            if(temp.left!=null){
                nqueue.add(temp.left);
                strqueue.add(subpath+Integer.toString(temp.val)+"->");
            }
            if(temp.right!=null){
                nqueue.add(temp.right);
                strqueue.add(subpath+Integer.toString(temp.val)+"->");
            }

        }
        return result;
    }

    //leetcode112 Path Sum
    //whether exists a path has certain sum value
    public boolean hasPathSum(TreeNode root, int sum){
        if(root==null) return false;
        if(root.val==sum&&root.left==null&&root.right==null)
            return true;
        return (hasPathSum(root.left,sum-root.val))||(hasPathSum(root.right,sum-root.val));

    }
    //leetcode437 Path Sum III
    //The path does not need to start or end at the root or a leaf,return the total number of paths
    public int pathSum(TreeNode root, int sum){
        if(root==null)
            return 0;
        return pathSumFrom(root,sum)+pathSumFrom(root.left,sum)+pathSumFrom(root.right,sum);

    }
    private int pathSumFrom(TreeNode root, int sum){
        if(root==null)
            return 0;
        int res = pathSumFrom(root.left,sum-root.val)+pathSumFrom(root.right,sum-root.val);
        if(root.val==sum)
            return res+1;
        else
            return res;
    }

    //leetcode111 minimum depth of binary tree
    public int minDepth(TreeNode root){
        if(root==null)
            return 0;
        if(root.left==null||root.right==null){
            return Math.max(minDepth(root.left),minDepth(root.right))+1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }

    //leetcode_124 Binary Tree Maximum Path Sum
    private int max;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        max = root.val;
        dfs(root);
        return max;

    }
    private int dfs(TreeNode root){
        if(root==null)  return 0;
        if(root.left==null && root.right==null){
            if(root.val>max)
                max=root.val;
            return root.val;
        }
        if(root.left==null){
            int rightsum = dfs(root.right);
            int result = (rightsum>0)?root.val+rightsum:root.val;
            max=Math.max(max,result);
            return result;
        }
        if(root.right==null){
            int leftsum = dfs(root.left);
            int res = (leftsum>0)?root.val+leftsum:root.val;
            max = Math.max(max,res);
            return res;
        }
        // else has both left and right child, choose the larger side
        int left = dfs(root.left);
        int right = dfs(root.right);
        int childSum = Math.max(left,right);

        if(left<0 && right<0){
            max = Math.max(max,root.val);
            return root.val;
        }
        if(left<0 || right<0){   //the bigger one > 0
            max = Math.max(max,childSum+root.val);
            return childSum+root.val;
        }
        // both > 0
        max = Math.max(max,root.val+left+right);
        return childSum+root.val;

    }

}
