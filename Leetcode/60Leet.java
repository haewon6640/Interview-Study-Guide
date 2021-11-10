/*
* 
*
* https://leetcode.com/discuss/general-discussion/460599/blind-75-leetcode-questions
*/

/*
*
* Linked Lists
*
*/

/*
* Linked list Cycle
*/

public class Solution {
  public boolean hasCycle(ListNode head) {
      ListNode fast = head;
      ListNode slow = head;
      while (fast != null && fast.next != null && slow != null) {
          fast = fast.next.next;
          slow = slow.next;
          if (fast == slow) {
              return true;
          }
      }
      return false;
  }
}

/**
* Linked list Cycle II
**/
public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode cycleHead = head;
                while (cycleHead != slow) {
                    cycleHead = cycleHead.next;
                    slow = slow.next;
                }
                return cycleHead;
            }
        }
        return null;
    }
}


/*
*
* Trees
*
*/


/*
* Maximum Depth of Binary Tree
*/
public int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
}

/*
* Same Tree
*/
public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) { return true;}
    if ((p == null && q != null) || (p != null && q == null)) {
        return false;
    }
    return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
}
/*
* Invert Binary Tree
*/
public TreeNode invertTree(TreeNode root) {
    if (root == null) {
        return null;
    }
    final TreeNode left = root.left, right = root.right;
    root.left = invertTree(right);
    root.right = invertTree(left);
    return root;
}
/*
* Binary Tree Level Order Traversal
*/
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    dfs(res, root,0);
    return res;
}
public void dfs(List<List<Integer>> lst, TreeNode root, int height) {
    if (root == null) {
        return;
    }
    if (height == lst.size()) {
        lst.add(new LinkedList<Integer>());
    }
    lst.get(height).add(root.val);
    dfs(lst,root.left,height+1);
    dfs(lst,root.right, height+1);
    return;
}

/*
* Serialize and Deserialize Binary Tree
*/
public class Codec {
  private static final String spliter = ",";
  private static final String NN = "X";
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    buildString(root,sb);
    return sb.toString();
  }

  private void buildString(TreeNode node, StringBuilder sb) {
    if (node == null) {
        sb.append(NN).append(spliter);
    } else {
      sb.append(node.val).append(spliter);
      buildString(node.left,sb);
      buildString(node.right, sb);
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Deque<String> nodes = new LinkedList<>();
    nodes.addAll(Arrays.asList(data.split(spliter)));
    return buildTree(nodes);
  }
  private TreeNode buildTree(Deque<String> nodes) {
    String val = nodes.remove();
    if (val.equals(NN)) return null;
    else {
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }
  }
}

/*
* Subtree of Another Tree
*/

public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) {
        return false;
    }
    return sameTree(root,subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right,subRoot);
}
public boolean sameTree(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) {
        return true;
    }
    if (root == null && subRoot != null) {
        return false;
    }
    if (root != null && subRoot == null) {
        return false;
    }
    return root.val == subRoot.val && sameTree(root.left, subRoot.left) && sameTree(root.right,subRoot.right);
}
