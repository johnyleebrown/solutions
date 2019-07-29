package Medium.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

/**
 * 144
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */
public class BinaryTreePreorderTraversal 
{
	// recursive
	class Solution {
		private List<Integer> list = new ArrayList<>();

		public List<Integer> preorderTraversal(TreeNode root) {
			if (root == null) return new ArrayList<>();
			helper(root);
			return list;
		}
		
		private void helper(TreeNode root)
		{
			if (root == null) return;
			list.add(root.val);
			helper(root.left);
			helper(root.right);
		}
	}

	// iterative
	// using stack to store right nodes
	class Solution2 
	{    
		public List<Integer> preorderTraversal(TreeNode root) 
		{
			if (root == null) return new ArrayList<>();
			List<Integer> list = new ArrayList<>();
			Stack<TreeNode> st = new Stack<>();
			
			while (root != null || !st.isEmpty())
			{
				if (root != null)
				{
					list.add(root.val);
					if (root.right != null) st.push(root.right);
					root = root.left;    
				}
				else if (!st.isEmpty())
				{ 
					TreeNode r = st.pop();
					list.add(r.val);
					root = r.left;
					if (r.right != null) st.push(r.right);
				}
			}
			
			return list;
		}
	}
}

