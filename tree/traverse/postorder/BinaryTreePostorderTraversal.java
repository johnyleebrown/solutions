/*
 * 145
 * Facebook
 */
class BinaryTreePostorderTraversal
{
	/*
	 * Recursive.
	 */
	class Solution 
	{
		public List<Integer> postorderTraversal(TreeNode root) 
		{
			List<Integer> post = new LinkedList<>();
			postorderHelper(root, post);
			return post;
		}

		private void postorderHelper(TreeNode root, List<Integer> post) 
		{
			if (root == null)
			{
				return;
			}
			postorderHelper(root.left, post);
			postorderHelper(root.right, post);
			post.add(root.val);
		}
	}

	/*
	 * Iterative.
	 */
	class Solution 
	{
		public List<Integer> postorderTraversal(TreeNode root) 
		{
			if (root == null) 
			{
				return ans;
			}

			LinkedList<Integer> ans = new LinkedList<>();
			Stack<TreeNode> stack = new Stack<>();

			stack.push(root);
			while (!stack.isEmpty()) 
			{
				TreeNode cur = stack.pop();
				ans.addFirst(cur.val);
				
				if (cur.left != null) 
				{
					stack.push(cur.left);
				}

				if (cur.right != null) 
				{
					stack.push(cur.right);
				}
			}

			return ans;
		}
	}
}

