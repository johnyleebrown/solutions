package linkedList.other;

import commons.ListNode;

/**
 * 160
 */
public class IntersectionOfTwoLinkedLists {

	static class Solution {

		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			int lenA = length(headA), lenB = length(headB);

			// move headA and headB to the same start point
			while (lenA > lenB) {
				headA = headA.next;
				lenA--;
			}
			while (lenA < lenB) {
				headB = headB.next;
				lenB--;
			}
			// find the intersection until end
			while (headA != headB) {
				headA = headA.next;
				headB = headB.next;
			}
			return headA;
		}

		private int length(ListNode node) {
			int length = 0;
			while (node != null) {
				node = node.next;
				length++;
			}
			return length;
		}

		// O(m*n), O(n)
		public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
			if (headA == null || headB == null) return null;
			ListNode a = headA;
			ListNode b = headB;
			while (a != b) {
				a = a == null ? headB : a.next;
				b = b == null ? headA : b.next;
			}
			return a;
		}
	}
}