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


