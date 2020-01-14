import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class inorderTraversal {
    public static void main(String[] args) {
        TreeNode x = new TreeNode(5);
        x.left = new TreeNode(3);
        x.left.left = new TreeNode(2);
        x.left.right = new TreeNode(4);
        x.right = new TreeNode(6);
        x.right.right = new TreeNode(7);
        System.out.println(inorderIterative(x));
    }
    public static List<Integer> inorderRecursive(List<Integer> list, TreeNode root) {
        return null;
    }
    public static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                System.out.println(root.val);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            System.out.println(root.val);
            root = root.right;
            try {
                System.out.println(root.val);
            } catch(NullPointerException e) {
                System.out.println("null");
            }
            
        }
        return list;
    }
}