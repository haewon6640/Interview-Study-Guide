public class reverseKGroup{
    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        ListNode y = new ListNode(2);
        ListNode z = new ListNode(3);
        ListNode p = new ListNode(4);
        ListNode q = new ListNode(5);
        x.next = y;
        y.next = z;
        z.next = p;
        p.next = q;
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
    	ListNode x = head;
    	for (int i = 0; i < k; i++) {
    		if (head.next != null) {
    			
    		}
    	}
    	for (ListNode x = head; x != null; x = x.next) {
    		x
    	}
    }
}
public class ListNode {
	int val;
	ListNode next = null;
	ListNode(int x) {
		val = x;
	}
}