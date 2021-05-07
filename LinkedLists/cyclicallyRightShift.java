// Write a program that takes as input a singly linked list and a nonnegative integer k, 
// and returns the list cyclically shifted to the right by k.
public static ListNode<Integer> cyclicallyRightShiftList(ListNode<Integer> L, int k) {
  if (L == null) {
    return L;
  }
  // Computes the length of L and the tail.
  ListNode<Integer> tail = L;
  int n = 1;
  while (tail.next != null) {
    ++n;
    tail = tail.next;
  }
  k %= n;
  if (k == 0) {
    return L;
  }
  tail.next = L; // Make a cycle by connecting the tail to the head.
  int stepsToNewHead = n-k;
  ListNode<Integer> newTail = tail;
  while (stepsToNewHead-- > 0) {
    newTail = newTail.next;
  }
  ListNode<Integer> newHead = newTail.next;
  newTail.next = null;
  return newHead;
}
