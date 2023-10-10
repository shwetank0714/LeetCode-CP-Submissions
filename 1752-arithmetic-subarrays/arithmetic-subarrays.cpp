class Solution {
public:
    vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
        int m = l.size();
        int n = nums.size();
        vector<bool> ans(m, true);

        for(int i=0;i<m;i++){
            int first = l[i];
            int last = r[i];
            int newSize = last - first + 1;
            vector<int> newArr(newSize);
            if(newArr.size() <= 2) {
                continue;
            }
            for(int start = 0,j=first; j<=last;j++, start++){
                newArr[start] = nums[j];
            }

            sort(newArr.begin(), newArr.end());
            int commonDiff = newArr[1] - newArr[0];
            for(int j=0;j<newSize-1;j++){
                if(newArr[j] + commonDiff != newArr[j+1]){
                    ans[i] = false;
                    break;
                }
            }
        }

        return ans;
    }
};