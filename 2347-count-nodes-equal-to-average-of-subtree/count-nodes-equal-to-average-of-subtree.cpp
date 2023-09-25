/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    pair<int,int> solve(TreeNode *root, int &ans){
        if(root == nullptr){
            return {0,0};
        }

        pair<int,int> left = solve(root->left, ans);
        pair<int,int> right = solve(root->right, ans);

        int leftSum = left.first;
        int rightSum = right.first;

        int leftCount = left.second;
        int rightCount = right.second;

        int sum = leftSum + rightSum + root->val;
        int nodes = leftCount + rightCount + 1;
        if(sum / nodes == root->val){
            ans++;
        }

        return {sum, nodes};


    }
    int averageOfSubtree(TreeNode* root) {
        int ans = 0;
        solve(root, ans);

        return ans;
        
    }
};