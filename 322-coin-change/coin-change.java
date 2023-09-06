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

        long[][] dp = new long[n][amount+1];

        long ans = solve(coins, amount, 0, dp);

        if(ans >= Integer.MAX_VALUE) return -1;

        return (int)ans;
        
    }
}