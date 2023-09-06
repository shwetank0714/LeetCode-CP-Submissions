class Solution {
    public int maxProduct(int[] nums) {
        
        int maxProd = Integer.MIN_VALUE;
        int pref = 1;
        int suff = 1;
        int n = nums.length;

        for(int i=0;i<n;i++){
            if(pref == 0) pref = 1;
            if(suff == 0) suff = 1;

            pref *= nums[i];
            suff *= nums[n - i - 1];

            maxProd = Math.max(maxProd, Math.max(suff, pref));
        }

        return maxProd;
    }
}