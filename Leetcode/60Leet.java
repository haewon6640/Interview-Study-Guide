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
