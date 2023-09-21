class Solution {
public:
    vector<string> v = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    int uniqueMorseRepresentations(vector<string>& words) {
        
        unordered_set<string> st;

        for(auto str : words){
            string temp = "";
            for(int i=0;i<str.length();i++){
                temp += v[str[i] - 'a'];
            }

            st.insert(temp);
        }

        return st.size();
    }
};