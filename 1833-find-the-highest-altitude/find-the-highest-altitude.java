class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int sum = 0;

        for(int i=0; i<gain.length; i++) {
            sum += gain[i];
            if(sum > ans) {
                ans = sum;
            }
        }

        return ans;
    }
}