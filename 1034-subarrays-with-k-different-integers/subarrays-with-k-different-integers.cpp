class Solution {
public:
    int countSubArr(vector<int> &nums, int k) {
        unordered_map<int,int> mp;
        int start = 0;
        int end = 0;
        int ans = 0;
        while(end < nums.size()){
            mp[nums[end]]++;

            while(mp.size() > k && start <= end){
                mp[nums[start]]--;
                if(mp[nums[start]] == 0) mp.erase(nums[start]);
                start++;
            } 

            ans += end - start + 1;
            end++;
        }

        return ans;
    }
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        
        return countSubArr(nums, k) - countSubArr(nums,k-1);
    }
};