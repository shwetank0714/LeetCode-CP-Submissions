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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        // 1 -> left to right
        // 0 -> right to left
        bool directionFlag = true;
        vector<vector<int>> result;

        if(root == nullptr) return result;

        queue<TreeNode*> q;
        q.push(root);

        while(q.size()){
            int currSize = q.size();
            vector<int> levelNodes(currSize,0);
            
            for(int i=0; i<currSize; i++){
                auto node = q.front();
                q.pop();

                if(directionFlag) levelNodes[i] = node->val;
                else levelNodes[currSize - (i+1)] = node->val;

                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            directionFlag = !directionFlag;
            result.push_back(levelNodes);
        }

        return result;
        
    }
};