class Solution {
    public int change(int amount, int[] coins) {
        
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        
        // Bottom Up
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1] <= j){
                    dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        //return dp[n][amount];

        // Space optimized
        int []curr = new int[amount+1];
        int []store = new int[amount+1];
        store[0] = 1;

        for(int i=1;i<=n;i++){
            curr[0] = 1;
            for(int j=1;j<=amount;j++){
                if(coins[i-1] <= j){
                    curr[j] = curr[j - coins[i-1]] + store[j];
                }
                else{
                    curr[j] = store[j];
                }
            }
            store = curr;
        }

        return store[amount];

    }
}