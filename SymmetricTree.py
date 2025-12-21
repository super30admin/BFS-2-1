'''
In this problem we need to find if the given binary tree is symmetric or not.
I used dfs recursive function to check the symmetry of the function, 
by checking the left and right side of the tree, using a boolean flag to check and update if the nodes are symmetric or not.
'''
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        if root is None:
            return True
        
        self.dfs(root.left, root.right)
        return self.flag
    # recursive function to check the left and right elements of the tree simultaneously
    def dfs(self, left, right):

        # if both nodes are null then return that the tree is symmetric
        if left is None and right is None:
            return
        # checking if the nodes exist or if they are symmetric
        if left is None or right is None or left.val != right.val:
            self.flag = False
            return

        self.dfs(left.left, right.right)
        self.dfs(left.right, right.left)
            

'''
Time Complexity: O(n)
Time taken to go through all the nodes is n/2 because we are checking 2 sides of the tree simultaneously, since constants can be ignored => O(n)
Space Complexity: O(h)
Space taken is equal to the height of the tree since we going deptth wise
'''