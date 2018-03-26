class KthLargest {
    
    public static class TreeNode{
        public int val;
        public TreeNode left, right;
        
        public TreeNode(int val){
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    public TreeNode root;
    public int kth_largest;
    public int count = 0;
    
    public KthLargest(int k, int[] nums) {
        this.kth_largest = k;
        this.root = null;
        for(int i = 0; i < nums.length; i++){
            add(nums[i]);
        }
    }
    
    public TreeNode insert(TreeNode root, int val){
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
        
    }
    
    public int add(int val) {
        
        //insert 
        root = insert(root, val);
        //find
        
        inorder(root);
        System.out.println();
        int klarge = kth_largest;
        int[] ans = {0};
        count = 0;
        findKLarge(root, klarge, ans);
        
        return ans[0];
    }
    
    public void inorder(TreeNode root){
        if(root != null){
           inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }
    
    public void findKLarge(TreeNode root, int klarge, int ans[]){
        
        if(root == null || count >= klarge){
            return;
        }

           findKLarge(root.right, klarge, ans);
           count++;
           if(count == klarge){
               ans[0] = root.val;
               System.out.println(root.val);
               return;
           }
           
           findKLarge(root.left, klarge, ans);
           
        
        }
    }


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
