class Solution {
    public long solve(int[] coins, int amount, int index, long[][] dp){
        if(amount == 0) return 0;
        if(index == coins.length){
            return Integer.MAX_VALUE;
        }
        if(dp[index][amount] > 0) return dp[index][amount];

        long opt1 = Integer.MAX_VALUE;
        long opt2 = Integer.MAX_VALUE;

        if(coins[index] <= amount){
            opt1 = Math.min(
                1 + solve(coins, amount - coins[index], index,dp),
                solve(coins, amount, index+1,dp)
                );
        }
        else{
            opt2 = solve(coins, amount, index+1,dp);
        }
        dp[index][amount] = Math.min(opt1, opt2);
        return Math.min(opt1, opt2);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        long[][] dp = new long[n+1][amount+1];

        for(int i=0;i<=amount;i++){
            dp[0][i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<n;i++){
            dp[i][0] = 0;
        }

        // Bottom Up
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(
                        1 + dp[i][j - coins[i-1]],
                        dp[i-1][j]
                    );
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }


        // Space Optimized
        long[] store = new long[amount+1];
        long[] curr = new long[amount+1];

        for(int i=0;i<=amount;i++){
            store[i] = Integer.MAX_VALUE;
        }

        store[0] = 0; 
        for(int i=1;i<=n;i++){
            curr[0] = 0;
            for(int j=1;j<=amount;j++){
                if(j >= coins[i-1]){
                    curr[j] = Math.min(
                        1 + curr[j - coins[i-1]],
                        store[j]
                        );
                }
                else{
                    curr[j] = store[j];
                }
            }
            store = curr;
        }


        long ans = store[amount];
        //long ans = solve(coins, amount, 0, dp);

        if(ans >= Integer.MAX_VALUE) return -1;

        return (int)ans;
        
    }
}