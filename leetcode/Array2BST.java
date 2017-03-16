package leetcode;
import structure.TreeNode;
/**
 * Created by wyy on 2/23/17.
 */
public class Array2BST {


    public void printTree(TreeNode root){
        if(root!=null){
            System.out.println(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }

    private TreeNode recursiveBST(int[] arr, int lo, int hi){
        if(lo>hi)
            return null;
        if(lo==hi){
            TreeNode root = new TreeNode(arr[lo]);
            root.left=null;
            root.right=null;
            return root;
        }
        int mid = (lo+hi)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = recursiveBST(arr,lo,mid-1);
        root.right = recursiveBST(arr,mid+1,hi);
        return root;

    }

    public TreeNode sortedArrayToBST(int[] nums){
        if(nums.length==0)
            return null;
        return recursiveBST(nums,0,nums.length-1);

    }
}
