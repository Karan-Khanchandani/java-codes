TreeNode* ans(TreeNode* root, int val1, int val2){
    if(root==NULL)
        return NULL;
    
    if(root->val == val1 || root->val == val2){
        return root;
    }
    
    TreeNode* L = ans(root->left, val1, val2);
    TreeNode* R = ans(root->right, val1, val2);
    
    if(L&&R)
        return root;
        
    return L ? L : R;
    
}

bool find(TreeNode* root, int val){
    if(root==NULL)
        return false;
    
    if(root->val == val)
        return true;
        
    return find(root->left, val) || find(root->right, val) ;
}

int Solution::lca(TreeNode* A, int B, int C) {
    if(find(A, B) ==NULL || find(A, C) ==NULL)
        return -1;
        
    if(ans(A, B, C) !=NULL){
        return ans(A, B, C)->val;
    }
    
    return -1;
}
