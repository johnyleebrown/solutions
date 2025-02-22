package linkedList.other;

import commons.ListNode;

/**
 * 369
 */
public class PlusOneLinkedList {

	public static class Solution {

		public ListNode plusOne(ListNode head) {
			helper(head, head, true);
			return head;
		}

		boolean helper(ListNode head, ListNode cur, boolean flag) {
			if (cur == null) return false;
			if (cur.next == null) {
				if (cur.val == 9) {
					if (cur == head) {
						cur.val = 1;
					} else {
						cur.val = 0;
					}
					if (flag)
						cur.next = new ListNode(0);
					return true;
				} else {
					cur.val++;
					return false;
				}
			}
			boolean x = helper(head, cur.next, flag && cur.val == 9);
			if (x) {
				if (cur.val == 9) {
					if (cur == head) {
						cur.val = 1;
					} else {
						cur.val = 0;
					}
					return true;
				} else {
					cur.val++;
					return false;
				}
			}
			return false;
		}
	}
}