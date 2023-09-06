class Solution {
    // Recursive. + Memoization
    public int solve(String text1, String text2, int index1, int index2, int[][] dp){

        if(index1 == text1.length() || index2 == text2.length()) return 0;
        if(dp[index1][index2] != -1) return dp[index1][index2];
        int ans=0;
        if(text1.charAt(index1) == text2.charAt(index2)){
            ans = 1 + solve(text1, text2, index1+1, index2+1,dp);
        }
        else{
            ans = Math.max(
                solve(text1, text2, index1+1, index2,dp), 
                solve(text1, text2, index1, index2+1,dp)
                );
        }

        dp[index1][index2] = ans;

        return ans;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int [][]dp = new int[n+1][m+1];

        // for(int i=0;i<text1.length();i++){
        //     for(int j=0;j<text2.length();j++){
        //         dp[i][j] = ;
        //     }
        // }

        //return solve(text1, text2, 0, 0,dp);

        // Bottom Up solution

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];

        // Space optimized

        // int[] curr = new int[m+1];
        // int[] store = new int[m+1];

        // for(int i=1;i<=n;i++){
        //     curr[0] = 0;
        //     for(int j=1;j<=m;j++){
        //         if(text1.charAt(i-1) == text2.charAt(j-1)){
        //             curr[j] = 1 + store[j-1];
        //         }
        //         else{
        //             curr[j] = Math.max(store[j], curr[j-1]);
        //         }
        //     }
        //     store = curr;
        // }


        // return store[m];
        
    }
}