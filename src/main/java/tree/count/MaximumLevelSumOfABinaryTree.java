package tree.count;

import commons.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161
 */
public class MaximumLevelSumOfABinaryTree
{
	class Solution
	{
		public int maxLevelSum(TreeNode root)
		{
			int max = Integer.MIN_VALUE;
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			int level = 0;
			int ret = 1;

			while (!q.isEmpty())
			{
				level++;
				int localsum = 0;
				int size = q.size();

				while (--size >= 0)
				{
					TreeNode t = q.poll();
					localsum += t.val;

					if (t.left != null)
					{
						q.add(t.left);
					}
					if (t.right != null)
					{
						q.add(t.right);
					}
				}

				if (localsum > max)
				{
					max = localsum;
					ret = level;
				}
			}

			return ret;
		}
	}
}