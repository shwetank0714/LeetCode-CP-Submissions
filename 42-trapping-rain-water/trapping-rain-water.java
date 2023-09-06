class Solution {
    public int trap(int[] height) {
        
        int i = 0;
        int j = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;
        while(i < j){
            if(height[i] <= height[j]){
                if(leftMax < height[i]){
                    leftMax = height[i];
                }
                totalWater += Math.abs(leftMax - height[i]);
                i++;
            }
            else{
                if(rightMax < height[j]){
                    rightMax = height[j];
                }
                totalWater += Math.abs(rightMax - height[j]);
                j--;
            }
        }

        return totalWater;
    }
}