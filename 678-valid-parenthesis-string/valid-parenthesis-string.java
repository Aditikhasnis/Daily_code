class Solution {
    public boolean checkValidString(String s) {


        int low = 0, high = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                low = Math.max(0, low - 1);
                high--;
            } else { // '*' can be '(' or ')' or ''
                low = Math.max(0, low - 1);
                high++;
            }

            if (high < 0) return false; // Too many ')'
        }

        return low == 0;
        
    }
}