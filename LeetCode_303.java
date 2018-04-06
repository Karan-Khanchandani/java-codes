class NumArray {

    public int[] numbers;
    public int[] sum_till;
    public int[] sum_after_exc;
    
    public int total_sum;
    public boolean isEmpty;
    
    public NumArray(int[] nums) {
        
        
        if(nums == null || nums.length == 0){
            isEmpty = true;
        }else{
            numbers = nums;
        sum_till = new int[nums.length];
        sum_after_exc = new int[nums.length];
        
        total_sum = numbers[0];
        sum_till[0] = 0;
        //sum_after_exc[sum_after_exc.length - 1] = 0;
        
        for(int i = 1; i < numbers.length; i++){
            total_sum += numbers[i];
            
            sum_till[i] = sum_till[i-1] + numbers[i-1];
        }
        
        for(int i = 0; i < sum_after_exc.length; i++){
            sum_after_exc[i] = total_sum - (sum_till[i] + numbers[i]);
        }
        }
        
    }
    
    public int sumRange(int i, int j) {
        if(isEmpty){
            return 0;
        }
        if(i < 0){
            i = 0;
        }
        if(j > numbers.length - 1){
            j = numbers.length - 1;
        }
        return total_sum - sum_till[i] - sum_after_exc[j];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
